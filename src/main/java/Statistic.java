public class Statistic {
    private final String name;
    private double value;

    public Statistic(String name, double initialValue) {
        this.name = name;
        this.value = initialValue;
    }

    public void updateValue(double value) {
        this.value += value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }
}
