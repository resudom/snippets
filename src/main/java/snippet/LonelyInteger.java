package snippet;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LonelyInteger {

    // Complete the findLonely function below.
    static int findLonely(List<Integer> arr) {

        int N = 4;
        int[] bitMap = new int[4];
        arr.stream().forEach(x -> inverseBit(bitMap, x));

        int result = -1;
        for (int i = 0; i < N; i++) {
            if (bitMap[i] != 0) {
                int count = 0;
                while ((bitMap[i] & (1 << count)) == 0) {
                    count++;
                }
                result = i * 32 + count;

            }
        }
        return result;
    }

    static void inverseBit(int[] bitMap, int num) {

        int bitMapByte = num / 32;
        int placeInByte = num % 32;
        bitMap[bitMapByte] = bitMap[bitMapByte] ^ (1 << placeInByte);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new StringReader("9\n" +
                "4 9 95 93 57 4 57 93 9"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int res = findLonely(arr);


        bufferedReader.close();
    }
}
