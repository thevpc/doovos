/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.debug;

/**
 *
 * @author vpc
 */
public final class JJITDebug {

    private boolean stat = true;
    /**
     * when true JJIT will recompile method if some of its instructions invoke may a class initiaization and this class has already been loaded
     */
    private boolean optRecompileOnClassLoaded = true;
    private boolean optStack = true;
    private boolean optLocal = true;
    private boolean optFields = true;
    private boolean optSubstitute = true;
    private boolean optSimplify = true;
    private boolean optCacheClasses = true;
    private boolean methodHashId = true;
    private boolean primitiveLocals = true;
    private boolean disassemble = false;
    private boolean log = false;
    private boolean noComments = false;
    /**
     * if number of method invokation reaches optCompileOnCallThreshold and processorType is ProcessorType.LAZY_COMPILE
     * than method is compiled
     */
    private int optCompileOnCallThreshold = 1;
    private String packageSuffix;
    private int classIndex;
    private ProcessorType processorType = ProcessorType.EAGER_COMPILE;

    public JJITDebug() {
    }

    public int getClassIndex() {
        return classIndex;
    }

    public void setClassIndex(int classIndex) {
        this.classIndex = classIndex;
    }

    public boolean isOptLocal() {
        return optLocal;
    }

    public void setOptLocal(boolean optLocal) {
        this.optLocal = optLocal;
    }

    public boolean isOptFields() {
        return optFields;
    }

    public void setOptFields(boolean optFields) {
        this.optFields = optFields;
    }

    public boolean isOptStack() {
        return optStack;
    }

    public void setOptStack(boolean optStack) {
        this.optStack = optStack;
    }

    public boolean isOptSubstitute() {
        return optSubstitute;
    }

    public void setOptSubstitute(boolean optSubstitute) {
        this.optSubstitute = optSubstitute;
    }

    public boolean isOptCacheClasses() {
        return optCacheClasses;
    }

    public void setOptCacheClasses(boolean optCacheClasses) {
        this.optCacheClasses = optCacheClasses;
    }

    public boolean isMethodHashId() {
        return methodHashId;
    }

    public void setMethodHashId(boolean methodHashId) {
        this.methodHashId = methodHashId;
    }

    public boolean isDisassemble() {
        return disassemble;
    }

    public void setDisassemble(boolean disassemble) {
        this.disassemble = disassemble;
    }

    public boolean isLog() {
        return log;
    }

    public void setLog(boolean log) {
        this.log = log;
    }

    public String getPackageSuffix() {
        return packageSuffix;
    }

    public void setPackageSuffix(String packageSuffix) {
        this.packageSuffix = packageSuffix;
    }

    public boolean isNoComments() {
        return noComments;
    }

    public void setNoComments(boolean noComments) {
        this.noComments = noComments;
    }

    public boolean isOptSimplify() {
        return optSimplify;
    }

    public void setOptSimplify(boolean optExtra) {
        this.optSimplify = optExtra;
    }

    public boolean isPrimitiveLocals() {
        return primitiveLocals;
    }

    public void setPrimitiveLocals(boolean primitiveLocals) {
        this.primitiveLocals = primitiveLocals;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JJITDebug other = (JJITDebug) obj;
        if (this.optStack != other.optStack) {
            return false;
        }
        if (this.optLocal != other.optLocal) {
            return false;
        }
        if (this.optFields != other.optFields) {
            return false;
        }
        if (this.optSubstitute != other.optSubstitute) {
            return false;
        }
        if (this.optSimplify != other.optSimplify) {
            return false;
        }
        if (this.optCacheClasses != other.optCacheClasses) {
            return false;
        }
        if (this.methodHashId != other.methodHashId) {
            return false;
        }
        if (this.primitiveLocals != other.primitiveLocals) {
            return false;
        }
        if (this.disassemble != other.disassemble) {
            return false;
        }
        if (this.log != other.log) {
            return false;
        }
        if (this.noComments != other.noComments) {
            return false;
        }
        if (this.optCompileOnCallThreshold != other.optCompileOnCallThreshold) {
            return false;
        }
        if (this.optRecompileOnClassLoaded != other.optRecompileOnClassLoaded) {
            return false;
        }
        if ((this.packageSuffix == null) ? (other.packageSuffix != null) : !this.packageSuffix.equals(other.packageSuffix)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + (this.optStack ? 1 : 0);
        hash = 47 * hash + (this.optLocal ? 1 : 0);
        hash = 47 * hash + (this.optFields ? 1 : 0);
        hash = 47 * hash + (this.optSubstitute ? 1 : 0);
        hash = 47 * hash + (this.optSimplify ? 1 : 0);
        hash = 47 * hash + (this.optCacheClasses ? 1 : 0);
        hash = 47 * hash + (this.methodHashId ? 1 : 0);
        hash = 47 * hash + (this.primitiveLocals ? 1 : 0);
        hash = 47 * hash + (this.disassemble ? 1 : 0);
        hash = 47 * hash + (this.log ? 1 : 0);
        hash = 47 * hash + (this.noComments ? 1 : 0);
        hash = 47 * hash + (this.optRecompileOnClassLoaded ? 1 : 0);
        hash = 47 * hash + (this.packageSuffix != null ? this.packageSuffix.hashCode() : 0);
        hash = 47 * hash + optCompileOnCallThreshold;
        return hash;
    }

    @Override
    public String toString() {
        return "JJITDebug{" + processorType + ", " + "optStack=" + optStack + ", optLocal=" + optLocal + ", optFields=" + optFields + ", optSubstitute=" + optSubstitute + ", optSimplify=" + optSimplify + ", optCacheClasses=" + optCacheClasses + ", methodHashId=" + methodHashId + ", primitiveLocals=" + primitiveLocals + ", disassemble=" + disassemble + ", log=" + log + ", noComments=" + noComments + ", packageSuffix=" + packageSuffix + ", optimizationCallThreshold=" + optCompileOnCallThreshold + '}';
    }

    public boolean isStat() {
        return stat;
    }

    public void setStat(boolean stat) {
        this.stat = stat;
    }

    public ProcessorType getProcessorType() {
        return processorType;
    }

    public void setProcessorType(ProcessorType processorType) {
        this.processorType = processorType;
    }

    public int getOptimizationCallThreshold() {
        return optCompileOnCallThreshold;
    }

    public void setOptimizationCallThreshold(int optimizationCallThreshold) {
        this.optCompileOnCallThreshold = optimizationCallThreshold;
    }

    public boolean isOptRecompileOnClassLoaded() {
        return optRecompileOnClassLoaded;
    }

    public void setOptRecompileOnClassLoaded(boolean optRecompileOnClassLoaded) {
        this.optRecompileOnClassLoaded = optRecompileOnClassLoaded;
    }

    public static enum ProcessorType {

        INTERPRET_ONLY,
        LAZY_COMPILE,
        EAGER_COMPILE
    }
}
