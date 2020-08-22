package test.jni;

public class TestJNI {
    static{
        System.loadLibrary("test.jni.TestJNI");
    }
    public static void main(String[] args) {
        TestJNI s=new TestJNI();
        String str=s.doSomeThing("hello");
    }

    public native String doSomeThing(String string) ;
}