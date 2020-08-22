/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr;

import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITClassSource;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITBloc;

/**
 *
 * @author vpc
 */
public class JJITVisitContext {
    private JJITClassSource classSource;
    private JJITBloc runBloc;
    private JJITBloc initBloc;

    public JJITVisitContext(JJITClassSource classSource, JJITBloc runBloc, JJITBloc initBloc) {
        this.classSource = classSource;
        this.runBloc = runBloc;
        this.initBloc = initBloc;
    }

    public JJITClassSource getClassSource() {
        return classSource;
    }

    public JJITBloc getInitBloc() {
        return initBloc;
    }

    public JJITBloc getRunBloc() {
        return runBloc;
    }
    
    public JJITBloc run() {
        return runBloc;
    }
    
    public JJITBloc init() {
        return initBloc;
    }
    
}