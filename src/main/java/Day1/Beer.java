package Day1;

public class Beer {
    protected final static int REQUIRED_AGE = 18;
    protected double strength;
    protected String brandName;

    public Beer(double strength, String brandName) {
        this.strength = strength;
        this.brandName = brandName;
    }

    public Boolean isAllowedToDrink(int age) {
        if (age >= REQUIRED_AGE) {
            System.out.println("YES, allowed to drink");
            return true;
        } else {
            System.out.println("NO, not allowed to drink");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Beer{" +
                "strength=" + strength +
                ", brandName='" + brandName + '\'' +
                '}';
    }

    public static void main(String[] args) {
//        isAllowedToDrink(17);
//        isAllowedToDrink(18);
//        isAllowedToDrink(19);
    }
}
