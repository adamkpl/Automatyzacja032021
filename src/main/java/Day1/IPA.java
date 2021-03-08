package Day1;

public class IPA extends Beer {
    private int ibu;

    public IPA(double strength, String brandName, int ibu) {
        super(strength, brandName);
        this.ibu = ibu;
    }

    public int getIbu() {
        return ibu;
    }

    public void setIbu(int ibu) {
        this.ibu = ibu;
    }

    @Override
    public String toString() {
        return "IPA{" +
                "strength=" + strength +
                ", brandName='" + brandName + '\'' +
                ", ibu=" + ibu +
                '}';
    }
}
