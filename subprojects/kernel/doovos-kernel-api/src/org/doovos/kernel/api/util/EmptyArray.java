package org.doovos.kernel.api.util;

import org.doovos.kernel.api.jvm.bytecode.KClassDef;
import org.doovos.kernel.api.jvm.bytecode.KFieldDef;
import org.doovos.kernel.api.jvm.bytecode.KMethodDef;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 29/07/11
 * Time: 17:26
 * To change this template use File | Settings | File Templates.
 */
public final class EmptyArray {
    public static final long[] LONGS=new long[0];
    public static final byte[] BYTES=new byte[0];
    public static final String[] STRINGS=new String[0];
    public static final int[] INTS=new int[0];
    public static final KClassDef[] EMPTY_ARRAY_KCLASSDEF = new KClassDef[0];
    //    private static final String[] EMPTY_ARRAY_STRING = new String[0];
    public static final KFieldDef[] EMPTY_ARRAY_KFIELDDEF = new KFieldDef[0];
    public static final KMethodDef[] EMPTY_ARRAY_KMETHODDEF = new KMethodDef[0];
    public static final Object[] EMPTY_ARRAY_OBJECT = new Object[0];
}
