package vehiclerental;

public class Bike implements Vehicle {
    private final String id;
    private final String makeModel;
    private boolean rented;
    private final boolean electric;

    public Bike(String id, String makeModel, boolean electric) {
        this.id = id;
        this.makeModel = makeModel;
        this.electric = electric;
        this.rented = false;
    }

    public boolean isElectric() { return electric; }

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
        return "Bike{id='" + id + "', " + makeModel + (electric ? ", electric" : "") + ", rented=" + rented + "}";
    }
}
