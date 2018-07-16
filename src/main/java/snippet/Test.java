package snippet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String args[]) throws InterruptedException {

        Map<Integer, Integer> numberAndCount = new HashMap<>();

        int[] numbers = {3, 5, 7, 9, 11, 13, 17, 19, 2, 3, 5, 33, 12, 5};

        Integer [] nums = new Integer[]{3, 5, 7, 9, 11, 13, 17, 19, 2, 3, 5, 33, 12, 5};

        List l = Arrays.asList(nums);
        System.out.println(l.size());

        Arrays.asList(nums).stream().forEach(i -> System.out.print(i + " "));

//        System.out.println(Arrays.toString(numbers));

/*        for (int i : numbers) {
            int count = numberAndCount.get(i); // NullPointerException
            numberAndCount.put(i, count++);
        }*/

        int[] prices = {4,6,7,13,67,2,7,2,123,7,99};
        int maxProfit=0;
        int currMin=prices[0];
        for(int i=1; i<prices.length-1; i++){
            if(prices[i-1]>=prices[i]&&prices[i]<prices[i+1])
                currMin=prices[i];
            if(prices[i-1]<=prices[i]&&prices[i]>prices[i+1])
                maxProfit += prices[i]-currMin;
        }
        if(prices[prices.length-1]>currMin)
            maxProfit += prices[prices.length-1]-currMin;
    }

}