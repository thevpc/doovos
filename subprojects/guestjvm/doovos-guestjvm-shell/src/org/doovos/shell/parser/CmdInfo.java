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
 * Doovos BIN is a standard implementation for Doovos boot sequence, shell and
 * common application tools. These applications are running onDoovos guest JVM
 * (distributed jvm).
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
package org.doovos.shell.parser;

import java.util.ArrayList;

public class CmdInfo {
    public ArrayList items = new ArrayList();
    public ArrayList usingKeys = new ArrayList();
    public ArrayList usingValues = new ArrayList();
    public String out;
    public boolean outAppend;
    public String in;
    public boolean inAppend;
    public String err;
    public boolean errAppend;
    public boolean nowait;

    public CmdInfo() {
    }

    public String getOut() {
        return out;
    }

    public void setOut(String out) {
        this.out = out;
    }

    public boolean isOutAppend() {
        return outAppend;
    }

    public void setOutAppend(boolean outAppend) {
        this.outAppend = outAppend;
    }

    public String getIn() {
        return in;
    }

    public void setIn(String in) {
        this.in = in;
    }

    public boolean isInAppend() {
        return inAppend;
    }

    public void setInAppend(boolean inAppend) {
        this.inAppend = inAppend;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }

    public boolean isErrAppend() {
        return errAppend;
    }

    public void setErrAppend(boolean errAppend) {
        this.errAppend = errAppend;
    }

    public boolean isNowait() {
        return nowait;
    }

    public void setNowait(boolean nowait) {
        this.nowait = nowait;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            String item = (String) items.get(i);
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(addcomma(item));
        }
        if (usingKeys.size() > 0) {
            sb.append(" using ");
            for (int i = 0; i < usingKeys.size(); i++) {
                String k = (String) usingKeys.get(i);
                String v = (String) usingValues.get(i);
                sb.append(" ").append(addcomma(k)).append("=").append(addcomma(v));
            }
        }
        if (out != null) {
            if (outAppend) {
                sb.append(" >> ").append(addcomma(out));
            } else {
                sb.append(" > ").append(addcomma(out));
            }
        }
        if (err != null) {
            if (errAppend) {
                sb.append(" 2>> ").append(addcomma(err));
            } else {
                sb.append(" 2> ").append(addcomma(err));
            }
        }
        if (in != null) {
            if (inAppend) {
                sb.append(" << ").append(addcomma(in));
            } else {
                sb.append(" < ").append(addcomma(in));
            }
        }
        if (sb.length() > 0) {
            if (nowait) {
                sb.append(" &");
            }
        } else {
            sb.append("<EMPTY COMMAND>");
        }
        return sb.toString();
    }

    private String addcomma(String s) {
        char c;
        int max = s.length();
        boolean cote = false;
        boolean space = false;
        for (int i = 0; i < max; i++) {
            c = s.charAt(i);
            switch (c) {
                case '\'': {
                    cote = true;
                    break;
                }
                case ' ': {
                    space = true;
                    break;
                }
            }
        }
        if (!space && !cote) {
            return s;
        } else if (space && !cote) {
            return "\'" + s + "\'";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("\'");
            for (int i = 0; i < max; i++) {
                c = s.charAt(i);
                switch (c) {
                    case '\'': {
                        sb.append("\\\'");
                        break;
                    }
                    default: {
                        sb.append(c);
                        break;
                    }
                }
            }
            sb.append("\'");
            return sb.toString();
        }
    }
}