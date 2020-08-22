/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.usr;

import java.util.ArrayList;
import org.doovos.api.DMemorySegment;
import org.doovos.api.DProcess;
import org.doovos.api.DSystem;
import org.doovos.lib.text.ConsoleTable;

/**
 *
 * @author vpc
 */
public class ps {

    static {
        if (DSystem.isDoovosEnabled()) {
            DProcess pp = DProcess.getProcess();
            String title = pp.getMetadata("title");
            if (title == null) {
                pp.setMetadata("title", "ps");
                pp.setMetadata("version", "0.3");
                pp.setMetadata("author", "Taha BEN SALAH");
//                pp.setMetadata("date", "2010-12-08");
                pp.setMetadata("date", "2011-06-06");
            }
        }
    }

    public static void main(String[] args) {
//        ArrayList<Integer> pids = new ArrayList<Integer>();
//        for (String a : args) {
//            if (a.startsWith("-d")) {
//                //format = 'd';
//            } else if (a.startsWith("-")) {
//                System.err.println("Unknown option " + a);
//                System.exit(1);
//            } else {
//                pids.add(Integer.parseInt(a));
//            }
//        }
//        if (pids.isEmpty()) {
//        }
        int[] pids = DProcess.getAllProcesses();
        ConsoleTable consoleTable = new ConsoleTable();
        consoleTable.addColumn("PID");
        consoleTable.addColumn("PPID");
        consoleTable.addColumn("Command Line");
        consoleTable.addColumn("Class Repository");
        consoleTable.addColumn("Memory Segments");
        consoleTable.setShowHeader(true);
        for (Integer p : pids) {
            DProcess process = DProcess.getProcess(p);
            consoleTable.addCell(String.valueOf(process.getPID()));
            consoleTable.addCell(String.valueOf(process.getParentPID()));
            consoleTable.addCell(process.getCommandLine());
            consoleTable.addCell(process.getClassRepository().getName() + "@" + process.getClassRepository().getCurrentSiteId());
            StringBuilder ms = new StringBuilder();
            for (DMemorySegment m : process.getMemorySegments()) {
                if (ms.length() > 0) {
                    ms.append(",");
                }
                ms.append(m.getName()).append("@").append(m.getCurrentSiteId());
            }
            consoleTable.addCell(ms.toString());
        }
        consoleTable.write(System.out);
    }
}
