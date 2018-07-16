package snippet;

import java.util.*;

public class SwapCount {

    // Complete the countSwaps function below.
    static void countSwaps(int[] a) {

        int swapCnt = 0;
        for (int i = a.length; i > 0; i--) {

            boolean swapFlag = false;
            for (int j = 0; j < i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swapCnt++;
                    swapFlag = true;
                    a[j] = a[j] ^ a[j + 1];
                    a[j + 1] = a[j] ^ a[j + 1];
                    a[j] = a[j] ^ a[j + 1];
                }
            }
            if (!swapFlag) break;
        }
        System.out.println("Array is sorted in " + swapCnt + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length - 1]);
    }

    private static final Scanner scanner = new Scanner("3\n" +
            "3 2 1");

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        countSwaps(a);

        scanner.close();
    }
}
