package snippet;

/**
 * Created by IVANMO on 12/7/2017.
 */
public class Inheritance {

    int a;

    protected int getA (){
        int res = a;
        return res;
    }

    public static void main(String[] args) {

        Inheritance inheritance = new InheritanceChild();

        System.out.println(inheritance.getA());
        System.out.println(inheritance.a);

        new AbstractClass() {
            @Override
            void abstractMethod() {

            }
        };

        new Command() {
            @Override
            public void command() {

            }
        };
    }
}

class InheritanceChild extends Inheritance {

    int a = 10;

    public int getA(int a){
        int res = a;
        return res;
    }

}

abstract class  AbstractClass {

    abstract void abstractMethod();
}

interface Command{
    void command();
}
