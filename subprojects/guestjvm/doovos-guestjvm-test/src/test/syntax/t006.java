package test.syntax;

import org.doovos.api.DProcess;

/**
 * Test inner class
 */
public class t006 {
    public static class SubClass{
        int x;
        int y;
    }
    public static class SubClass2 extends SubClass{
        int x;
    }

    public static void main(String[] args) {
        SubClass2 s=new SubClass2();
        s.x=1;
        ((SubClass)s).x=2;
        s.y=3;
        System.out.println(s.x);
    }
}
