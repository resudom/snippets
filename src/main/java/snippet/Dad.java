package snippet;

/**
 * Created by IVANMO on 12/7/2017.
 */
public class Dad
{
    protected static String me = "dad";

    public void printMe()
    {
        System.out.println(me);
    }

    public static void main(String[] args) {


        new Son().printMe();

        final String fuck = "Fuck";
        Son son = new Son();
        son.setFuck(fuck);
        processSon(son);
        System.out.println(son.toString());
    }

    private static void processSon(Son son) {
        son.setFuck("Shit");
    }
}

class Son extends Dad
{
    static {me = "son";}

    private String fuck;
    protected  static String me;

    public String getFuck() {
        return fuck;
    }

    public void setFuck(String fuck) {
        this.fuck = fuck;
    }

    @Override
    public String toString() {
        return "Son{" +
                "fuck='" + fuck + '\'' +
                '}';
    }
}
