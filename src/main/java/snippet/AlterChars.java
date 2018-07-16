package snippet;

import java.io.*;
import java.util.*;

public class AlterChars {


    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {

        int cnt = 0;
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        while (i < sb.length() - 1) {

            if (sb.charAt(i)==sb.charAt(i+1)){
                sb.deleteCharAt(i+1);
                cnt++;
            }
            else i++;
        }
        return cnt;
    }

    private static final Scanner scanner = new Scanner("5\n" +
            "AAAA\n" +
            "BBBBB\n" +
            "ABABABAB\n" +
            "BABABA\n" +
            "AAABBB");

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }

}