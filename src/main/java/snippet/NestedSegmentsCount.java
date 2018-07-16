package snippet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by IVANMO on 24/7/2017.
 */
public class NestedSegmentsCount {

    static ArrayList<Segment> segments;
    static int[] bit;
    static int[] answer;

    static Comparator<Segment> comparatorRightSide = new Comparator<Segment>() {
        @Override
        public int compare(Segment o1, Segment o2) {
            return o1.right - o2.right;
        }
    };

    static Comparator<Segment> comparatorLeftSide = new Comparator<Segment>() {
        @Override
        public int compare(Segment o1, Segment o2) {
            return o2.left - o1.left;
        }
    };

    public static void main(String[] args) {

        segments = new ArrayList<>();
        segments.add(new Segment(1, 8, 1));
        segments.add(new Segment(2, 3, 2));
        segments.add(new Segment(4, 7, 3));
        segments.add(new Segment(5, 6, 4));

        int size = segments.size();
        bit = new int[size + 1];
        answer = new int[size + 1];

        Collections.sort(segments, comparatorRightSide);

        int i = 1;
        for (Segment segment : segments) {
            segment.right = i++;
        }

        Collections.sort(segments, comparatorLeftSide);

        i = 1;
        for (Segment segment : segments) {
            answer[segment.index] = readSumBit(segment.right);
            updateBit(segment.right, size, 1);
        }

        System.out.println(Arrays.toString(answer));
    }

    private static int readSumBit(int bitIndex) {

        int sum = 0;
        while (bitIndex > 0) {
            sum += bit[bitIndex];
            bitIndex -= bitIndex & -bitIndex;
        }
        return sum;
    }

    private static void updateBit(int bitIndex, int size, int number) {

        while (bitIndex <= size) {

            bit[bitIndex]++;
            bitIndex += bitIndex & -bitIndex;
        }


    }


}

class Segment {

    int left;
    int right;
    int index;

    public Segment(int left, int right, int index) {
        this.left = left;
        this.right = right;
        this.index = index;
    }
}