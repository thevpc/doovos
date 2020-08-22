package test.syntax;

public class switch1 {
    public static void main(String[] args) {
        System.out.println(Math.random());
//        DProcess p = DProcess.getProcess();
//        for (ProcessEnv processEnv : p.getInfo().getEnvs()) {
//            p.getStdout().println(processEnv.key+"="+processEnv.value+"["+processEnv.exported+"]");
//        }
        int x=1;
//        System.out.println(test(1));
//        System.out.println(test(200));
//        System.out.println(test(3));
//        System.out.println(test(1));
//        System.out.println(test(1000));
//        System.out.println(test(200));
//        System.out.println(test(0));
    }

    public static final int test(int x){
        switch (x){
            case 0 :{
                x=1;
                break;
            }
            case 1000 :{
                x=2;
                break;
            }
            case 200 :{
                x=4;
                break;
            }
            default :{
                x=-1;
                break;
            }
        }
        return x;
    }
}