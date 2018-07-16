package snippet;

import java.io.*;
import java.util.*;

public class AnagramPair {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {

        ArrayDeque<String> subStrSet = new ArrayDeque<>();
        int res = 0;
        for (int len = 1; len <= s.length(); len++) {

            subStrSet.clear();

            for (int i = 0; i <= s.length() - len; i++) {

                subStrSet.offerFirst(s.substring(i, i + len));
            }

            while(subStrSet.size()>1) {
                String patt = subStrSet.pollLast();
                for (String str : subStrSet) {

                    if (isAnagram(str, patt)) res++;
                }
            }
        }
        return res;
    }

    private static boolean isAnagram(String str, String patt) {

        HashMap<Character, Integer> charMap = new HashMap<>();
        for (char c : patt.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        int ind = 0;
        int count = charMap.size();
        while (ind < str.length()) {

            char c = str.charAt(ind);
            if(charMap.containsKey(c)){
                charMap.put(c,charMap.get(c)-1);
                if(charMap.get(c)==0){
                    count--;
                }
            }
            ind++;

        }
        if(count==0) return true;
        return false;
    }

    static int countAnagram(String s, String p) {

        int result = 0;
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        int begin = 0;
        int end = 0;
        int count = charMap.size();

        /* while (begin + p.length() <= s.length() && end < s.length()) {*/
        while (end < s.length()) {
            char c = s.charAt(end);

            if (charMap.containsKey(c)) {

                charMap.put(c, charMap.get(c) - 1);
                if (charMap.get(c) == 0) {
                    count--;
                }
            }

            while (count == 0) {

                c = s.charAt(begin);
                if (charMap.containsKey(c)) {
                    charMap.put(c, charMap.get(c) + 1);
                    if (charMap.get(c) > 0) {
                        count++;
                    }
                }
                if (end - begin + 1 == p.length()) {
                    result++;
                }
                begin++;
            }
            end++;
        }

        return result;
    }

    private static final Scanner scanner = new Scanner("2\n" +
            "ifailuhkqq\n" +
            "kkkk");

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

