package snippet;
import java.io.*;
import java.util.*;

public class CommonSubstring {



        // Complete the twoStrings function below.
        static String twoStrings(String s1, String s2) {

           int[] alphabetMap = new int[26];
           for(char c: s1.toCharArray()){
               alphabetMap[c-'a']++;
           }

           String res = "NO";
           for(char c: s2.toCharArray()){
               if(alphabetMap[c-'a']>0) {
                   res = "YES";
                   break;
               }
           }
           return res;
        }

        private static final Scanner scanner = new Scanner("2\n" +
                "hello\n" +
                "world\n" +
                "hi\n" +
                "world");

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

            int q = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int qItr = 0; qItr < q; qItr++) {
                String s1 = scanner.nextLine();

                String s2 = scanner.nextLine();

                String result = twoStrings(s1, s2);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();

            scanner.close();
        }
    }



