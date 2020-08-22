package test.perf;

public class perf1 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            long time0 = System.currentTimeMillis();
            int t1, t2;
            int[] all = new int[100];
            for (t1 = 0; t1 < 50; t1++) {
                for (t2 = 0; t2 < 20000; t2++) {
                    all[(t1 * t2) % 100] = (t1 * t2);
                    //printf("");
                }
            }
            long time1 = System.currentTimeMillis();

            System.out.println(time1 - time0);
        }
    }
}