package jjit.local.jnt.scimark2.Random.nextDouble__D_3BECC4BA;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.Random
 * nextDouble()D
 * [count=35] [0] ALOAD(0) [1] GETFIELD(jnt.scimark2.Random,m,[I) [2] ALOAD(0) [3] GETFIELD(jnt.scimark2.Random,i,I) [4] IALOAD [5] ALOAD(0) [6] GETFIELD(jnt.scimark2.Random,m,[I) [7] ALOAD(0) [8] GETFIELD(jnt.scimark2.Random,j,I) [9] IALOAD [10] ISUB [11] ISTORE(1) [12] ILOAD(1) [-1] BlocIF(BlocItem{[13] IFGE(18)}) [18] ALOAD(0) [19] GETFIELD(jnt.scimark2.Random,m,[I) [20] ALOAD(0) [21] GETFIELD(jnt.scimark2.Random,j,I) [22] ILOAD(1) [23] IASTORE [24] ALOAD(0) [25] GETFIELD(jnt.scimark2.Random,i,I) [-1] BlocIF(BlocItem{[26] IFNE(31)}) [37] ALOAD(0) [38] GETFIELD(jnt.scimark2.Random,j,I) [-1] BlocIF(BlocItem{[39] IFNE(44)}) [50] ALOAD(0) [51] GETFIELD(jnt.scimark2.Random,haveRange,Z) [-1] BlocIF(BlocItem{[52] IFEQ(65)}) [65] ALOAD(0) [66] GETFIELD(jnt.scimark2.Random,dm1,D) [67] ILOAD(1) [68] I2D [69] DMUL [70] DRETURN
 */
public final class nextDouble_001 extends JJITAbstractInstruction implements Cloneable{
      private KField c_m = null;
      private KClassRepository c_repo;
      private KClass c_CRandom = null;
      private KField c_i = null;
      private KMemoryManager c_memman;
      private KField c_j = null;
      private KField c_haveRange = null;
      private KField c_left = null;
      private KField c_dm1 = null;
      private KField c_width = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KReference s2_ref;
         // **REMOVED Unused Var** KRegister s0;
        KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** int m_i;
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KRegister reg;
         // **REMOVED Unused Var** double m_d;
         // **REMOVED Unused Var** double m_d2;
         // **REMOVED Unused Var** double m_d3;
        KFrame callerFrame = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** double m_d4;
         // this_ref 0 ; r=10/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // local_1 1 ; r=3/w=1 : Cached
        int local_1;
         // *********[0] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[1] GETFIELD(jnt.scimark2.Random,m,[I)
         // **REMOVED Substitution** s0_ref = c_m.getInstanceRef(this_ref);
         // *********[2] ALOAD(0)
         // **REMOVED Substitution** s1_ref = this_ref;
         // *********[3] GETFIELD(jnt.scimark2.Random,i,I)
         // **REMOVED Substitution** s1 = new KInteger(c_i.getInstanceInt(this_ref));
         // *********[4] IALOAD
         // **REMOVED Substitution** index = c_i.getInstanceInt(this_ref);
         // **REMOVED Substitution** s0 = new KInteger(c_memman.getIntArray(c_m.getInstanceRef(this_ref),c_i.getInstanceInt(this_ref)));
         // *********[5] ALOAD(0)
         // **REMOVED Substitution** s1_ref = this_ref;
         // *********[6] GETFIELD(jnt.scimark2.Random,m,[I)
         // **REMOVED Substitution** s1_ref = c_m.getInstanceRef(this_ref);
         // *********[7] ALOAD(0)
         // **REMOVED Substitution** s2_ref = this_ref;
         // *********[8] GETFIELD(jnt.scimark2.Random,j,I)
         // **REMOVED Substitution** s2 = new KInteger(c_j.getInstanceInt(s2_ref));
         // *********[9] IALOAD
         // **REMOVED Substitution** index = c_j.getInstanceInt(s2_ref);
        s1 = new KInteger(c_memman.getIntArray(c_m.getInstanceRef(this_ref),c_j.getInstanceInt(this_ref)));
         // *********[10] ISUB
         // **REMOVED Substitution** index = s1.intValue();
         // **REMOVED Substitution** s0 = new KInteger((c_memman.getIntArray(c_m.getInstanceRef(this_ref),c_i.getInstanceInt(this_ref)) - index));
         // *********[11] ISTORE(1)
        local_1 = (c_memman.getIntArray(c_m.getInstanceRef(this_ref),c_i.getInstanceInt(this_ref)) - s1.intValue());
         // *********[12] ILOAD(1)
         // **REMOVED Substitution** s0 = new KInteger(local_1);
         // *********[-1] BlocIF(BlocItem{[13] IFGE(18)})
        if(local_1 < 0){
           // *********[14] ILOAD(1)
           // **REMOVED Substitution** s0 = new KInteger(local_1);
           // *********[15] LDC(9->"2147483647")
           // **REMOVED Substitution** s1 = I2147483647;
           // *********[16] IADD
           // **REMOVED Substitution** index = s1.intValue();
           // **REMOVED Substitution** s0 = new KInteger((local_1 + s1.intValue()));
           // *********[17] ISTORE(1)
          local_1 = (local_1 + 2147483647);
        }
         // *********[18] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[19] GETFIELD(jnt.scimark2.Random,m,[I)
         // **REMOVED Substitution** s0_ref = c_m.getInstanceRef(this_ref);
         // *********[20] ALOAD(0)
         // **REMOVED Substitution** s1_ref = this_ref;
         // *********[21] GETFIELD(jnt.scimark2.Random,j,I)
         // **REMOVED Substitution** s1 = new KInteger(c_j.getInstanceInt(this_ref));
         // *********[22] ILOAD(1)
         // **REMOVED Substitution** s2 = new KInteger(local_1);
         // *********[23] IASTORE
         // **REMOVED Substitution** m_i = s2.intValue();
         // **REMOVED Substitution** index = s1.intValue();
        c_memman.setIntArray(c_m.getInstanceRef(this_ref),c_j.getInstanceInt(this_ref),local_1);
         // *********[24] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[25] GETFIELD(jnt.scimark2.Random,i,I)
         // **REMOVED Substitution** s0 = new KInteger(c_i.getInstanceInt(this_ref));
         // *********[-1] BlocIF(BlocItem{[26] IFNE(31)})
        if(c_i.getInstanceInt(this_ref) == 0){
           // *********[27] ALOAD(0)
           // **REMOVED Substitution** s0_ref = this_ref;
           // *********[28] BIPUSH(16)
           // **REMOVED Substitution** s1 = I16;
           // *********[29] PUTFIELD(jnt.scimark2.Random,i)
           // **REMOVED Substitution** reg = s1;
           // **REMOVED Substitution** ref = s0_ref;
          c_i.setInstanceInt(this_ref,16);
        }else{
           // *********[31] ALOAD(0)
           // **REMOVED Substitution** s0_ref = this_ref;
           // *********[32] DUP
           // **REMOVED Substitution** s1_ref = s0_ref;
           // *********[33] GETFIELD(jnt.scimark2.Random,i,I)
           // **REMOVED Substitution** s1 = new KInteger(c_i.getInstanceInt(s0_ref));
           // *********[34] ICONST_1(Integer{1})
           // **REMOVED Substitution** s2 = IONE;
           // *********[35] ISUB
           // **REMOVED Substitution** index = 1;
           // **REMOVED Substitution** s1 = new KInteger((c_i.getInstanceInt(s0_ref) - 1));
           // *********[36] PUTFIELD(jnt.scimark2.Random,i)
           // **REMOVED Substitution** reg = s1;
           // **REMOVED Substitution** ref = s0_ref;
          c_i.setInstanceInt(this_ref,(c_i.getInstanceInt(this_ref) - 1));
        }
         // *********[37] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[38] GETFIELD(jnt.scimark2.Random,j,I)
         // **REMOVED Substitution** s0 = new KInteger(c_j.getInstanceInt(this_ref));
         // *********[-1] BlocIF(BlocItem{[39] IFNE(44)})
        if(c_j.getInstanceInt(this_ref) == 0){
           // *********[40] ALOAD(0)
           // **REMOVED Substitution** s0_ref = this_ref;
           // *********[41] BIPUSH(16)
           // **REMOVED Substitution** s1 = I16;
           // *********[42] PUTFIELD(jnt.scimark2.Random,j)
           // **REMOVED Substitution** reg = I16;
           // **REMOVED Substitution** ref = s0_ref;
          c_j.setInstanceInt(this_ref,16);
        }else{
           // *********[44] ALOAD(0)
           // **REMOVED Substitution** s0_ref = this_ref;
           // *********[45] DUP
           // **REMOVED Substitution** s1_ref = s0_ref;
           // *********[46] GETFIELD(jnt.scimark2.Random,j,I)
           // **REMOVED Substitution** s1 = new KInteger(c_j.getInstanceInt(s0_ref));
           // *********[47] ICONST_1(Integer{1})
           // **REMOVED Substitution** s2 = IONE;
           // *********[48] ISUB
           // **REMOVED Substitution** index = 1;
           // **REMOVED Substitution** s1 = new KInteger((c_j.getInstanceInt(s0_ref) - 1));
           // *********[49] PUTFIELD(jnt.scimark2.Random,j)
           // **REMOVED Substitution** reg = new KInteger((c_j.getInstanceInt(s0_ref) - 1));
           // **REMOVED Substitution** ref = s0_ref;
          c_j.setInstanceInt(this_ref,(c_j.getInstanceInt(this_ref) - 1));
        }
         // *********[50] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[51] GETFIELD(jnt.scimark2.Random,haveRange,Z)
         // **REMOVED Substitution** s0 = c_haveRange.getInstanceValue(this_ref);
         // *********[-1] BlocIF(BlocItem{[52] IFEQ(65)})
        if(c_haveRange.getInstanceValue(this_ref).intValue() != 0){
           // *********[53] ALOAD(0)
           // **REMOVED Substitution** s0_ref = this_ref;
           // *********[54] GETFIELD(jnt.scimark2.Random,left,D)
           // **REMOVED Substitution** s0 = new KDouble(c_left.getInstanceDouble(this_ref));
           // *********[55] ALOAD(0)
           // **REMOVED Substitution** s1_ref = this_ref;
           // *********[56] GETFIELD(jnt.scimark2.Random,dm1,D)
           // **REMOVED Substitution** s1 = new KDouble(c_dm1.getInstanceDouble(this_ref));
           // *********[57] ILOAD(1)
           // **REMOVED Substitution** s2 = new KInteger(local_1);
           // *********[58] I2D
           // **REMOVED Substitution** s2 = new KDouble(local_1);
           // *********[59] DMUL
           // **REMOVED Substitution** m_d = ((double)local_1);
           // **REMOVED Substitution** s1 = new KDouble((c_dm1.getInstanceDouble(this_ref) * ((double)local_1)));
           // *********[60] ALOAD(0)
           // **REMOVED Substitution** s2_ref = this_ref;
           // *********[61] GETFIELD(jnt.scimark2.Random,width,D)
           // **REMOVED Substitution** s2 = new KDouble(c_width.getInstanceDouble(this_ref));
           // *********[62] DMUL
           // **REMOVED Substitution** m_d2 = c_width.getInstanceDouble(this_ref);
           // **REMOVED Substitution** s1 = new KDouble(((c_dm1.getInstanceDouble(this_ref) * ((double)local_1)) * c_width.getInstanceDouble(this_ref)));
           // *********[63] DADD
           // **REMOVED Substitution** m_d3 = s1.doubleValue();
           // **REMOVED Substitution** s0 = new KDouble((c_left.getInstanceDouble(this_ref) + ((c_dm1.getInstanceDouble(this_ref) * ((double)local_1)) * c_width.getInstanceDouble(this_ref))));
           // *********[64] DRETURN
           // **REMOVED Substitution** reg = new KDouble((c_left.getInstanceDouble(this_ref) + ((c_dm1.getInstanceDouble(this_ref) * ((double)local_1)) * c_width.getInstanceDouble(this_ref))));
          frame.setLocal(1,new KInteger(local_1));
          callerFrame = thread.popFrame();
          callerFrame.push(new KDouble((c_left.getInstanceDouble(this_ref) + ((c_dm1.getInstanceDouble(this_ref) * ((double)local_1)) * c_width.getInstanceDouble(this_ref)))));
          return ((JJITInstruction)callerFrame.getCurrentInstruction());
        }
         // *********[65] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[66] GETFIELD(jnt.scimark2.Random,dm1,D)
         // **REMOVED Substitution** s0 = new KDouble(c_dm1.getInstanceDouble(this_ref));
         // *********[67] ILOAD(1)
         // **REMOVED Substitution** s1 = new KInteger(local_1);
         // *********[68] I2D
         // **REMOVED Substitution** s1 = new KDouble(local_1);
         // *********[69] DMUL
         // **REMOVED Substitution** m_d4 = ((double)local_1);
         // **REMOVED Substitution** s0 = new KDouble((c_dm1.getInstanceDouble(this_ref) * ((double)local_1)));
         // *********[70] DRETURN
         // **REMOVED Substitution** reg = new KDouble((c_dm1.getInstanceDouble(this_ref) * ((double)local_1)));
        callerFrame = thread.popFrame();
        callerFrame.push(new KDouble((c_dm1.getInstanceDouble(this_ref) * ((double)local_1))));
        return ((JJITInstruction)callerFrame.getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(0)
         // *********[1] GETFIELD(jnt.scimark2.Random,m,[I)
        c_repo = process.getClassRepository();
        c_CRandom = c_repo.getClassByName("jnt.scimark2.Random");
        c_m = c_CRandom.getField("m",true);
         // *********[2] ALOAD(0)
         // *********[3] GETFIELD(jnt.scimark2.Random,i,I)
        c_i = c_CRandom.getField("i",true);
         // *********[4] IALOAD
        c_memman = process.getMemoryManager();
         // *********[5] ALOAD(0)
         // *********[6] GETFIELD(jnt.scimark2.Random,m,[I)
         // *********[7] ALOAD(0)
         // *********[8] GETFIELD(jnt.scimark2.Random,j,I)
        c_j = c_CRandom.getField("j",true);
         // *********[9] IALOAD
         // *********[10] ISUB
         // *********[11] ISTORE(1)
         // *********[12] ILOAD(1)
         // *********[-1] BlocIF(BlocItem{[13] IFGE(18)})
         // *********[14] ILOAD(1)
         // *********[15] LDC(9->"2147483647")
         // *********[16] IADD
         // *********[17] ISTORE(1)
         // *********[18] ALOAD(0)
         // *********[19] GETFIELD(jnt.scimark2.Random,m,[I)
         // *********[20] ALOAD(0)
         // *********[21] GETFIELD(jnt.scimark2.Random,j,I)
         // *********[22] ILOAD(1)
         // *********[23] IASTORE
         // *********[24] ALOAD(0)
         // *********[25] GETFIELD(jnt.scimark2.Random,i,I)
         // *********[-1] BlocIF(BlocItem{[26] IFNE(31)})
         // *********[27] ALOAD(0)
         // *********[28] BIPUSH(16)
         // *********[29] PUTFIELD(jnt.scimark2.Random,i)
         // *********[31] ALOAD(0)
         // *********[32] DUP
         // *********[33] GETFIELD(jnt.scimark2.Random,i,I)
         // *********[34] ICONST_1(Integer{1})
         // *********[35] ISUB
         // *********[36] PUTFIELD(jnt.scimark2.Random,i)
         // *********[37] ALOAD(0)
         // *********[38] GETFIELD(jnt.scimark2.Random,j,I)
         // *********[-1] BlocIF(BlocItem{[39] IFNE(44)})
         // *********[40] ALOAD(0)
         // *********[41] BIPUSH(16)
         // *********[42] PUTFIELD(jnt.scimark2.Random,j)
         // *********[44] ALOAD(0)
         // *********[45] DUP
         // *********[46] GETFIELD(jnt.scimark2.Random,j,I)
         // *********[47] ICONST_1(Integer{1})
         // *********[48] ISUB
         // *********[49] PUTFIELD(jnt.scimark2.Random,j)
         // *********[50] ALOAD(0)
         // *********[51] GETFIELD(jnt.scimark2.Random,haveRange,Z)
        c_haveRange = c_CRandom.getField("haveRange",true);
         // *********[-1] BlocIF(BlocItem{[52] IFEQ(65)})
         // *********[53] ALOAD(0)
         // *********[54] GETFIELD(jnt.scimark2.Random,left,D)
        c_left = c_CRandom.getField("left",true);
         // *********[55] ALOAD(0)
         // *********[56] GETFIELD(jnt.scimark2.Random,dm1,D)
        c_dm1 = c_CRandom.getField("dm1",true);
         // *********[57] ILOAD(1)
         // *********[58] I2D
         // *********[59] DMUL
         // *********[60] ALOAD(0)
         // *********[61] GETFIELD(jnt.scimark2.Random,width,D)
        c_width = c_CRandom.getField("width",true);
         // *********[62] DMUL
         // *********[63] DADD
         // *********[64] DRETURN
         // *********[65] ALOAD(0)
         // *********[66] GETFIELD(jnt.scimark2.Random,dm1,D)
         // *********[67] ILOAD(1)
         // *********[68] I2D
         // *********[69] DMUL
         // *********[70] DRETURN
      }
}
