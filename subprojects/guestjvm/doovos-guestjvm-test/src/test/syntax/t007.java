package test.syntax;

import org.doovos.api.DSystem;
import org.doovos.api.DProcess;

/**
 * test inheritance
 * User: vpc
 * Date: 26 janv. 2009
 * Time: 21:37:16
 * To change this template use File | Settings | File Templates.
 */
public class t007 {
    public static interface SubInterface{
        int doIt(int x);
    }
    public static class SubClass implements SubInterface{
        public int doIt(int x) {
            return x+1;
        }
    }

    public static void main(String[] args) {
        SubInterface s=new SubClass();
        int x=s.doIt(3);
        System.out.println(x);
    }
}
