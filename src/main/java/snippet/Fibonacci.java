package snippet;

public class Fibonacci {

    static int fibonacci(int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;

        int fibFirst = 0;
        int fibSecond = 1;

        for (int i = 1; i < n; i++) {

            int cur = fibFirst + fibSecond;
            fibFirst = fibSecond;
            fibSecond = cur;
        }
        return fibSecond;
    }

    public static void main(String[] args) {

        int n = 20;
        System.out.println(n + "th Fibonacci number: " + fibonacci(n));
    }
}
