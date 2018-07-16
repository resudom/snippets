package snippet;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MaxConnCell {


    // Complete the maxRegion function below.
    static int maxRegion(int[][] grid) {

        int max = 0;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {

                if (grid[i][j] > 0) {
                    max = Math.max(dfs(grid, i, j), max);
                }
            }
        }
        return max;
    }

    private static int dfs(int[][] grid, int row, int col) {

        int rowLen = grid.length;
        int colLen = grid[0].length;
        grid[row][col] = -grid[row][col];
        int elemFlatOrder = colLen * row + col;
        int count = 1;

        ArrayDeque<Integer> st = new ArrayDeque<>();
        st.push(elemFlatOrder);

        while (!st.isEmpty()) {

            elemFlatOrder = st.pop();
            col = elemFlatOrder % colLen;
            row = elemFlatOrder / colLen;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) continue;
                    if (row + i >= 0 && col + j >= 0 && row + i < rowLen && col + j < colLen
                            && grid[row + i][col + j] > 0) {
                        grid[row + i][col + j] = -grid[row + i][col + j];
                        elemFlatOrder = colLen * (row + i) + col + j;
                        st.push(elemFlatOrder);
                        count++;
                    }
                }
            }

        }
        return count;
    }

    private static final Scanner scanner = new Scanner("7\n" +
            "8\n" +
            "1 0 0 1 0 1 0 0\n" +
            "0 0 0 0 0 0 0 1\n" +
            "1 0 1 0 1 0 0 0\n" +
            "0 0 0 0 0 0 1 0\n" +
            "1 0 0 1 0 0 0 0\n" +
            "0 0 0 0 0 0 0 1\n" +
            "0 1 0 0 0 1 0 0");

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] gridRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int gridItem = Integer.parseInt(gridRowItems[j]);
                grid[i][j] = gridItem;
            }
        }

        int res = maxRegion(grid);
        System.out.println(res);
/*

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();
*/

        scanner.close();
    }
}
