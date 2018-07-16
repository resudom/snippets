package snippet;

import java.io.*;
import java.util.*;

public class ArraySumManipulation {


    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {

        long[] cumulativeArr = new long[n];

        for (int i = 0; i < queries.length; i++) {

            int left = queries[i][0];
            int right = queries[i][1];
            int add = queries[i][2];
            left--;
            cumulativeArr[left] += add;
            if (right < n) cumulativeArr[right] -= add;
        }

        long max = Long.MIN_VALUE;
        long curr = 0;
        for (int i = 0; i < cumulativeArr.length; i++) {
            curr += cumulativeArr[i];
            max = Math.max(max, curr);
        }
        return max;
    }

    private static final Scanner scanner = new Scanner("10 4\n" +
            "2 6 8\n" +
            "3 5 7\n" +
            "1 8 1\n" +
            "5 9 15");

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

