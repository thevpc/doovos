
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vpc
 */
public class CommentAll {

//    public static void main(String[] args) {
//        process(new File("/home/vpc/xprojects/apps/doovos/subprojects/kernel/doovos-kernel-vanilla/src/org/doovos/kernel/vanilla/jvm/interpreter/inlinelinkerinterpreter"));
//    }

    public static void process(File file) {
        if(file.isDirectory()){
            for (File file1 : file.listFiles()) {
                process(file1);
            }
        }else if(file.getName().endsWith(".java")){
            commentFile(file);
        }
    }

    public static void commentFile(File file) {
        BufferedReader r = null;
        try {
            StringBuilder s = new StringBuilder();
            r = new BufferedReader(new FileReader(file));
            String line = r.readLine();
            if (line != null) {
                if (line.startsWith("//")) {
                    return;
                }
                s.append("//" + line+"\n");
                while ((line = r.readLine()) != null) {
                    s.append("//" + line+"\n");
                }
            }
            r.close();
            r = null;
            PrintStream p=new PrintStream(file);
            p.print(s);
            p.close();
        } catch (Exception ex) {
            Logger.getLogger(CommentAll.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (r != null) {
                    r.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(CommentAll.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
