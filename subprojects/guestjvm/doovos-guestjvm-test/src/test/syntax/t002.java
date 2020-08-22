package test.syntax;

public class t002 {
    public static t002 typeStatic;
    public t002 typeInst;

    public static void main(String[] args) {
        typeStatic=new t002();
        typeStatic.typeInst=typeStatic;
        typeStatic=typeStatic.typeInst;
        //typeStatic.typeInst=null;
        //typeStatic.typeInst=typeStatic;
    }
}