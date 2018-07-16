package snippet;

import java.io.*;
import java.util.*;

public class StairCase {


    // Complete the stepPerms function below.
    static int stepPerms(int n) {

        if(n<0) return 0;
        if(n==0||n==1) return 1;
        if(n==2) return 2;
        if(n==3) return 4;
        int[] ways = new int[n+1];
        ways[0] = 1;
        ways[1] = 1;
        ways[2] = 2;
        for(int i=3; i<=n; i++){

            ways[i] = ways[i-1] + ways[i-2] + ways[i-3];
        }
        return ways[n];
    }

    private static final Scanner scanner = new Scanner("3\n" +
            "1\n" +
            "3\n" +
            "7");

    public static void main(String[] args) throws IOException {

        int s = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int sItr = 0; sItr < s; sItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int res = stepPerms(n);
            System.out.println(res);

        }

        scanner.close();
    }
}
