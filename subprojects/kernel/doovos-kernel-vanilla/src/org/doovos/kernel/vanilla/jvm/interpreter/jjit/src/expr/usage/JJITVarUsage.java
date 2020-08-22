/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage;

import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITName;

/**
 *
 * @author vpc
 */
public class JJITVarUsage {
    private boolean conditional;
    private JJITName var;
    private JJITVarUsageType type;

    public JJITVarUsage(JJITName var, JJITVarUsageType type) {
        this(var,type,false);
    }

    public JJITVarUsage(JJITName var, JJITVarUsageType type,boolean conditional) {
        this.var = var;
        this.type = type;
        this.conditional = conditional;
    }

    public boolean isConditional() {
        return conditional;
    }

    public JJITVarUsageType getType() {
        return type;
    }

    public JJITName getVar() {
        return var;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JJITVarUsage other = (JJITVarUsage) obj;
        if (this.var != other.var && (this.var == null || !this.var.equals(other.var))) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (this.var != null ? this.var.hashCode() : 0);
        hash = 53 * hash + (this.type != null ? this.type.hashCode() : 0);
        return hash;
    }
    
}
