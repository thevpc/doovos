package org.doovos.kernel.vanilla.jvm.interpreter.jjit.debug;

public class JJITLog {
    private String title;
    private boolean empty = true;
    private String prefix;
    private String prefix2;

    public JJITLog(String title) {
        this(title,"");
    }
    public JJITLog(String title, String prefix) {
        this.title = title;
        this.prefix = prefix;
        this.prefix2 = prefix + "  ";
    }

    public void start() {

    }

    public void trace(String line) {
        if (empty) {
            log(prefix + "**** START " + title);
        }
        empty = false;
        log(prefix2 + line);
    }

    public void end() {
        if (!empty) {
            log(prefix + "**** END " + title);
        }
    }
    
    public static void log(String message){
        Throwable t = new Throwable();
        int len = t.getStackTrace().length;
        for (int i = 0; i < len; i++) {
            System.out.print(" ");
        }
        System.out.println(">>> "+message);
    } 
}
