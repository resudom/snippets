package snippet;

import java.io.*;
import java.util.*;

public class MinSwapSort {


    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {

        int swaps = 0;
        for (int i = 0; i < arr.length; i++) {

            if (i != arr[i] - 1) {

                int k = arr[i] - 1;
                int tmp;
                do {

                    tmp = arr[k];
                    arr[k] = k + 1;
                    k = tmp - 1;
                    swaps++;

                } while (k != i);
                arr[tmp - 1] = tmp;
            }
        }
        return swaps;
    }

    private static final Scanner scanner = new Scanner("5\n" +
            "2 3 4 1 5");

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }


}
