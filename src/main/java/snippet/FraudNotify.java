package snippet;

import java.io.*;
import java.util.*;

public class FraudNotify {

    static int activityNotifications(int[] expenditure, int d) {

        int res = 0;

        if (expenditure.length <= d) return res;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < expenditure.length-1; i++) {

            if (maxHeap.size()==0 && minHeap.size() == 0) {
                maxHeap.offer(expenditure[i]);
            } else if ( maxHeap.size() > minHeap.size()) {
                if (maxHeap.peek() > expenditure[i]) {
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(expenditure[i]);
                } else {
                    minHeap.offer(expenditure[i]);
                }
            } else if ( maxHeap.size() < minHeap.size()) {
                if (minHeap.peek() < expenditure[i]) {
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(expenditure[i]);
                } else {
                    maxHeap.offer(expenditure[i]);
                }
            } else if (maxHeap.size() == minHeap.size()) {
                if (maxHeap.peek() > expenditure[i]) {
                    maxHeap.offer(expenditure[i]);
                } else if (minHeap.peek() < expenditure[i]) {
                    minHeap.offer(expenditure[i]);
                } else {
                    maxHeap.offer(expenditure[i]);
                }
            }

            if (i >= d-1) {

                double median;
                if (d % 2 == 0) {
                    median = (double) (maxHeap.peek() + minHeap.peek()) / 2;
                } else {
                    if (maxHeap.size() > minHeap.size()) {
                        median = maxHeap.peek();
                    } else {
                        median = minHeap.peek();
                    }
                }

                if(expenditure[i+1]>=median*2) res++;
                int first = expenditure[i-d+1];

                if(maxHeap.peek()>=first){
                    maxHeap.remove(first);
                }else{
                    minHeap.remove(first);
                }

                if(maxHeap.size()-minHeap.size()>1){
                    minHeap.offer(maxHeap.poll());
                }else if (minHeap.size()-maxHeap.size()>1){
                    maxHeap.offer(minHeap.poll());
                }

            }
        }
        return res;
    }

    // Complete the activityNotifications function below.
/*    static int activityNotifications(int[] expenditure, int d) {

        int res = 0;

        if (expenditure.length <= d) return res;

        int[] expSet = new int[d];
        for (int i = 0; i < d; i++) {
            expSet[i] = expenditure[i];
        }
        Arrays.sort(expSet);
        for (int i = 0; i < expenditure.length - d; i++) {

            double median = calcMedian(expSet);
            if (expenditure[i+d] >= median * 2) res++;

            findAndSwapFirst(expenditure, expSet, i);

            insertSort(expSet);
        }
        return res;
    }*/

    private static void insertSort(int[] expSet) {

        for (int i = expSet.length - 2; i >= 0; i--) {

            int j = i;
            int tmp = expSet[i];
            while (j < expSet.length - 1 && expSet[j + 1] < tmp) {
                expSet[j] = expSet[j + 1];
                j++;
            }
            expSet[j] = tmp;
        }
    }


    private static double calcMedian(int[] expSet) {

        double res = 0;
        if (expSet.length == 0) return res;
        if (expSet.length % 2 == 0) {
            res = (double) (expSet[expSet.length / 2] + expSet[expSet.length / 2 - 1]) / 2;
        } else {
            res = expSet[expSet.length / 2];
        }
        return res;
    }

    private static void findAndSwapFirst(int[] expenditure, int[] expSet, int startInd) {

        int endInd = startInd + expSet.length;
        for (int i = 0; i < expSet.length; i++) {

            if (expSet[i] == expenditure[startInd]) {
                expSet[i] = expenditure[endInd];
                break;
            }
        }
    }

    private static Scanner scanner = null;


    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File(FraudNotify.class.getClassLoader().getResource("expenditure.txt").getFile()));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

//        insertSort(expenditure);

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
