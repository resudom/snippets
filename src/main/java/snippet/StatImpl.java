package snippet;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

interface Stat {
    void bump(String counter);

    long get5s(String counter);

    long get15s(String counter);

    long get60s(String counter);
}

// For example, if you receive get request to get user by id then you bump metric metrics.bump("get.user"); The technical requirement for stat system that number of bump could be huge (millions) but number of getXs is limited.
// When you call metrics.get5s("get.user") you should receive the accurate number of get requests for the last 5 seconds from now.


public class StatImpl implements Stat{

    HashMap<String, LinkedList<Long>> counterMap = new HashMap<>();

    StatImpl() {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                for (Map.Entry<String, LinkedList<Long>> entry : counterMap.entrySet()) {

                    LinkedList<Long> counterList = entry.getValue();
                    if (null==counterList) {
                        entry.setValue(new LinkedList<>()).add(Long.valueOf(0));
                        continue;
                    }
                    counterList.addFirst(counterList.getFirst());
                    if (counterList.size()>61){
                        counterList.removeLast();
                    }
                }
            }
        };

        executor.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);
    }

    public void bump(String counter) {

        counterMap.putIfAbsent(counter, new LinkedList<>()).add(Long.valueOf(1));
        counterMap.compute(counter, (key, counterList) -> {

                    Long oldCounterValue = counterList.removeFirst();
                    counterList.addFirst(oldCounterValue + 1);
                    return counterList;
                }
        );
    }

    public long get5s(String counter) {
        LinkedList<Long> counterList = counterMap.get(counter);
        if(counterList == null)  return 0;
        return counterList.getFirst() - counterList.get(5);
    }

    public long get15s(String counter){
        LinkedList<Long> counterList = counterMap.get(counter);
        if(counterList == null)  return 0;
        return counterList.getFirst() - counterList.get(15);
    }

    public long get60s(String counter){
        LinkedList<Long> counterList = counterMap.get(counter);
        if(counterList == null)  return 0;
        return counterList.getFirst() - counterList.getLast();
    }

}