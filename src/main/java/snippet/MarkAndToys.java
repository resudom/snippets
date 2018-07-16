package snippet;

import java.io.*;
import java.util.*;

public class MarkAndToys {


    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {


        Arrays.sort(prices);

        int i;
        for (i = 0; i < prices.length; i++) {

            if(prices[i]<k) k-=prices[i];
            else break;
        }

        return i;
    }

    private static final Scanner scanner = new Scanner("7 50\n" +
            "1 12 5 111 200 1000 10");

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        int result = maximumToys(prices, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
