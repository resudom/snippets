package snippet;

import java.io.*;
import java.util.*;

public class ValidString {

    // Complete the isValid function below.
    static String isValid(String s) {

        int[] charMap = new int[26];
        int i = 0;

        for (char c : s.toCharArray()) {
            charMap[c - 'a']++;
        }

        Arrays.sort(charMap);
        String result = "YES";
        while (i < charMap.length && charMap[i] == 0) i++;
        if(i<charMap.length && charMap[i] == 1) i++;
        while(i<charMap.length - 1){
            if(charMap[i]!=charMap[i+1]) result = "NO";
            i++;
        }
        return result;
    }

    private static final Scanner scanner = new Scanner("aabbc");

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

