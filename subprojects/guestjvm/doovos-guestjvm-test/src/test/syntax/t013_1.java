package test.syntax;

import org.doovos.api.DProcess;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 11 avr. 2009
 * Time: 22:06:29
 * To change this template use File | Settings | File Templates.
 */
public class t013_1 {
    static {
        System.out.println("static t013_1 (a)");
        t013_2 x=new t013_2();
        System.out.println("static t013_1 (b)"); 
    }
}
