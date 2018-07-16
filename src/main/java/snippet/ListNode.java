package snippet;

public class ListNode implements Comparable<ListNode>{

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public int compareTo(ListNode o) {
        return 0;
    }
}


