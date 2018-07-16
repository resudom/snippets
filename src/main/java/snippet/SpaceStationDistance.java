package snippet;

import java.io.*;
import java.util.*;

public class SpaceStationDistance {


    // Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, int[] c) {

        TreeSet<Integer> spaceStation = new TreeSet<>();
        for (int cityNum : c) spaceStation.add(cityNum);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {

            int nextDist = Integer.MAX_VALUE;
            Integer nextStation = spaceStation.ceiling(i);
            if (null != nextStation) nextDist = nextStation - i;

            int prevDist = Integer.MAX_VALUE;
            Integer prevStation = spaceStation.floor(i);
            if (null != prevStation) prevDist = i - prevStation;

            max = Math.max(max, Math.min(nextDist, prevDist));
        }
        return max;
    }

    private static final Scanner scanner = new Scanner("20 5\n" +
            "13 1 11 10 6");

    public static void main(String[] args) throws IOException {

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] c = new int[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = flatlandSpaceStations(n, c);

        System.out.println(result);

        scanner.close();
    }


}
