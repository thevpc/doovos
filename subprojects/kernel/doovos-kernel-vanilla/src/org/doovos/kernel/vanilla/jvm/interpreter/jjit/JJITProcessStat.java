package org.doovos.kernel.vanilla.jvm.interpreter.jjit;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import org.doovos.kernel.core.util.IntHashMap;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.stats.JJITSharedBlocKey;
import org.doovos.kernel.core.util.IntValueHashMap;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.stats.JJITMethodCompilerStat;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 23/07/11
 * Time: 16:35
 * To change this template use File | Settings | File Templates.
 */
public class JJITProcessStat {

    public IntValueHashMap<JJITSharedBlocKey> sharedBlocsCountDetails = new IntValueHashMap<JJITSharedBlocKey>();
    public Map<String, JJITMethodCompilerStat> methodstat = new HashMap<String, JJITMethodCompilerStat>();

    public IntHashMap getPrivateCount() {
        IntHashMap m = new IntHashMap();
        for (JJITMethodCompilerStat s : methodstat.values()) {
            for (Map.Entry<Integer, Integer> entry : s.getPrivateCompileSize().toMap().entrySet()) {
                m.put(entry.getKey(), entry.getValue() + m.get(entry.getKey(), 0));
            }
        }
        return m;
    }

    public double getExtraRatio() {
        long all = 0;
        long extra = 0;
        for (JJITMethodCompilerStat s : methodstat.values()) {
            all+=s.getInitialSize();
            for (Integer entry : s.getExtraCompileSize().toMap().values()) {
                extra+=entry;
            }
        }
        return ((double)extra)/all;
    }

    public double getBlocSizeRatio() {
        long count = 0;
        long size = 0;
        for (JJITMethodCompilerStat s : methodstat.values()) {
            for (Map.Entry<Integer, Integer> entry : s.getPrivateCompileSize().toMap().entrySet()) {
                count+=entry.getValue();
                size+=entry.getKey()*entry.getValue();
            }
        }
        return (double)size/count;
    }

    public IntHashMap getSharedCount() {
        IntHashMap m = new IntHashMap();
        for (JJITMethodCompilerStat s : methodstat.values()) {
            for (Map.Entry<Integer, Integer> entry : s.getSharedCompileSize().toMap().entrySet()) {
                m.put(entry.getKey(), entry.getValue() + m.get(entry.getKey(), 0));
            }
        }
        return m;
    }
}
