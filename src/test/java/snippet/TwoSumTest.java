package snippet;

import static org.junit.Assert.*;
import org.junit.Test;

public class TwoSumTest {

    TwoSum twoSum = new TwoSum();

    @Test
    public void testTwoSum(){

        int [] inputArr = {7,2,9,5,16};
        int target = 23;

        int [] resultArr = twoSum.twoSum(inputArr, target);
        assertArrayEquals(new int[]{0,4}, resultArr);
    }

    @Test
    public void testAddTwoNumbers() {

        ListNode expectedListNode;
    }
}
