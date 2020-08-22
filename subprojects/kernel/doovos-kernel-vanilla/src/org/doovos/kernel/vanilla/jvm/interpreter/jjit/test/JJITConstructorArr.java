///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr;
//
//import java.io.PrintStream;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collection;
//
///**
// *
// * @author vpc
// */
//public class JJITConstructorArr extends JJITExpressionImpl {
//
//    private String type;
//    private JJITExpression[] args;
//
//    public JJITConstructorArr(String type, JJITExpression... args) {
//        this.type = type;
//        this.args = args;
//        for (int i = 0; i < args.length; i++) {
//            if (args[i] == null) {
//                args[i] = JJITConstant.NULL;
//            }
//        }
//    }
//
//  @Override
//    public boolean isReadVar(String name) {
//        for (int i = 0; i < args.length; i++) {
//            if (args[i].isReadVar(name)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public boolean isWriteVar(String name) {
//        for (int i = 0; i < args.length; i++) {
//            if (args[i].isReadVar(name)) {
//                return true;
//            }
//        }
//        return false;
//    }
//    
//    public Collection<JJITExpression> getChildren() {
//        ArrayList<JJITExpression> c=new ArrayList<JJITExpression>();
//        c.addAll(Arrays.asList(args));
//        return c;
//    }
//
//    public JJITExpression replace(JJITExpression a, JJITExpression b) {
//        if(a.equals(this)){
//            return b;
//        }
//        JJITExpression[] args2=new JJITExpression[args.length];
//        for (int i = 0; i < args2.length; i++) {
//            args2[i]=args[i].replace(a,b);
//        }
//        return new JJITConstructorArr(type,args2);
//    }
//
//
//
//    public void write(PrintStream out) {
//        out.print("new ");
//        out.print(type);
//        for (JJITExpression arg : args) {
//            out.print("[");
//            arg.write(out);
//            out.print("]");
//        }
//    }
//
//    public void write(PrintWriter out) {
//        out.print("new ");
//        out.print(type);
//        for (JJITExpression arg : args) {
//            out.print("[");
//            arg.write(out);
//            out.print("]");
//        }
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        JJITConstructorArr that = (JJITConstructorArr) o;
//
//        if (!Arrays.equals(args, that.args)) return false;
//        if (type != null ? !type.equals(that.type) : that.type != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = type != null ? type.hashCode() : 0;
//        result = 31 * result + (args != null ? Arrays.hashCode(args) : 0);
//        return result;
//    }
//}
