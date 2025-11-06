package vehiclerental;

public class Van implements Vehicle {
    private final String id;
    private final String makeModel;
    private boolean rented;
    private final double capacityCubicMeters;

    public Van(String id, String makeModel, double capacityCubicMeters) {
        this.id = id;
        this.makeModel = makeModel;
        this.capacityCubicMeters = capacityCubicMeters;
        this.rented = false;
    }

    public double getCapacityCubicMeters() { return capacityCubicMeters; }

    @Override public String getId() { return id; }
    @Override public String getMakeModel() { return makeModel; }
    @Override public boolean isRented() { return rented; }
    @Override public void setRented(boolean rented) { this.rented = rented; }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Van{id='" + id + "', " + makeModel + ", capacity=" + capacityCubicMeters + "m3, rented=" + rented + "}";
    }
}
