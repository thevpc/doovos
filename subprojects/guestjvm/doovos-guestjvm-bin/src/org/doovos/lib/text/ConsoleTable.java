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
public class ConsoleTable {

    private ArrayList<Column> columns = new ArrayList<Column>();
    private int currentColumn = 0;
    private boolean showHeader = true;

    public ConsoleTable() {
    }

    public boolean isShowHeader() {
        return showHeader;
    }

    public void addColumn(String header) {
        addColumn(new Shunck(header));
    }

    public void addColumn(Text header) {
        columns.add(new Column(header));
    }

    public void newRow() {
        currentColumn = 0;
    }

    public void addCell(String text) {
        addCell(new Shunck(text));
    }

    public void addCell(Text text) {
        columns.get(currentColumn).addCell(text);
        currentColumn++;
        if (currentColumn >= columns.size()) {
            currentColumn = 0;
        }
    }

    public void write(PrintStream out) {
        int columnsCount = columns.size();
        int rowsCount = columns.size() == 0 ? 0 : columns.get(0).getValues().size();
        if (showHeader) {
            for (int i = 0; i < columnsCount; i++) {
                if (i > 0) {
                    out.print(" ");
                }
                Column column = columns.get(i);
                column.writeHeader(out);
                if (i == (columnsCount - 1)) {
                    out.print("\n");
                }
            }
            for (int i = 0; i < columnsCount; i++) {
                if (i > 0) {
                    out.print(" ");
                }
                Column column = columns.get(i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < column.getRunWidth(); j++) {
                    sb.append("-");
                }
                out.print(sb.toString());
                if (i == (columnsCount - 1)) {
                    out.print("\n");
                }
            }
        }
        for (int j = 0; j < rowsCount; j++) {
            for (int i = 0; i < columns.size(); i++) {
                Column column = columns.get(i);
                if (i > 0) {
                    out.print(" ");
                }
                column.writeCell(out, j);
            }
            out.print("\n");
        }
    }

    public void setShowHeader(boolean showHeader) {
        this.showHeader = showHeader;
    }

    public static String pad(String msg, int minSize, int maxSize) {
        StringBuilder sb = new StringBuilder();
        if (maxSize > 0 && msg.length() > maxSize) {
            if (msg.length() > 3) {
                return msg.substring(0, maxSize) + "...";
            } else {
                return "...";
            }
        }
        if (minSize > 0 && minSize > msg.length()) {
            sb.append(msg);
            int x = minSize - msg.length();
            for (int i = 0; i < x; i++) {
                sb.append(' ');
            }
            return sb.toString();
        }
        return msg;
    }

    public static String stringify(Object value) {
        if (value == null) {
            return "";
        } else if (value instanceof Class) {
            return ((Class) value).getSimpleName();
//        } else if (value instanceof Date) {
//            return SDF.format((Date) value);
        } else {
            return String.valueOf(value);
        }
    }
}
