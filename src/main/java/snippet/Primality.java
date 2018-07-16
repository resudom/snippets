package snippet;

import java.io.*;
import java.util.*;

public class Primality {


    // Complete the primality function below.
    static String primality(int n) {

        if (n < 1) return "Not prime";
        for (int i = 2; (i * i) <= n; i++) {
            if (n % i == 0) return "Not prime";
        }
        return "Prime";
    }

    private static final Scanner scanner = new Scanner("3\n" +
            "12\n" +
            "5\n" +
            "1");

    public static void main(String[] args) throws IOException {

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int pItr = 0; pItr < p; pItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String result = primality(n);
            System.out.println(result);

        }


        scanner.close();
    }
}

class Checker implements Comparator<Player>{


    @Override
    public int compare(Player o1, Player o2) {

        if(o1.score==o2.score){
            return o2.name.compareTo(o1.name);
        }
        return o1.score - o2.score;
    }
}

class Player{

    String name;
    int score;

}
