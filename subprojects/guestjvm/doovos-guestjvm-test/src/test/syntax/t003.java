package test.syntax;

import java.io.PrintStream;

public class t003 {
    public static int staticVar = 8399;
    public int instVar = 35;
    public static t003 typeStatic;
    public t003 typeInst;

    public static void main(String[] args) {
        typeStatic=new t003();
        typeStatic.instVar=3;
        typeStatic.typeInst=null;
        typeStatic.typeInst=typeStatic;
        PrintStream out = System.out;
        out.print(typeStatic.instVar);
        out.print("\n");
    }
}