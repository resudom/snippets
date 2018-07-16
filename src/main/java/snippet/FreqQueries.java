package snippet;

import java.io.*;
import java.util.*;

public class FreqQueries {

    // Complete the solve function below.
    static int[] solve(int[][] queries) {

        ArrayList<Integer> res = new ArrayList<>();

        HashMap<Integer, Integer> numFreqMap = new HashMap<>();
        HashMap<Integer, Integer> freqNumMap = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            switch (queries[i][0]) {

                case 1:
                    Integer prevFreq = numFreqMap.getOrDefault(queries[i][1], 0);
                    Integer freq = prevFreq + 1;

                    numFreqMap.put(queries[i][1], freq);

                    Integer freqNum = freqNumMap.getOrDefault(freq,  0);
                    freqNumMap.put(freq, freqNum + 1);

                    freqNum = freqNumMap.getOrDefault(prevFreq, 0);
                    freqNumMap.put(prevFreq, freqNum - 1);
                    break;
                case 2:
                    prevFreq = numFreqMap.getOrDefault(queries[i][1], 0);
                    if (prevFreq>0) {

                        freq = prevFreq - 1;
                        numFreqMap.put(queries[i][1], freq);

                        freqNum = freqNumMap.getOrDefault(freq,  0);
                        freqNumMap.put(freq, freqNum + 1);

                        freqNum = freqNumMap.getOrDefault(prevFreq, 0);
                        freqNumMap.put(prevFreq, freqNum - 1);
                    }


                    break;
                case 3:
                    if(freqNumMap.getOrDefault(queries[i][1],0)>0) res.add(1);
                    else if(freqNumMap.getOrDefault(queries[i][1], 0)==0) res.add(0);
                    break;
            }
        }

        int[] resArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }

   /* new BufferedReader("4\n" +
            "3 4\n" +
            "2 1003\n" +
            "1 16\n" +
            "3 1");
*/
   private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

//        int q = scanner.nextInt();
        Integer q = Integer.parseInt(br.readLine().trim());

        int[][] queries = new int[q][2];

        for (int i = 0; i < q; i++) {
            String[] queriesRowItems = br.readLine().trim().split(" ");

            for (int j = 0; j < 2; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        int[] ans = solve(queries);

        for (int i = 0; i < ans.length; i++) {
            bufferedWriter.write(String.valueOf(ans[i]));

            if (i != ans.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        br.close();
        bufferedWriter.newLine();

        bufferedWriter.close();


    }
}

