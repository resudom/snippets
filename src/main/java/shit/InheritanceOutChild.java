package shit;

import snippet.Inheritance;

/**
 * Created by IVANMO on 13/7/2017.
 */
public class InheritanceOutChild extends Inheritance implements Cloneable{


    public InheritanceOutChild getClone() throws CloneNotSupportedException {
        return (InheritanceOutChild) this.clone();
    }
}
