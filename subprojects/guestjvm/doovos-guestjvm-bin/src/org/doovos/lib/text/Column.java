/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.lib.text;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vpc
 */
public class Column {

    private int width = -1;
    private int preferredWidth = 0;
    private Text header;
    private ArrayList<Text> values = new ArrayList<Text>();

    public Column(Text header) {
        this.header = header;
        preferredWidth = header.length();
    }

    public int getRunWidth() {
        return (width == -1) ? preferredWidth : width;
    }

    public List<Text> getValues() {
        return values;
    }


    public void addCell(Text value) {
        values.add(value);
        int len = value.length();
        if (len > preferredWidth) {
            preferredWidth = len;
        }
    }

    public Text getCell(int i) {
        return values.get(i);
    }

    public void writeHeader(PrintStream out) {
        int alen = (width == -1) ? preferredWidth : width;
        header.write(out, alen, alen);
    }

    public void writeCell(PrintStream out, int i) {
        int alen = (width == -1) ? preferredWidth : width;
        values.get(i).write(out, alen, alen);
    }
}
