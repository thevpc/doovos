package test.syntax;

import org.doovos.api.DProcess;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 26 janv. 2009
 * Time: 20:48:49
 * To change this template use File | Settings | File Templates.
 */
public class t005 {
    public static void main(String[] args) {
        String x="Hello";
        int y=3;
        String z=x+y;
        System.out.println(z);

        String s1=x.toString();
        int x2=s1.length();
        System.out.println(x);
        System.out.println(s1);
        System.out.println(x2);
    }
}
