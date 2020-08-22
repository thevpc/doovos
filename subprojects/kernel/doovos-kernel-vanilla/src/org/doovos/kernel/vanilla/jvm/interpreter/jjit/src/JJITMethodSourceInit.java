/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src;

import java.io.PrintStream;
import java.io.PrintWriter;

import org.doovos.kernel.api.jvm.reflect.KInstruction;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstructionDef;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITName;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Types;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITCommentInstr;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JavaSourceLayout;

/**
 *
 * @author vpc
 */
public class JJITMethodSourceInit extends JJITMethodSource{

    public JJITMethodSourceInit(JJITClassSource parentClass) {
        super(parentClass);
        parentClass.defineImport(Types.KPROCESS);
        parentClass.defineImport(Types.KREGISTER);
        parentClass.defineImport(Types.JJITINSTRUCTION);
    }

    public void init() {

    }

    public void build() {

    }

    public void writeSource(PrintStream out,JavaSourceLayout layout){
        out.println(layout.getIndent()+"public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {");
        super.writeSource(out,layout.indent(2));
        out.println(layout.getIndent()+"}");
    }

    @Override
    public void writeSource(PrintWriter out,JavaSourceLayout layout) {
        out.println(layout.getIndent()+"public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {");
        super.writeSource(out,layout.indent(2));
        out.println(layout.getIndent()+"}");
    }
    
    public JJITName process() {
        return new JJITName("process",KProcess.class);
    }

    public JJITName constants() {
        return new JJITName("constants",java.lang.Object.class.getName()+"[]");
    }

    public JJITName instructions() {
        return new JJITName("instructions", KInstruction.class.getName() + "[]");
    }

    public JJITName index() {
        return new JJITName("index", "int");
    }

}
