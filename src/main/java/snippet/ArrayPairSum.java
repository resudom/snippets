package snippet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IVANMO on 25/7/2017.
 */
public class ArrayPairSum {

    public static void main(String[] args) {
       /* int[] input = new int[]{7,
                6,
                6,
                6,
                3,
                9,
                3,
                5,
                1
        };*/

        int[] input = new int[]{ 1, 2, 2, 2, 3, 4, 4, 4};
        SumPairs(input, 5);
        numberOfPairs(input, 12);
        arrayPairSum(input);
    }

    static public int arrayPairSum(int[] nums) {

        int result = 0;
        int[] numCount = new int[20001];
        Arrays.stream(nums).forEach(num -> numCount[num + 10000]++);

        int mem = 0;
        boolean alterFlag = false;

        for (int i = 0; i < 20001; i++) {

            while (numCount[i] > 0) {
                int part = i - 10000;
                if (alterFlag) {
                    result += part < mem ? part : mem;
                    alterFlag = false;
                } else {
                    mem = part;
                    alterFlag = true;
                }
                numCount[i]--;
            }
        }
        return result;
    }

    static int numberOfPairs(int[] a, long k) {

        HashMap<Integer, Integer> numMap = new HashMap<>();
        for(int num: a){
            Integer count = numMap.get(num);
            if(count==null){
                count =0;
            }
            numMap.put(num, count+1);
        }

        int res =0;

        for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {


            int compl = (int) (k - entry.getKey());
            if (numMap.get(compl) != null) {

                res += 1;
                numMap.put(entry.getKey(), null);
                numMap.put(compl, null);
            }
        }

        return res;
    }

    public static int SumPairs(int[] input, int k) {

        Map<Integer, Integer> pairs = new HashMap<Integer, Integer>();
        int tmp = 0;
        for (int data : input) {
            if (pairs.containsKey(k - data) && pairs.get(k - data) == 0) {
                tmp++;
                pairs.put((k - data), pairs.get(k - data) + 1);
            } else if (!pairs.containsKey(data)) {
                pairs.put(data, 0);
            }
        }

        return tmp;
    }
}
