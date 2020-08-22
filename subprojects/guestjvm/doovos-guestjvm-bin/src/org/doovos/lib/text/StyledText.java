/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.lib.text;

import java.io.PrintStream;
import java.util.ArrayList;

/**
 *
 * @author vpc
 */
public class StyledText implements Text {

    ArrayList<StyledShunck> text = new ArrayList<StyledShunck>();
    int len = 0;

    public StyledText() {
    }

    public StyledText add(StyledShunck ss) {
        text.add(ss);
        len += ss.length();
        return this;
    }

    public int length() {
        return len;
    }

    public void write(PrintStream out, int min, int max) {
        int newMax = max;
        for (StyledShunck styledShunck : text) {
            styledShunck.write(out, -1, newMax);
            newMax -= styledShunck.length();
        }
        if (newMax > 0) {
            out.print(ConsoleTable.pad("", newMax, newMax));
        }
    }
}
