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
public interface Text {

    public int length();

    public void write(PrintStream out, int min, int max);
}
