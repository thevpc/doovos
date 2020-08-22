/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.doovos.kernel.core.site.protocol;

/**
 *
 * @author vpc
 */
public abstract class SiteProtocolMessage {
    public abstract String getPrefix();

    public String toMessage(){
        return getPrefix()+":"+getInfo();
    }

    public abstract boolean isAnonymous();
    public abstract String getInfo();
    public abstract String getSourceName();
    public abstract String getSourceUUID();
    
    public abstract SiteProtocolMessage parse(String info);
}
