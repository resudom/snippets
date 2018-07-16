package snippet;

import java.io.*;
import java.util.*;

public class ArrayMinDiff {


    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifference(int[] arr) {

        int res = Integer.MAX_VALUE;
        if(arr.length==0) return res;
        Arrays.sort(arr);
        for(int i=0; i<arr.length-1; i++){

            res = Math.min(res,Math.abs(arr[i]-arr[i+1]));
        }
        return res;
    }

    private static final Scanner scanner = new Scanner("10\n" +
            "-59 -36 -13 1 -53 -92 -2 -96 -54 75");

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

        int result = minimumAbsoluteDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

