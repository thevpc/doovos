/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr;

/**
 *
 * @author vpc
 */
public class JavaSourceLayout {

    private String indent;
    private boolean noComments;
    private boolean newLine;

    public JavaSourceLayout(String indent, boolean noComments,boolean newLine) {
        this.indent = indent;
        this.noComments = noComments;
        this.newLine = newLine;
    }

    public String getIndent() {
        return indent;
    }

    public void setIndent(String indent) {
        this.indent = indent;
    }

    public boolean isNoComments() {
        return noComments;
    }

    public void setNoComments(boolean noComments) {
        this.noComments = noComments;
    }

    public boolean isNewLine() {
        return newLine;
    }

    public void setNewLine(boolean newLine) {
        this.newLine = newLine;
    }
    

    public JavaSourceLayout indent(int x) {
        StringBuilder s=new StringBuilder(indent);
        for(int i=0;i<x;i++){
            s.append(' ');
        }
        return new JavaSourceLayout(s.toString(), noComments,newLine);
    }
    
    public JavaSourceLayout copy() {
        try {
            return (JavaSourceLayout) clone();
        } catch (CloneNotSupportedException ex) {
            throw new IllegalArgumentException(ex);
        }
    }
}
