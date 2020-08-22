package test.syntax;

import org.doovos.api.DProcess;

/**
 * test inheritance
 * User: vpc
 * Date: 26 janv. 2009
 * Time: 21:37:16
 * To change this template use File | Settings | File Templates.
 */
public class t008 {
    public static void main(String[] args) {
        java.util.Hashtable h=new java.util.Hashtable();
        h.put("3","trois");
        h.put("4","quatre");
        String four=(String) h.get("4");
        System.out.println(four);
        DProcess p = DProcess.getProcess();
//        System.out.println(p.freeMemorySize()+"/"+p.maxMemorySize());
//        DProcess.getProcess().gc();
//        System.out.println(p.freeMemorySize()+"/"+p.maxMemorySize());
    }
}