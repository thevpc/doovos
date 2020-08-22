/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.doovos.kernel.api.jvm.bytecode;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author vpc
 */
public interface JavaByteCodeLoader {
    KClassDef loadClass(InputStream inputStream) throws IOException;

}
