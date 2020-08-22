/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.perf;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author vpc
 */
public class perf5 {

    public static void main(String[] args) {
        for (Method method : perf5.class.getMethods()) {
            System.out.println(method.toString());
        }
        perf5 p = new perf5();
        int x=10000;
        int tasks=10;
        for (int i = 0; i < 10; i++) {
            int size = x* (i+1);
            double[][] d = p.data(size,tasks);
            double d1 = p.run(d, 1);
            double d2 = p.run(d, 2);
            double d8 = p.run(d, 8);
            System.out.println(size+" ==> "+ d1 + " , " + d2 + " , " + d8);
        }
        System.exit(0);
    }

    public double[][] data(final int count,int lignes) {
        final double[][] b = new double[lignes][count];
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < count; j++) {
                b[i][j] = Math.random();
            }
        }
        return b;
    }

    public long run(final double[][] data, int processors) {
        long s = System.currentTimeMillis();
        if (processors == 1) {
            double max = 0;
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    if (data[i][j] > max) {
                        max = data[i][j];
                    }
                }
            }
        } else {
            ExecutorService pool = Executors.newFixedThreadPool(processors);
            ArrayList<Future<Double>> all = new ArrayList<Future<Double>>();
            for (int i = 0; i < data.length; i++) {
                final double[] bb = data[i];
                Future<Double> f = pool.submit(new Callable<Double>() {

                    public Double call() throws Exception {
                        double max = 0;
                        for (int j = 0; j < bb.length; j++) {
                            if (bb[j] > max) {
                                max = bb[j];
                            }
                        }
                        return max;
                    }
                });
                all.add(f);
            }

            double max = 0;
            for (Future<Double> future : all) {
                double f = 0;
                try {
                    f = future.get();
                } catch (Exception ex) {
                    //
                }
                if (f > max) {
                    max = f;
                }
            }
        }
        long e = System.currentTimeMillis();
        return e-s;
    }
}
