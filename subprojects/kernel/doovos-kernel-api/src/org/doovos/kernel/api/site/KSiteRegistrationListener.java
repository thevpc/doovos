/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.doovos.kernel.api.site;

/**
 *
 * @author vpc
 */
public interface KSiteRegistrationListener {
    public void siteRegistered(KSiteEntry siteEntry);
    public void siteUnregistered(KSiteEntry siteEntry);
}
