package snippet;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by IVANMO on 25/7/2017.
 */
public class LargestRectangleArea {

    public static void main(String[] args) {

        int[] input = {2, 1, 5, 6, 2, 3};

        int output = largestRectangleArea(input);
        System.out.println(output);

    }

    public static int largestRectangleArea(int[] heights) {

        if (heights.length == 0) return 0;

        LinkedList<Integer> stack = new LinkedList<>();

        int max = 0;
        int top;
        int idx = 0;
        int curr;

        while (idx < heights.length) {

            if (stack.isEmpty() || heights[stack.peekLast()] <= heights[idx]) {
                stack.addLast(idx++);
            } else {
                top = stack.removeLast();
                curr = heights[top] * (stack.isEmpty() ? idx : idx - stack.peekLast() - 1);
                if (curr > max) max = curr;
            }
        }

        while (!stack.isEmpty()) {
            top = stack.removeLast();
            curr = heights[top] * (stack.isEmpty() ? idx : idx - stack.peekLast() - 1);
            if (curr > max) max = curr;
        }

        return max;
    }
}


