package snippet;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Pairs {


    // Complete the pairs function below.
    static int pairs(int k, int[] arr) {

        HashSet<Integer> set = new HashSet<>();
        for (Integer num : arr) {
            set.add(num);
        }
        int cnt = 0;
        for (Integer num : arr) {

            if (set.contains(num - k)) cnt++;
        }
        return cnt;
    }

    private static final Scanner scanner = new Scanner("5 2\n" +
            "1 5 3 4 2");

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
