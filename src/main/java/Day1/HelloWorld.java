package Day1;

public class HelloWorld {
    public static String msg = "hello";
    public static int maxIterations = 6;

    public static void replicateMsg(String message) {
        for (int x = 0; x< maxIterations; x++) {
            System.out.println("Print: " + message + ". Iteration: " + x);
        }
    }

    public static void main(String[] args) {
        replicateMsg(msg);
    }
}
