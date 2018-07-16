package snippet;

import java.io.*;
import java.util.*;

public class MakeAnagram {


    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {

        StringBuilder sb1 = new StringBuilder(a);
        StringBuilder sb2 = new StringBuilder(b);

        int ind1 = 0;
        while (ind1 < sb1.length()) {

            String str1 = sb1.substring(ind1, ind1 + 1);
            int ind2 = sb2.indexOf(str1);
            if (ind2 != -1) {
                sb1.deleteCharAt(ind1);
                sb2.deleteCharAt(ind2);
            }else {
                ind1++;
            }
        }

        return sb1.length() + sb2.length();
    }

    private static final Scanner scanner = new Scanner("fcrxzwscanmligyxyvym\n" +
            "jxwtrhvujlmrpdoqbisbwhmgpmeoke");

    public static void main(String[] args) throws IOException {

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        System.out.println(res);

        scanner.close();
    }


}
