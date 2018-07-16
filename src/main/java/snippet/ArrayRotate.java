package snippet;

import java.util.Arrays;

public class ArrayRotate {

    public static void main(String[] args) {


        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

        rotLeft(arr, 4);
        System.out.println(Arrays.toString(arr));
    }

    public static void rotate1(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    public static void rotate2(int[] nums, int k) {

        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

    public static void rotateLeft2(int[] nums, int k) {

        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(nums.length - k + i) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

    public static void rotate3(int[] nums, int k) {

        k = k % nums.length;
        int count = 0;

        for (int start = 0; count < nums.length; start++) {

            int prev = nums[start];
            int next;
            int current = start;
            do {
                current = (current + k) % nums.length;
                next = nums[current];
                nums[current] = prev;
                prev = next;
                count++;
            } while (start != current) ;
        }
    }

    static int[] rotLeft(int[] a, int d) {

        d=d%a.length;
        int count = 0;

        for(int start=a.length-1; count<a.length; start--){

            int next;
            int prev = a[start];
            int current = start;

            do {
                current = (current-d + a.length)%a.length;

                next = a[current];
                a[current] = prev;
                prev = next;
                count++;

            } while (current!=start);
        }

        return a;
    }

}
