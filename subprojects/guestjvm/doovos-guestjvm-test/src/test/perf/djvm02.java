package test.perf;


/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 22 févr. 2009
 * Time: 12:29:08
 * To change this template use File | Settings | File Templates.
 */
public class djvm02 {
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
        System.out.print("max=");
        System.out.println(max);
        System.out.print("loop=");
        System.out.println(loop);
        System.out.print("-----------");
        for (int i = 0; i < max; i++) {
            long time0 = System.currentTimeMillis();
            doIt(loop);
            long time1 = System.currentTimeMillis();
            System.out.println(time1 - time0);
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
                System.out.println(staticValue);
            }
        }
        long time1 = System.currentTimeMillis();
        System.out.print(" ==> ");
        System.out.println(time1 - time0);
    }
}