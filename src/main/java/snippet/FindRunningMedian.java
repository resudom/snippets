package snippet;

import java.util.PriorityQueue;

public class FindRunningMedian {


    public static void main(String[] args) {

        RunningMedian rm = new RunningMedian();
        int[] input = {12, 4, 5, 3, 8, 7};
        for(int n: input){

            System.out.format("%.1f\n", rm.findRunningMedian(n));

        }
    }
}

class RunningMedian {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x,y)-> y-x);

    public double findRunningMedian(int input){

        double res;
        int minSize = minHeap.size();
        int maxSize = maxHeap.size();

        if(minSize==0 && maxSize==0){
            maxHeap.offer(input);
            res =(double)input;
        }

        else if(maxSize>minSize){

            if(maxHeap.peek()>input){
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(input);
            }
            else {
                minHeap.offer(input);
            }

            res = (double) (minHeap.peek()+maxHeap.peek())/2;
        }

        else if (maxSize<minSize){

            if(minHeap.peek()<input){
                maxHeap.offer(minHeap.poll());
                minHeap.offer(input);
            }
            else {
                maxHeap.offer(input);
            }
            res = (double) (minHeap.peek()+maxHeap.peek())/2;
        }

        else {

            if(maxHeap.peek()>input){
                maxHeap.offer(input);
                res = (double) maxHeap.peek();
            }
            else {
                minHeap.offer(input);
                res = (double) minHeap.peek();
            }
        }

        return res;
    }
}
