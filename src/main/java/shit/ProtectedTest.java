package shit;

import snippet.Inheritance;

/**
 * Created by IVANMO on 13/7/2017.
 */
public class ProtectedTest {

    InheritanceOutChild inheritanceOutChild = new InheritanceOutChild();
    static String inheritanceOutChild2 = null;

    public static void main(String[] args) {

        ProtectedTest test = new ProtectedTest();

        try {
            Inheritance inheritanceClone = test.inheritanceOutChild.getClone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
//        test.inheritanceOutChild.getA();
        inheritanceOutChild2.toString();
    }
}
