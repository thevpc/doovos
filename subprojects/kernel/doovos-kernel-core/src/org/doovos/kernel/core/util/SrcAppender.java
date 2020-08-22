/**
 * ====================================================================
 *             Doovos (Distributed Object Oriented Operating System)
 *
 * Doovos is a new Open Source Distributed Object Oriented Operating System
 * Design and implementation based on the Java Platform.
 * Actually, it is a try for designing a distributed operation system in
 * top of existing centralized/network OS.
 * Designed OS will follow the object oriented architecture for redefining
 * all OS resources (memory,process,file system,device,...etc.) in a highly
 * distributed context.
 * Doovos is also a distributed Java virtual machine that implements JVM
 * specification on top the distributed resources context.
 *
 * Doovos Kernel is the heart of Doovos OS. It implements also the Doovos JVM
 * Doovos Kernel code is executed on host JVM
 *
 * Copyright (C) 2008-2010 Taha BEN SALAH
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 * ====================================================================
 */
package org.doovos.kernel.core.util;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 8 mars 2009
 * Time: 22:07:15
 * To change this template use File | Settings | File Templates.
 */
public class SrcAppender implements CharSequence {
    private int marginValue;
    private String margin;
    private StringBuilder code = new StringBuilder();

    public SrcAppender(int margin) {
        this.marginValue = margin;
        revalidateMargin();
    }

    public SrcAppender assign(String varName,String varValue) {
        code.append(margin).append(varName).append(" = ").append(varValue).append(";").append(";");
        return this;
    }

    public SrcAppender append(String s) {
        code.append(s);
        return this;
    }
    public SrcAppender line(String s) {
        code.append(margin).append(s).append("\n");
        return this;
    }


    public SrcAppender indent() {
        marginValue += 2;
        revalidateMargin();
        return this;
    }

    public SrcAppender outdent() {
        marginValue -= 2;
        return this;
    }

    private void revalidateMargin() {
        if (marginValue > 0) {
            char[] a = new char[marginValue];
            for (int i = 0; i < a.length; i++) {
                a[i] = ' ';
            }
            this.margin = new String(a);
        } else {
            marginValue = 0;
            this.margin = "";
        }
    }

    public int length() {
        return code.length();
    }

    public char charAt(int index) {
        return code.charAt(index);
    }

    public CharSequence subSequence(int start, int end) {
        return code.subSequence(start, end);
    }

    public String toString() {
        return code.toString();
    }
}
