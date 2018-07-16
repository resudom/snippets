package snippet;

import java.io.*;
import java.util.*;

public class FairRations {


    // Complete the fairRations function below.
    static int fairRations(int[] B) {

        int count = 0;
        int i =0;
        while(i<B.length-1){
            if(B[i]%2==1){
                B[i]++;
                B[i+1]++;
                count++;
            }
            i++;
        }
        if(B[i]%2==1) {
            System.out.println("NO");
            throw new RuntimeException("NO");
        }
        return count*2;
    }

    private static final Scanner scanner = new Scanner("2\n" +
            "1 2");

    public static void main(String[] args) throws IOException {

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] B = new int[N];

        String[] BItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < N; i++) {
            int BItem = Integer.parseInt(BItems[i]);
            B[i] = BItem;
        }

        int result = fairRations(B);

        System.out.println(result);

        scanner.close();
    }
}
