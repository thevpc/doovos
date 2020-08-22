package test.syntax;

import java.io.PrintStream;

public class t001bis {

    public static void main(String[] args) {
//        int x=98;
//        AccessController.doPrivileged(new PrivilegedAction<Object>() {
//            public Object run() {
//                return null;
//            }
//        });
        PrintStream out = System.out;
        out.println(1);
        out.println("Hello World");
        out.println(2);
        //out.println(Convert.toString(x));
    }
}