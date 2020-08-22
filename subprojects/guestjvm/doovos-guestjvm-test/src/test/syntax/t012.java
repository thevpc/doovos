package test.syntax;

public class t012 {
    public static void main(String[] args) {
        tes02();
    }

    public static void tes02() {
        int max1 = 2;
        int max2 = 3;
        int max3 = 4;
        double[][][] max = new double[max1][max2][max3];
        for (int i = 0; i < max1; i++) {
            for (int j = 0; j < max2; j++) {
                for (int k = 0; k < max3; k++) {
                    max[i][j][k]=max[i][j][k]+1;
                }
            }
        }
        for (int i = 0; i < max1; i++) {
            for (int j = 0; j < max2; j++) {
                for (int k = 0; k < max3; k++) {
                    max[i][j][k]=max[i][j][k]+1;
                }
            }
        }
        int x=0;
        for (int i = 0; i < max1; i++) {
            for (int j = 0; j < max2; j++) {
                for (int k = 0; k < max3; k++) {
                    x+=max[i][j][k];
                }
            }
        }
        if(x!=max1*max2*max3*2){
            System.out.println("??");
        }else{
            System.out.println("ok");
        }
    }

//    public static void tes01() {
//        int[][] max=new int[15][];
//        max[0]=new int[2];
//        max[0][0]=3;
//        max[0][1]=5;
//        DProcess.getProcess().getStdout().println(max[0][0]);
//        DProcess.getProcess().getStdout().println(max[0][1]);
////        DProcess.getProcess().getStdout().println(max[1][1]);
//    }
//    public static void tes00() {
//        int[] max=new int[15];
//        max[0]=3;
//        max[1]=5;
//        DProcess.getProcess().getStdout().println(max[0]);
//        DProcess.getProcess().getStdout().println(max[1]);
////        DProcess.getProcess().getStdout().println(max[1][1]);
//    }

}