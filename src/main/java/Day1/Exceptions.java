package Day1;

public class Exceptions {
    public static void main(String[] args) {
        method2();
    }

    public static void method2() {
        method1();
    }

    public static void method1() {
        int x = 10;
        int y = 0;

        try {
            double z = x / y;
            System.out.println(z);
        } catch (ArithmeticException e) { // only when exception occurs
            System.out.println("catch");
            System.out.println(e.getMessage());  // log it -> reuse later
            e.printStackTrace();  // log it -> reuse later
            //throw new ArithmeticException("Division aberration!"); // finally will NOT be executed!
        } finally { // will ALWAYS execute
            System.out.println("finally");
        }

        System.out.println("the end");
    }
}
