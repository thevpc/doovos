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
package org.doovos.usr;

import org.doovos.api.DProcess;
import org.doovos.api.DSite;
import org.doovos.api.DSystem;

public class swan {
    
    static{
        if (DSystem.isDoovosEnabled()) {
            DProcess pp = DProcess.getProcess();
            String title = pp.getMetadata("title");
            if (title == null) {
                pp.setMetadata("title", "swan");
                pp.setMetadata("version", "0.2");
                pp.setMetadata("author", "Taha BEN SALAH");
                pp.setMetadata("date", "2010-12-08");
            }
        }
    }

    public static void main(String[] args) {
        int max = 100;
        long sleep = 1000;
        for (int i = 0; i < max; i++) {
            System.out.println("[" + System.currentTimeMillis() + "] i'm flying over " + DSystem.getLocalSite().getName() + "\n");
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException ex) {
                //ignore
            }
            migrate();
        }
    }
    public static void migrate(){
        DSite current=DSystem.getLocalSite();
        DSite[] sites=DSystem.getSites();
        DSite next=current;
        if(sites.length>1){
            int i=(int)(sites.length*Math.random());
            next=sites[i];
        }
        if(!next.getUUID().equals(current.getUUID())){
           DSystem.migrateCurrentThread(next.getName());
        }
    }
}