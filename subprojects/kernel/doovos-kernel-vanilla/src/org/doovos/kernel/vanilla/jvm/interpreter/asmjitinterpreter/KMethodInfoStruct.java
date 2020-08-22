/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter;

import org.doovos.kernel.api.jvm.bytecode.KTryCatchDef;

/**
 *
 * @author vpc
 */
public class KMethodInfoStruct {

    public KInstructionCompiled[] instrunctions;
    public KTryCatchDef[] tryCachBlocs;
}
