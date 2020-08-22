package test.perf;

import java.io.PrintStream;

public class perf0 {
    static PrintStream out = System.out;
    static int staticValue;

    public static void main(String[] args) {
        int max = 1;
        int loop = 200;
        if (args.length > 0) {
            max = Integer.parseInt(args[0]);
            if (args.length > 1) {
                loop = Integer.parseInt(args[1]);
            }
        }
        if (max <= 0) {
            max = 1;
        }
        if (loop <= 0) {
            loop = 200;
        }
        out.print("max=");
        out.println(max);
        out.print("loop=");
        out.println(loop);
        out.print("-----------");
        for (int i = 0; i < max; i++) {
            long time0 = System.currentTimeMillis();
            doIt(loop);
            long time1 = System.currentTimeMillis();
            out.println(time1 - time0);
        }
    }

    public static void doIt(int loop) {
        long time0 = System.currentTimeMillis();
        staticValue = 0;
        int t1, t2;
        int[] all = new int[100];
        //for (t1 = 0; t1 < 50; t1++) {
//        for (t2 = 0; t2 < 20000; t2++) {
        for (t1 = 0; t1 < 1; t1++) {
            for (t2 = 0; t2 < loop; t2++) {
                all[(t1 * t2) % 100] = (t1 * t2);
                staticValue++;
                out.println(staticValue);
            }
        }
        long time1 = System.currentTimeMillis();
        out.print(" ==> ");
        out.println(time1 - time0);
    }
}
