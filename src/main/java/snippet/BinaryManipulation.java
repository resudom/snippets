package snippet;

/**
 * Created by IVANMO on 25/7/2017.
 */
public class BinaryManipulation {

    public static void main(String[] args) {
        int num = 5;
        int mask = ~0;
        while ((mask&num)>0) mask<<=1;
        int res = ~mask&~num;
        System.out.println(Integer.toBinaryString(Integer.valueOf(mask)));
        System.out.println(res);
    }
}
