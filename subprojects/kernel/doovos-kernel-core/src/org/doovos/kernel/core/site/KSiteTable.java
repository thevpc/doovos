/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.core.site;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.doovos.kernel.api.site.KSiteEntry;

/**
 *
 * @author vpc
 */
public class KSiteTable implements Iterable<KSiteEntry>{

    Map<String, KSiteEntry> byName = new HashMap<String, KSiteEntry>();
    Map<String, KSiteEntry> byUUID = new HashMap<String, KSiteEntry>();

    public KSiteTable() {
    }

    public synchronized boolean isRegisteredUUID(String uuid) {
        return byUUID.containsKey(uuid);
    }

    public synchronized KSiteEntry unregister(String uuid) {
        KSiteEntry e=null;
        if((e=byUUID.remove(uuid))!=null){
            byName.remove(e.getName());
            return e;
        }
        return null;
    }
    
    public synchronized boolean register(KSiteEntry e) {
        if (!byUUID.containsKey(e.getUUID())) {
            if (byName.containsKey(e.getName())) {
                throw new IllegalArgumentException("Already registered name " + e.getName());
            }
            byName.put(e.getName(), e);
            byUUID.put(e.getUUID(), e);
            return true;
        }
        return false;
    }

    public Iterator<KSiteEntry> iterator() {
        return byUUID.values().iterator();
    }

    public int size(){
        return byUUID.size();
    }

    public KSiteEntry[] toArray(){
        return byUUID.values().toArray(new KSiteEntry[byUUID.size()]);
    }

}
