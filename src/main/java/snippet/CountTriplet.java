package snippet;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

public class CountTriplet {


    // Complete the countTriplets function below.
/*    static long countTriplets(List<Long> arr, long r) {


        long count = 0;
        long rXr = r * r;

      *//*  HashSet<Long> powersOfRatio = new HashSet<>();
        powersOfRatio.add(1L);
        long powerOfR = 1;
        while (powerOfR > 1) {
            powersOfRatio.add(powerOfR);
            powerOfR *= r;
        }
*//*
        int size = arr.size();
        if(r==1) size-=1;
        HashMap<Long, TreeSet<Integer>> numMap = new HashMap<>();
        for (int i = size - 1; i >= 0; i--) {

            long num = arr.get(i);


                TreeSet<Integer> nextNumIndexes = numMap.get(num * r);
                TreeSet<Integer> nextNextNumIndexes = numMap.get(num * rXr);

                if (nextNumIndexes != null && nextNextNumIndexes != null) {
                    for (Integer nextIndex : nextNumIndexes) {

                        count += nextNextNumIndexes.tailSet(nextIndex).size();
                    }
                }

                TreeSet<Integer> indexes = numMap.getOrDefault(num, new TreeSet<Integer>());
                indexes.add(i);
                numMap.put(num, indexes);


        }

        return count;

    }*/


   /* static long countTriplets(List<Long> arr, long r) {
        long cnt = 0;
        Map<Long, Long> map = new HashMap<>();
        Map<Long, Long> rMap = new HashMap<>();
        for (Long n : arr) {
            if (n % r == 0) {
                long pre = n / r;
                Long cnt2 = rMap.get(pre);
                if (cnt2 != null) cnt += cnt2;

                Long cnt1 = map.get(pre);
                if (cnt1 != null) rMap.put(n, rMap.getOrDefault(n, 0L) + cnt1);
            }
            map.put(n, map.getOrDefault(n, 0L) + 1);
        }
        return cnt;
    }
*/


    static long countTriplets(List<Long> arr, long r) {

        long cnt = 0;
        HashMap<Long, Long> numMap = new HashMap<>();
        HashMap<Long, Long> pairNumMap = new HashMap<>();

        for (int i = arr.size() - 1; i >= 0; i--) {

            Long num = arr.get(i);
            if (pairNumMap.containsKey(num * r)) {
                cnt += pairNumMap.get(num * r);
            }
            if (numMap.containsKey(num * r)) {
                pairNumMap.put(num, pairNumMap.getOrDefault(num, 0L) + numMap.get(num * r));
            }
            numMap.put(num, numMap.getOrDefault(num, 0L) + 1);
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {


       /* BufferedReader bufferedReader = new BufferedReader(new StringReader("100 1\n" +
                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1"));
*/
        BufferedReader bufferedReader = new BufferedReader(new StringReader("6 3\n" +
                "1 3 9 9 27 81"));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

