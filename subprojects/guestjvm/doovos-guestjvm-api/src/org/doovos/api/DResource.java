/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.api;

/**
 *
 * @author vpc
 */
public class DResource {

    private String path;

    public DResource(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
    

    public native String getName();

    public native int getCreationTime();
    
    public native String getCreationSiteId();

    public native String getCurrentSiteId();

    /**
     * migrate resource the current resource to new localtion (Site named siteId)
     *
     * @param siteId
     * @
     */
    public native void migrateTo(String siteId);

    /**
     * true when migration is not allowed or has no meaning
     *
     * @return
     * @
     */
    public native boolean isSticky();
    public native boolean exists();
}
