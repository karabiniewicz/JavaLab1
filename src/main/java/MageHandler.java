public class MageHandler {
    private Mage mage;
    static int deep = 1;
    public MageHandler(Mage mage) {
        this.mage = mage;
    }

    public String write(){
        return "-".repeat(Math.max(0, deep)) +
                "Mage{name='" + mage.getName() + "', " +
                "level=" + mage.getLevel() + ", " +
                "power=" + mage.getPower() + "}\n";
    }
}
