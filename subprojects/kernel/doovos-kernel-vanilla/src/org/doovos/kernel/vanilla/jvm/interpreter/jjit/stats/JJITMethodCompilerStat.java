package org.doovos.kernel.vanilla.jvm.interpreter.jjit.stats;

import org.doovos.kernel.core.util.IntHashMap;
import org.doovos.kernel.core.util.IntValueHashMap;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 23/07/11
 * Time: 16:51
 * To change this template use File | Settings | File Templates.
 */
public class JJITMethodCompilerStat {

    private int initialSize;
    private int finalSize;
    private IntHashMap privateCompileSize = new IntHashMap();
    private IntHashMap sharedCompileSize = new IntHashMap();
    private IntValueHashMap<String> extraCompileSize = new IntValueHashMap<String>();

    public JJITMethodCompilerStat() {
    }

    public IntHashMap getPrivateCompileSize() {
        return privateCompileSize;
    }

    public void setPrivateCompileSize(IntHashMap compileSize) {
        this.privateCompileSize = compileSize;
    }

    public IntHashMap getSharedCompileSize() {
        return sharedCompileSize;
    }

    public void setSharedCompileSize(IntHashMap compileSize) {
        this.sharedCompileSize = compileSize;
    }

    public int getFinalSize() {
        return finalSize;
    }

    public void setFinalSize(int finalSize) {
        this.finalSize = finalSize;
    }

    public int getInitialSize() {
        return initialSize;
    }

    public void setInitialSize(int initialSize) {
        this.initialSize = initialSize;
    }

    public IntValueHashMap<String> getExtraCompileSize() {
        return extraCompileSize;
    }

    public void setExtraCompileSize(IntValueHashMap<String> extraCompileSize) {
        this.extraCompileSize = extraCompileSize;
    }
}
