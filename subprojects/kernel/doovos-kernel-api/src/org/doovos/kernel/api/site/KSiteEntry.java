/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.api.site;

/**
 *
 * @author vpc
 */
public interface KSiteEntry {

    public boolean isAlive();

    public boolean isLocal();

    public KSite getSite();

    public String getUUID();
    
    public String getName();

    public String getUrl();
}
