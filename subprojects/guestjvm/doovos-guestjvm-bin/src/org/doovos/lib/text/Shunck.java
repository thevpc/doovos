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
public class Shunck implements Text {

    String value;

    public Shunck(String value) {
        this.value = value==null?"":value;
    }

    public int length() {
        return value.length();
    }

    public void write(PrintStream out, int min, int max) {
        out.print(ConsoleTable.pad(value, min, max));
    }
}
