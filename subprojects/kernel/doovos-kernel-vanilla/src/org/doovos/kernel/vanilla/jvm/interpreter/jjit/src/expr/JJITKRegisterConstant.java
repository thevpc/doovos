package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr;

import org.doovos.kernel.api.memory.*;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.pattern.JJITPattern;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.pattern.JJITPatternUtils;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsage;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsageList;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsageType;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Types;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITDecField;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITDecVar;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.TypeStruct;

public class JJITKRegisterConstant extends JJITExpressionImpl {

    private JJITConstant javaConst;
    private String registerExpression;
    private String preferredName;
    private KRegisterType regType;
//    private KRegisterType registerType;

    public JJITKRegisterConstant(String registerExpression, JJITConstant javaConst, String preferredName, KRegisterType regType) {
        this.registerExpression = registerExpression;
        this.javaConst = javaConst;
        this.preferredName = preferredName;
        this.regType = regType;
    }

    public JJITExpression simplify(Map<String, JJITDecField> fields, Map<String, JJITDecVar> varsMap) {
        return this;
    }

    public TypeStruct getExpressionType() {
        return Types.KREGISTER;
    }

    
    public JJITVarUsageList getVarUsage(String ... names) {
        JJITVarUsageList list=new JJITVarUsageList();
        for (String name : names) {
            if(preferredName.equals(name)){
                list.add(new JJITVarUsage(new JJITName(preferredName,getExpressionType()), JJITVarUsageType.WRITE));
                break;
            }
        }
        return list;
    }
    

    protected Map<JJITPattern, JJITExpression> matchesImpl(JJITExpression o, Map<JJITPattern, JJITExpression> ee) {
        JJITKRegisterConstant other = (JJITKRegisterConstant) o;
        if (
                !JJITPatternUtils.matches(javaConst, other.javaConst,ee)
                || !JJITPatternUtils.matches(registerExpression, other.registerExpression)
                || !JJITPatternUtils.matches(preferredName, other.preferredName)
                || !JJITPatternUtils.matchesObj(regType, other.regType)
                ) {
            return null;
        }
        return ee;
    }

    public boolean isReadVar(String name) {
        return false;
    }

    public boolean isWriteVar(String name) {
        return false;
    }

    public JJITExpression replace(JJITExpression a, JJITExpression b) {
        if (a.equals(this)) {
            return b.copy();
        }
        return copy();
    }

    public JJITExpression copy() {
        return new JJITKRegisterConstant(registerExpression, javaConst, preferredName, regType);
    }

    public void write(PrintStream out) {
        out.print(registerExpression);
    }

    public void write(PrintWriter out) {
        out.print(registerExpression);
    }

    public Collection<JJITExpression> getChildren() {
        return Collections.EMPTY_LIST;
    }

