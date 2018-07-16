package snippet;

import java.io.*;
import java.util.*;

public class SwapNodes {


    /*
     * Complete the swapNodes function below.
     */
    static int[][] swapNodes(int[][] indexes, int[] queries) {

        int[][] result = new int[queries.length][indexes.length];
        int queryCnt = 0;
        for (int k : queries) {

            ArrayDeque<Integer> nodes = new ArrayDeque<>();

            nodes.offerFirst(1);
            int i = 0;
            while (!nodes.isEmpty()) {
                i++;
                nodes.offerFirst(0);
                if (i % k == 0) {
                    for (Integer node : nodes) {
                        if (node != 0) {
                            node -= 1;
                            indexes[node][0] = indexes[node][0] ^ indexes[node][1];
                            indexes[node][1] = indexes[node][0] ^ indexes[node][1];
                            indexes[node][0] = indexes[node][0] ^ indexes[node][1];
                        }
                    }
                }
                while (nodes.peekLast() != 0) {
                    int ind = nodes.pollLast() - 1;
                    if (indexes[ind][0] != -1) nodes.offerFirst(indexes[ind][0]);
                    if (indexes[ind][1] != -1) nodes.offerFirst(indexes[ind][1]);
                }
                nodes.pollLast();
            }

            ArrayList<Integer> resList = new ArrayList<>();
            int curr = 1;
            while (curr != -1 || !nodes.isEmpty()) {

                while (curr != -1) {
                    nodes.push(curr);
                    curr = indexes[curr-1][0];
                }
                curr = nodes.pop();
                resList.add(curr);
                curr = indexes[curr-1][1];

            }

            for(int j=0; j<resList.size(); j++){
                result[queryCnt][j] = resList.get(j);
            }
            queryCnt++;
        }
        return result;
    }

    private static final Scanner scanner = new Scanner("11\n" +
            "2 3\n" +
            "4 -1\n" +
            "5 -1\n" +
            "6 -1\n" +
            "7 8\n" +
            "-1 9\n" +
            "-1 -1\n" +
            "10 11\n" +
            "-1 -1\n" +
            "-1 -1\n" +
            "-1 -1\n" +
            "2\n" +
            "2\n" +
            "4");

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}

