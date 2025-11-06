package vehiclerental;

public interface Visitor<T> {
    T visit(Car car);
    T visit(Bike bike);
    T visit(Van van);
}
