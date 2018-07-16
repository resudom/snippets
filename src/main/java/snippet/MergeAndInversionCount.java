package snippet;

import java.io.*;
import java.util.*;

public class MergeAndInversionCount {


    // Complete the countInversions function below.
    static long countInversions(int[] arr) {

        int[] aux = new int[arr.length];

        return mergeSortCountInversions(arr, aux, 0, arr.length-1);
    }

 /*   private static long mergeSortCountInversions(int[] arr, int[] aux, int start, int end) {

        if (start >= end) return 0;
        int mid = (start + end) / 2;
        long leftCount = mergeSortCountInversions(arr, aux, start, mid);
        long rightCount = mergeSortCountInversions(arr, aux, mid+1, end);
        long splitCount = mergeCountInversions(arr, aux, start, mid, end);

        return leftCount + rightCount + splitCount;
    }*/

    static long mergeSortCountInversions(int arr[], int[]aux, int start, int end) {

        // For current size of subarrays to
        // be merged curr_size varies from
        // 1 to n/2
        int curr_size;

        // For picking starting index of
        // left subarray to be merged
        int left_start;


        int inversions = 0;


        // Merge subarrays in bottom up
        // manner. First merge subarrays
        // of size 1 to create sorted
        // subarrays of size 2, then merge
        // subarrays of size 2 to create
        // sorted subarrays of size 4, and
        // so on.
        for (curr_size = 1; curr_size <= end; curr_size = 2*curr_size)
        {

            // Pick starting point of different
            // subarrays of current size
            for (left_start = 0; left_start < end; left_start += 2*curr_size)
            {
                // Find ending point of left
                // subarray. mid+1 is starting
                // point of right
                int mid = left_start + curr_size - 1;

                int right_end = Math.min(left_start + 2*curr_size - 1, end);

                // Merge Subarrays arr[left_start...mid]
                // & arr[mid+1...right_end]
                inversions += mergeCountInversions(arr, aux,  left_start, mid, right_end);
            }
        }
        return inversions;
    }

    private static long mergeCountInversions(int[] arr, int[] aux, int start, int mid, int end) {

        for (int i = start; i <= end; i++) {
            aux[i] = arr[i];
        }
        int i = start;
        int j = mid + 1;
        long inversion = 0;

        for (int k = start; k <= end; k++) {

            if (i > mid) {
                arr[k] = aux[j];
                j++;
            } else if (j > end) {
                arr[k] = aux[i];
                i++;
            } else if (aux[i] > aux[j]) {
                arr[k] = aux[j];
                inversion += mid - i + 1;
                j++;
            } else {
                arr[k] = aux[i];
                i++;

            }
        }
        return inversion;
    }

    private static final Scanner scanner = new Scanner("2\n" +
            "16\n" +
            "0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15\n" +
            "5\n" +
            "2 1 3 1 2");

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = countInversions(arr);
            System.out.println(result);

        }


        scanner.close();
    }
}
