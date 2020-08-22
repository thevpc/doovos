package org.doovos.api.io;

import org.doovos.api.DSystem;

import java.io.File;
import java.net.URI;

/**
 * Distributed resource wrapper
 * This class extends File to add specific Doovos Resource functions
 * @author Taha Ben Salah
 */
public class DFile extends File {

    //first load Native library
    static {
        DSystem.loadLibrary("org.doovos.api.io.DFileJNI");
    }

    /**
     * creates a DFile object
     * @param file reference file
     */
    public DFile(File file) {
        super(file.getPath());
    }

    /**
     * {@inheritDoc}
     */
    public DFile(String pathname) {
        super(pathname);
    }

    /**
     * {@inheritDoc}
     */
    public DFile(String parent, String child) {
        super(parent, child);
    }

    /**
     * {@inheritDoc}
     */
    public DFile(File parent, String child) {
        super(parent, child);
    }

    /**
     * {@inheritDoc}
     */
    public DFile(URI uri) {
        super(uri);
    }

    private native DResourceType getResourceType0();
    private DResourceType resourceType;

    /**
     * resource type
     * @return resource type or null if non existing File
     */
    public DResourceType getResourceType(){
        if(resourceType==null){
            resourceType=getResourceType0();
        }
        return resourceType;
    }

    private native String getCreationSite0();
    private String creationSite;

    /**
     * site id on which resource was created
     * @return site id on which resource was created or null if non existing File
     */
    public String getCreationSite(){
        if(creationSite==null){
            creationSite=getCreationSite0();
        }
        return creationSite;
    }

    private native String getSite0();
    private String site;

    /**
     * site id on which resource is
     * @return site id on which resource is or null if non existing File
     */
    public String getSite(){
        if(site==null){
            site=getSite0();
        }
        return site;
    }

}
