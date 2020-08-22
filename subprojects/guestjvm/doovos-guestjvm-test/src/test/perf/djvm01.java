package test.perf;

import java.io.PrintStream;

public class djvm01 {
    static PrintStream out = System.out;
    public static void main(String[] args) {
        int max=1;
        int loop=200;
        if(args.length>0){
          max= Integer.parseInt(args[0]);
            if(args.length>1){
              out.print("arg1=");
              out.print(args[1]);
              loop=Integer.parseInt(args[1]);
              out.print("==>");
              out.println(loop);
            }
        }
        if(max<=0){
            max=1;
        }
        if(loop<=0){
            loop=200;
        }
        out.print("max=");
        out.println(max);
        out.print("loop=");
        out.println(loop);
        out.println("-----------");
        long all=0;
        long one=0;
        long minVal=-1;
        long maxVal=-1;
        for (int i = 0; i < max; i++) {
            long time0 = System.currentTimeMillis();
            doIt(loop);
            long time1 = System.currentTimeMillis();
            one=time1 - time0;
            if(one<minVal || minVal<0){
                minVal=one;
            }
            if(one>maxVal || maxVal<0){
                maxVal=one;
            }
            out.println(one);
            all+=one;
        }
        out.println("================");
        out.print("average = ");
        out.println(all/max);
        out.print("min = ");
        out.println(minVal);
        out.print("max = ");
        out.println(maxVal);
    }

    public static void doIt(int loop){
        int t1, t2;
        int[] all = new int[100];
        //for (t1 = 0; t1 < 50; t1++) {
//        for (t2 = 0; t2 < 20000; t2++) {
        int x=0;
        int y=0;
        for (t1 = 0; t1 < 1; t1++) {
            for (t2 = 0; t2 < loop; t2++) {
                y = (t1 * t2) % 100;
                y = (t1 * t2) % 100;
                y = (t1 * t2) % 100;
                y = (t1 * t2) % 100;
                y = (t1 * t2) % 100;
                y = (t1 * t2) % 100;
                y = (t1 * t2) % 100;
                y = (t1 * t2) % 100;
                y = (t1 * t2) % 100;
                y = (t1 * t2) % 100;
                y = (t1 * t2) % 100;
                y = (t1 * t2) % 100;
                y = (t1 * t2) % 100;
                y = (t1 * t2) % 100;
                y = (t1 * t2) % 100;
                y = (t1 * t2) % 100;
                y = (t1 * t2) % 100;
                all[y] = (t1 * t2);
                x++;
                x++;
                x++;
                x++;
                x++;
                x++;
                x++;
                x++;
                x++;
                x++;
                x++;
                x++;
                x++;
            }
        }
        //out.print(">> value =");
    }
}