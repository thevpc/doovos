///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr;
//
//import java.io.PrintStream;
//import java.util.Collection;
//import java.util.Collections;
//
///**
// *
// * @author vpc
// */
//public class JJITAnyExpression extends JJITExpressionImpl{
//    private String expression;
//
//    public JJITAnyExpression(String expression) {
//        this.expression = expression;
//    }
//    public String toJavaCode(){
//        return expression;
//    }
//
//    public void write(PrintStream out) {
//        out.print(expression);
//    }
//
//    public void substitue(JJITName a, JJITName b) {
//        //
//    }
//
//    public Collection<JJITExpression> getChildren() {
//        return Collections.EMPTY_LIST;
//    }
//
//
//
//}