    public JJITKRegisterConstant(KRegister val) {
        JJITExpression e = null;
        String t = null;
        if (val instanceof KInteger) {
//            t = val.getClass().getSimpleName();
            KInteger i = (KInteger) val;
            regType = KRegisterType.INTEGER;
            switch (i.value) {
                case -1: {
                    preferredName = "IM1";
                    registerExpression = "KInteger.M1";
                    javaConst = JJITConstant.asInt(i.value);
                    break;
                }
                case 0: {
                    preferredName = "IZERO";
                    registerExpression = "KInteger.ZERO";
                    javaConst = JJITConstant.asInt(i.value);
                    break;
                }
                case 1: {
                    preferredName = "IONE";
                    registerExpression = "KInteger.ONE";
                    javaConst = JJITConstant.asInt(i.value);
                    break;
                }
                case 2: {
                    preferredName = "ITWO";
                    registerExpression = "KInteger.TWO";
                    javaConst = JJITConstant.asInt(i.value);
                    break;
                }
                case 3: {
                    preferredName = "ITHREE";
                    registerExpression = "KInteger.THREE";
                    javaConst = JJITConstant.asInt(i.value);
                    break;
                }
                case 4: {
                    preferredName = "IFOUR";
                    registerExpression = "KInteger.FOUR";
                    javaConst = JJITConstant.asInt(i.value);
                    break;
                }
                case 5: {
                    preferredName = "IFIVE";
                    registerExpression = "KInteger.FIVE";
                    javaConst = JJITConstant.asInt(i.value);
                    break;
                }
                default: {
                    preferredName = "I" + String.valueOf(i.value).replace('-', 'M');
                    registerExpression = "new KInteger(" + i.value + ")";
                    javaConst = JJITConstant.asInt(i.value);
                }
            }
        } else if (val instanceof KDouble) {
            t = val.getClass().getSimpleName();
            KDouble i = (KDouble) val;
            regType = KRegisterType.DOUBLE;
            if (i.value == -1) {
                preferredName = "DM1";
                registerExpression = "KDouble.M1";
                javaConst = JJITConstant.asDouble(i.value);
            } else if (i.value == 0) {
                preferredName = "DZERO";
                registerExpression = "KDouble.ZERO";
                javaConst = JJITConstant.asDouble(i.value);
            } else if (i.value == 1) {
                preferredName = "DONE";
                registerExpression = "KDouble.ONE";
                javaConst = JJITConstant.asDouble(i.value);
            } else {
                preferredName = "D" + String.valueOf(i.value).replace('-', 'M').replace('.', '_').replace('+', '_').replace('-', '_');
                registerExpression = "new KDouble(" + i.value + "D)";
                javaConst = JJITConstant.asDouble(i.value);
            }
        } else if (val instanceof KFloat) {
//            t = val.getClass().getSimpleName();
            KFloat i = (KFloat) val;
            regType = KRegisterType.FLOAT;
            if (i.value == -1) {
                preferredName = "FM1";
                registerExpression = "KFloat.M1";
                javaConst = JJITConstant.asFloat(i.value);
            } else if (i.value == 0) {
                preferredName = "FZERO";
                registerExpression = "KFloat.ZERO";
                javaConst = JJITConstant.asFloat(i.value);
            } else if (i.value == 1) {
                preferredName = "FONE";
                registerExpression = "KFloat.ONE";
                javaConst = JJITConstant.asFloat(i.value);
            } else {
                preferredName = "F" + String.valueOf(i.value).replace('-', 'M').replace('.', '_').replace('+', '_').replace('-', '_');
                registerExpression = "new KFloat(" + i.value + "F)";
                javaConst = JJITConstant.asFloat(i.value);
            }
        } else if (val instanceof KLong) {
//            t = val.getClass().getSimpleName();
            KLong i = (KLong) val;
            regType = KRegisterType.LONG;
            if (i.value == 0) {
                preferredName = "LZERO";
                registerExpression = "KLong.ZERO";
                javaConst = JJITConstant.asLong(i.value);
            } else if (i.value == 1) {
                preferredName = "LONE";
                registerExpression = "KLong.ONE";
                javaConst = JJITConstant.asLong(i.value);
            } else {
                preferredName = "L" + String.valueOf(i.value).replace('-', 'M');
                registerExpression = "new KLong(" + i.value + "L)";
                javaConst = JJITConstant.asLong(i.value);
            }
//        } else if (val instanceof KInitConst) {
//            t = "KRegister";
//            KInitConst k = (KInitConst) val;
//            n = new JJITName("R" + k.constId);
//            e = JJITConst.NULL;
//            init.set(n, new JJITName("constants").arr(k.getConstId()));
        } else if (val instanceof KReturn) {
            KReturn k = (KReturn) val;
            regType = KRegisterType.RETURN;
            preferredName = "T" + k.value;
            registerExpression = "new KReturn(" + k.value + ")";
            javaConst = JJITConstant.asInt(k.value);
        } else {
            throw new IllegalArgumentException("Unsupported const type");
        }
    }

    public String getRegisterExpression() {
        return registerExpression;
    }

    public JJITConstant getJavaConst() {
        return javaConst;
    }

    public String getPreferredName() {
        return preferredName;
    }

    public KRegisterType getRegType() {
        return regType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        JJITKRegisterConstant that = (JJITKRegisterConstant) o;

        if (javaConst != null ? !javaConst.equals(that.javaConst) : that.javaConst != null) {
            return false;
        }
        if (preferredName != null ? !preferredName.equals(that.preferredName) : that.preferredName != null) {
            return false;
        }
        if (regType != null ? !regType.equals(that.regType) : that.regType != null) {
            return false;
        }
        if (registerExpression != null ? !registerExpression.equals(that.registerExpression) : that.registerExpression != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = registerExpression != null ? registerExpression.hashCode() : 0;
        result = 31 * result + (javaConst != null ? javaConst.hashCode() : 0);
        result = 31 * result + (preferredName != null ? preferredName.hashCode() : 0);
        result = 31 * result + (regType != null ? regType.hashCode() : 0);
        return result;
    }
}
