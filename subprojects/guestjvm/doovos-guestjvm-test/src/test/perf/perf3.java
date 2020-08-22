package test.perf;

import java.io.PrintStream;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 22 févr. 2009
 * Time: 12:29:08
 * To change this template use File | Settings | File Templates.
 */
public class perf3 {
    static PrintStream out = System.out;
    public static void main(String[] args) {
        long time0 = System.currentTimeMillis();
        int[] tab=new int[1000];
        for (int i = 0; i < tab.length; i++) {
            tab[i]=(int) (Math.random()*2000);
        }
//        out.println("=====================");
//        show(tab);
        sort_bubble(tab);
//        out.println("=====================");
//        show(tab);
        long time1 = System.currentTimeMillis();

        out.println(time1 - time0);
    }

    static void show(int a[]) {
        for (int i : a) {
            out.println(i);
        }
    }

    static void sort_bubble(int a[]) {
        for (int i = a.length; --i >= 0;) {
            boolean flipped = false;
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    int T = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = T;
                    flipped = true;
                }
            }
            if (!flipped) {
                return;
            }
        }
    }
}