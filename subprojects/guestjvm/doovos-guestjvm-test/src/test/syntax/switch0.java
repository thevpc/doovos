package test.syntax;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 8 mars 2009
 * Time: 01:43:52
 * To change this template use File | Settings | File Templates.
 */
public class switch0 {
    public static void main(String[] args) {
        int x=1;
        System.out.println(test(1));
        System.out.println(test(2));
        System.out.println(test(3));
        System.out.println(test(4));
    }
    
    public static final int test(int x){
        switch (x){
            case 0 :{
                x=1;
                break;
            }
            case 1 :{
                x=2;
                break;
            }
            case 3 :{
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
