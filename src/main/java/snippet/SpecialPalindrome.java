package snippet;

import java.io.*;
import java.util.*;

public class SpecialPalindrome {


    // Complete the substrCount function below.
    static long substrCount(int n, String s) {

        if (s.length() == 0) return 0;
        long res = 0;


        int cnt = 1;
        ArrayList<Pair> parts = new ArrayList<>();
        char prev = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {

            char curr = s.charAt(i);
            if (curr == prev) {
                cnt++;
            } else {
                Pair part = new Pair(prev, cnt);
                parts.add(part);
                prev = curr;
                cnt = 1;
            }
        }
        parts.add(new Pair(prev, cnt));

        if (parts.size() > 2) {

            int iterations = parts.size() - 2;
            Pair prevPart;
            Pair currPart = null;
            Pair nextPart = null;

            for (int i = 0; i < iterations; i++) {
                prevPart = parts.get(i);
                currPart = parts.get(i + 1);
                nextPart = parts.get(i + 2);
                res += (prevPart.getCnt() + 1) * prevPart.getCnt() / 2;
                if (prevPart.getC() == nextPart.getC() && currPart.getCnt() == 1) {
                    res += Math.min(prevPart.getCnt(), nextPart.getCnt());
                }
            }
            res += (currPart.getCnt() + 1) * currPart.getCnt() / 2;
            res += (nextPart.getCnt() + 1) * nextPart.getCnt() / 2;


        } else {
            for (Pair p : parts) {
                res += (p.getCnt() + 1) * p.getCnt() / 2;
            }
        }
        return res;
    }

    private static boolean isSpecialPalindrome(String substring) {

        int len = substring.length();
        int midInd = len / 2;

        if (len == 1) return true;
        char c = substring.charAt(0);
        for (int i = 0; i < midInd; i++) {
            if (c != substring.charAt(i) || c != substring.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner("7\n" +
//                "abcbaba");
        Scanner scanner = new Scanner(new File(SpecialPalindrome.class.getClassLoader().getResource("palindromeStr.txt").getFile()));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

class Pair {

    private char c;
    private long cnt;

    public Pair(char c, int cnt) {
        this.c = c;
        this.cnt = cnt;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public long getCnt() {
        return cnt;
    }

    public void setCnt(long cnt) {
        this.cnt = cnt;
    }
}