public class SecondOuterClass extends FirstOuterClass{
    class SecondInnerClass extends FirstInnerClass{
        public SecondInnerClass(String string){
            super(string);
            System.out.println("Second outer class");
        }
    }
    public static void main(String[] args) {
        FirstOuterClass fo = new FirstOuterClass();
        SecondOuterClass so = new SecondOuterClass();
        SecondInnerClass si = so.new SecondInnerClass("Hi");
    }
}
