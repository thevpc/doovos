package test.syntax;

import java.io.PrintStream;

public class t009 {
    static PrintStream out = System.out;
    public static void main(String[] args) {
        long x=6L;
        int y=2;
        long z=2;
        long v=(x-y)/2;
        out.println(v);
    }
}
