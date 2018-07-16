package snippet;

import java.io.*;
import java.util.*;

public class LongestCommonSubsequence {

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {

        if (s1.isEmpty() || s2.isEmpty()) return 0;

        int[][] matrix = new int[s2.length() + 1][s1.length() + 1];

        for (int i = 0; i <= s2.length(); i++) {
            matrix[i][0] = 0;
        }
        for (int j = 0; j <= s1.length(); j++) {
            matrix[0][j] = 0;
        }

        for (int i = 1; i <= s2.length(); i++) {
            for (int j = 1; j <= s1.length(); j++) {

                if (s1.charAt(j - 1) == s2.charAt(i - 1)) {
                    matrix[i][j] = 1 + matrix[i - 1][j - 1];

                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }
        return matrix[s2.length()][s1.length()];
    }

    private static final Scanner scanner = new Scanner("ABCDEF\n" +
            "FBDAMN");

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

