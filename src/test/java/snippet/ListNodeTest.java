package snippet;

import static org.junit.Assert.*;

public class ListNodeTest {

    @org.junit.Test
    public void compareTwoListsTest() throws Exception {

        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;

        ListNode l31 = new ListNode(7);
        ListNode l32 = new ListNode(0);
        ListNode l33 = new ListNode(8);
        l31.next = l32;
        l32.next = l33;

        assertTrue(l11.compareTo(l21)<0 );

    }

}