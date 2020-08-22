/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.usr;

import java.util.ArrayList;
import java.util.Map.Entry;
import org.doovos.api.DProcess;
import org.doovos.api.DSystem;
import org.doovos.lib.text.ConsoleTable;

/**
 *
 * @author vpc
 */
public class penv {

    static{
        if (DSystem.isDoovosEnabled()) {
            DProcess pp = DProcess.getProcess();
            String title = pp.getMetadata("title");
            if (title == null) {
                pp.setMetadata("title", "penv");
                pp.setMetadata("version", "0.2");
                pp.setMetadata("author", "Taha BEN SALAH");
                pp.setMetadata("date", "2010-12-08");
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> pids = new ArrayList<Integer>();
        for (String a : args) {
            pids.add(Integer.parseInt(a));
        }
        if (pids.isEmpty()) {
            pids.add(DProcess.getProcess().getPID());
        }
        for (Integer p : pids) {
            System.out.println("PID : " + p);
            ConsoleTable consoleTable = new ConsoleTable();
            consoleTable.addColumn("VAR");
            consoleTable.addColumn("VALUE");
            consoleTable.setShowHeader(true);
            DProcess process = DProcess.getProcess(p);
            for (Entry<Object, Object> entry : process.getEnvs().entrySet()) {
                consoleTable.addCell(String.valueOf(entry.getKey()));
                consoleTable.addCell(String.valueOf(entry.getValue()));
            }
            consoleTable.write(System.out);
        }
    }
}
