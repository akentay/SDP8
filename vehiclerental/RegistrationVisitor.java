package vehiclerental;

import java.util.UUID;

public class RegistrationVisitor implements Visitor<String> {
    private final String renterName;

    public RegistrationVisitor(String renterName) {
        this.renterName = renterName;
    }

    @Override
    public String visit(Car car) {
        String contract = "CTR-" + UUID.randomUUID().toString().substring(0,8);
        return "Contract " + contract + " | Renter: " + renterName + " | Vehicle: " + car.getMakeModel() + " (Car)";
    }

    @Override
    public String visit(Bike bike) {
        String contract = "CTR-" + UUID.randomUUID().toString().substring(0,8);
        return "Contract " + contract + " | Renter: " + renterName + " | Vehicle: " + bike.getMakeModel() + " (Bike)";
    }

    @Override
    public String visit(Van van) {
        String contract = "CTR-" + UUID.randomUUID().toString().substring(0,8);
        return "Contract " + contract + " | Renter: " + renterName + " | Vehicle: " + van.getMakeModel() + " (Van)";
    }
}
