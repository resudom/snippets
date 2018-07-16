package snippet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CoinChange {

    static int[] fib;
    Set<List<Integer>> coinSet = new HashSet<>();

    public static void main(String[] args) {

        int[] coin = {50, 10, 17, 21, 8, 3, 12, 41, 9, 13, 43, 37, 49, 19, 23, 28, 45, 46, 29, 16, 34, 25, 2 ,22, 1};
//        Arrays.sort(coin);
        System.out.println(coinChange2(85, coin));

        int n = 15;
        fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        System.out.println(fib(n, n));
    }

    public static long coinChange(int n, int[] coin) {

        long[] ways = new long[n + 1];
        ways[0] = 1;

        for (int c : coin) {

            for (int i = 1; i < ways.length; i++) {
                if (i >= c) {
                    ways[i] += ways[i - c];
                }
            }
        }
        return ways[n];
    }

    public static int coinChange2(int n, int[] coin) {

        int[][] ways = new int[coin.length + 1][n + 1];

        for(int i = 0; i<=coin.length; i++){
            ways[i][0] = 1;
        }

        for(int i = 1; i<=n; i++){
            ways[0][i] = 0;
        }

        for (int i = 1; i <= coin.length; i++) {
            for (int j = 1; j <= n; j++) {

                if (j >= coin[i - 1]) {
                    ways[i][j] = ways[i - 1][j] + ways[i][j - coin[i-1]];
                } else {
                    ways[i][j] = ways[i - 1][j];
                }
            }
        }
        return ways[coin.length][n];
    }

    public static int fib(int n, int level) {

        if (n == 0) {
            return fib[0];
        }
        if (n == 1) {
            return fib[1];
        }
        int fib1 = fib[n - 1] != 0 ? fib[n - 1] : fib(n - 1, level - 1);
        int fib2 = fib[n - 2] != 0 ? fib[n - 2] : fib(n - 2, level - 1);

        int res = fib1 + fib2;
        fib[n] = res;
        String result = String.valueOf(res);
        System.out.println(String.format("%1$" + (level + result.length()) + "s", result));
        return res;
    }
}
