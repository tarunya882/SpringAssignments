public class MainClass {
    void m1(Interface1 i1){
        i1.method1();
    }
    void m2(Interface2 i2){
        i2.method4();
    }
    void m3(Interface3 i3){
        i3.method6();
    }
    void m4(NewInterface ni){
        ni.method7();
    }
    public static void main(String[] args){
        MainClass mc=new MainClass();
        NewClass nc=new NewClass();
        mc.m1(nc);
        mc.m2(nc);
        mc.m3(nc);
        mc.m4(nc);
    }
}
