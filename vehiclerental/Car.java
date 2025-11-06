package vehiclerental;

public class Car implements Vehicle {
    private final String id;
    private final String makeModel;
    private boolean rented;
    private final int seats;

    public Car(String id, String makeModel, int seats) {
        this.id = id;
        this.makeModel = makeModel;
        this.seats = seats;
        this.rented = false;
    }

    public int getSeats() { return seats; }

    @Override
    public String getId() { return id; }

    @Override
    public String getMakeModel() { return makeModel; }

    @Override
    public boolean isRented() { return rented; }

    @Override
    public void setRented(boolean rented) { this.rented = rented; }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Car{id='" + id + "', " + makeModel + ", seats=" + seats + ", rented=" + rented + "}";
    }
}
