package vehiclerental;

public interface Vehicle {
    String getId();
    String getMakeModel();
    boolean isRented();
    void setRented(boolean rented);

    
    <T> T accept(Visitor<T> visitor);
}
