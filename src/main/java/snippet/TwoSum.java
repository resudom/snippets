package snippet;


import java.util.HashMap;

public class TwoSum {

    protected int[] twoSum (int[] numbers, int target){

        int[] result = new int[2];
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        for (int i=0; i<numbers.length; i++){

            resultMap.put(numbers[i], i);
            int diff = target - numbers[i];
            if (resultMap.containsKey(diff)){
                result[0] = resultMap.get(diff);
                result[1] = i;
                break;
            }

        }
        return result;
    }

    protected ListNode addTwoNumbers(ListNode l1, ListNode l2){

        return null;
    }
}
