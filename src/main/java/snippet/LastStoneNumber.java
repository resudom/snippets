package snippet;

import java.io.*;
import java.util.*;

public class LastStoneNumber {


    // Complete the stones function below.
    static int[] stones(int n, int a, int b) {

//        long count = power(2, n - 1);

        int stepMax = a < b ? b : a;
        int stepMin = a < b ? a : b;

        int stonesCurr = stepMin * (n - 1);
        int stonesMax = stepMax * (n - 1);
        ArrayList<Integer> res = new ArrayList<>();
        while (stonesCurr < stonesMax) {

            res.add(stonesCurr);
            stonesCurr += (stepMax - stepMin);
        }
        res.add(stonesMax);
        int size = res.size();
        int[] resArr = new int[size];
        for (int i = 0; i < size; i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }

    private static long power(long i, int pow) {

        long res = 1;
        while (pow > 0) {
            if (pow % 2 == 1) res *= i;
            pow >>= 1;
            i *= i;
        }
        return res;
    }

    private static final Scanner scanner = new Scanner("5\n" +
            "58\n" +
            "69\n" +
            "24\n" +
            "83\n" +
            "86\n" +
            "81\n" +
            "73\n" +
            "25\n" +
            "25\n" +
            "12\n" +
            "73\n" +
            "82\n" +
            "5\n" +
            "3\n" +
            "23");

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int a = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int b = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = stones(n, a, b);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }


}
