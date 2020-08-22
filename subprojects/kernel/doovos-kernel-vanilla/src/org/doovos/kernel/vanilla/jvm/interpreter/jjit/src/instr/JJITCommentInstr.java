/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITExpression;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsageList;

/**
 *
 * @author vpc
 */
public class JJITCommentInstr extends  JJITInstrImpl {

    private String value;
    private boolean longComment;

    public JJITCommentInstr(boolean longComment, String value) {
        this.value = value;
        this.longComment = longComment;
    }

    public JJITInstr simplify(Map<String, JJITDecField> fields, Map<String, JJITDecVar> varsMap) {
        return this;
    }

    public JJITVarUsageList getVarUsage(String ... names) {
        return new JJITVarUsageList();
    }

    public JJITInstr replaceReads(JJITExpression a, JJITExpression b) {
        return this;
    }

    @Override
    public Collection<JJITExpression> getExpressions() {
        return Collections.EMPTY_LIST;
    }

    public List<JJITExpression> getRootReadExpressions() {
        return Collections.EMPTY_LIST;
    }
    

    public boolean isVarRead(String name) {
        return false;
    }

    public boolean isVarUpdated(String name) {
        return false;
    }

    

    public void writeSource(PrintStream out, JavaSourceLayout layout) {
        if(layout.isNoComments()){
            return;
        }
        String indent = layout.getIndent();
        try {
            BufferedReader r = new BufferedReader(new StringReader(value));
            String line = null;
            if (longComment) {
                boolean first = true;
                while ((line = r.readLine()) != null) {
                    if (first) {
                        out.print(indent + " /** ");
                        first = false;
                    } else {
                        out.println();
                        out.print(indent + " * " + line);
                    }
                }
                if (!first) {
                    out.println();
                    out.println(indent + " */ ");
                }
            } else {
                boolean first = true;
                while ((line = r.readLine()) != null) {
                    if (first) {
                        first = false;
                    } else {
                        out.println();
                    }
                    out.print(indent + " // " + line);
                }
            }
            out.println();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void writeSource(PrintWriter out, JavaSourceLayout layout) {
        if(layout.isNoComments()){
            return;
        }
        String indent = layout.getIndent();
        try {
            BufferedReader r = new BufferedReader(new StringReader(value));
            String line = null;
            if (longComment) {
                boolean first = true;
                while ((line = r.readLine()) != null) {
                    if (first) {
                        out.print(indent + " /** ");
                        first = false;
                    } else {
                        out.println();
                        out.print(indent + " * " + line);
                    }
                }
                if (!first) {
                    out.println();
                    out.println(indent + " */ ");
                }
            } else {
                boolean first = true;
                while ((line = r.readLine()) != null) {
                    if (first) {
                        first = false;
                    } else {
                        out.println();
                    }
                    out.print(indent + " // " + line);
                }
            }
            out.println();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
