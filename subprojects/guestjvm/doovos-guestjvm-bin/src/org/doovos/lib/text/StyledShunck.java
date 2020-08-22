/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.lib.text;

import java.io.PrintStream;

/**
 *
 * @author vpc
 */
public class StyledShunck implements Text {

    String value;
    Object/*Attributes*/ style;

    public StyledShunck(Object ovalue, Object/*Attributes*/ style) {

        if (ovalue == null) {
            value = "";
        } else if (ovalue instanceof Class) {
            value = ((Class) ovalue).getSimpleName();
        } else {
            value = String.valueOf(ovalue);
        }
        this.style = style;
    }

    public StyledShunck(String value, Object/*Attributes*/ style) {
        this.value = value;
        this.style = style;
    }

    public int length() {
        return value.length();
    }

    public void write(PrintStream out, int min, int max) {
        out.print(ConsoleTable.pad(value, min, max)/*, style*/);
    }
}
