package snippet;

import java.util.*;

public class TwoStackQueue {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner("10\n" +
                "1 42\n" +
                "2\n" +
                "1 14\n" +
                "3\n" +
                "1 28\n" +
                "3\n" +
                "1 60\n" +
                "1 78\n" +
                "2\n" +
                "2");
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}

class MyQueue<T> {

    ArrayDeque<T> st1 = new ArrayDeque<>();
    ArrayDeque<T> st2 = new ArrayDeque<>();


    public void enqueue(T e){

        st1.push(e);
    }

    public T dequeue() {

            if(st2.isEmpty()){
                while(!st1.isEmpty()) st2.push(st1.pop());
            }
            return st2.pop();
    }

    public T peek(){
        if(st2.isEmpty()){
            while(!st1.isEmpty()) st2.push(st1.pop());
        }
        return st2.peek();

    }

}