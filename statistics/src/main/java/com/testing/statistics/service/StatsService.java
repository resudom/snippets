package com.testing.statistics.service;

import com.testing.statistics.model.Statistics;
import com.testing.statistics.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class StatsService implements Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(StatsService.class);

    private ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    private PriorityQueue<Double> minHeap = new PriorityQueue<>(16, (x, y) -> x.compareTo(y) );
    private PriorityQueue<Double> maxHeap = new PriorityQueue<>(16, (x, y) -> y.compareTo(x) );
    private HashMap<Double, Long> amountCounterMap = new HashMap<>();
    private final Object lock = new Object();

    private Statistics statistics = new Statistics();

    @Override
    public boolean addTransaction(Transaction transaction) {

        LOGGER.debug("Receiving transaction: " + transaction);
        long currentTime = System.currentTimeMillis();
        long transactionOffset = currentTime - transaction.getTimestamp();

        if (transactionOffset > 60000) {
            LOGGER.debug("Transaction older than 60 sec. Returning 204 HTTP Code.");
            return false;
        }

        synchronized (lock) {

            Double currAmount = transaction.getAmount();

            //Update Amount Counter Map in order to track quantity of specific transaction's amount
            Long amountCount = amountCounterMap.get(currAmount);
            if (null == amountCount) amountCount = 0L;
            amountCounterMap.put(currAmount, ++amountCount);
            minHeap.offer(currAmount);
            maxHeap.offer(currAmount);

            if (statistics.getMin() > currAmount) {
                statistics.setMin(currAmount);
            }

            if (statistics.getMax() < currAmount) {
                statistics.setMax(currAmount);
            }

            statistics.setSum(statistics.getSum() + currAmount);
            statistics.setCount(statistics.getCount() + 1);
            statistics.setAvg(statistics.getSum() / statistics.getCount());

            //Schedule update statistics information when the transaction becomes older then 60 sec.
            scheduler.schedule(new UpdateTransactionStatistics(transaction), 60000 - transactionOffset, TimeUnit.MILLISECONDS);
        }
        return true;
    }

    @Override
    public Statistics getStatistics() {

        synchronized (lock) {

            LOGGER.debug("Returning statistic: " + statistics);
            if (statistics.getMin() == Double.MAX_VALUE) statistics.setMin(0);
            if (statistics.getMax() == Double.MIN_VALUE) statistics.setMin(0);
            return statistics;
        }
    }

    class UpdateTransactionStatistics implements Runnable {

        private Transaction transaction;

        UpdateTransactionStatistics(Transaction transaction) {
            this.transaction = transaction;
        }

        @Override
        public void run() {

            synchronized (lock) {

                LOGGER.debug("Current timestamp: " + System.currentTimeMillis());
                Double transactionAmount = transaction.getAmount();
                LOGGER.debug("Transaction with amount: " + transactionAmount + ", and timestamp: " + transaction.getTimestamp() + " becomes obsolete.");

                //Update Amount Counter Map in order to track quantity of specific transaction's amount
                Long amountCount = amountCounterMap.get(transactionAmount);
                amountCounterMap.put(transactionAmount, --amountCount);
                LOGGER.debug("Reduced Amount counter :" + amountCount + " for amount: " + transactionAmount);

                statistics.setCount(statistics.getCount() - 1);
                statistics.setSum(statistics.getSum() - transactionAmount);

                if (statistics.getSum() != 0 && statistics.getCount() != 0) {

                    statistics.setAvg(statistics.getSum() / statistics.getCount());
                    //Update minimum
                    if (transactionAmount.equals(minHeap.peek())) {
                        LOGGER.debug("Obsolete transaction has minimum amount: " + transactionAmount);
                        while (amountCounterMap.get(minHeap.peek()) == 0) {
                            LOGGER.debug("Empty counter for amount: " + minHeap.peek() + ". Deleting amount from MinHeap.");
                            minHeap.poll();
                        }
                        LOGGER.debug("Updated Statistics Min: " + minHeap.peek());
                        statistics.setMin(minHeap.peek());
                    }
                    //Update maximum
                    if (transactionAmount.equals(maxHeap.peek())) {
                        LOGGER.debug("Obsolete transaction has maximum amount: " + transactionAmount);
                        while (amountCounterMap.get(maxHeap.peek()) == 0) {
                            LOGGER.debug("Empty counter for amount: " + maxHeap.peek() + ". Deleting amount from MaxHeap.");
                            maxHeap.poll();
                        }
                        LOGGER.debug("Updated Statistics Max: " + maxHeap.peek());
                        statistics.setMax(maxHeap.peek());
                    }

                } else {

                    LOGGER.debug("Set statistics Avg:0, Min:" + Double.MAX_VALUE + ", Max:" + Double.MIN_VALUE );
                    statistics.setAvg(0);
                    statistics.setMin(Double.MAX_VALUE);
                    statistics.setMax(Double.MIN_VALUE);
                }
            }
        }
    }
}
