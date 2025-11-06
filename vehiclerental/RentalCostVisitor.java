package vehiclerental;

public class RentalCostVisitor implements Visitor<Double> {
    private final int duration; 
    private final String pricingType; 

    public RentalCostVisitor(int duration, String pricingType) {
        this.duration = duration;
        this.pricingType = pricingType.toLowerCase();
    }

    @Override
    public Double visit(Car car) {
        double baseHourly = 500.0; 
        double baseDaily = 3500.0;
        if ("daily".equals(pricingType)) {
            return baseDaily * duration;
        } else {
            return baseHourly * duration;
        }
    }

    @Override
    public Double visit(Bike bike) {
        double baseHourly = bike.isElectric() ? 300.0 : 150.0;
        double baseDaily = bike.isElectric() ? 1800.0 : 900.0;
        if ("daily".equals(pricingType)) return baseDaily * duration;
        else return baseHourly * duration;
    }

    @Override
    public Double visit(Van van) {
        double baseHourly = 800.0;
        double baseDaily = 5000.0;
       
        double surchargeFactor = 1.0 + Math.max(0, (van.getCapacityCubicMeters() - 5.0)) * 0.05;
        if ("daily".equals(pricingType)) return baseDaily * duration * surchargeFactor;
        else return baseHourly * duration * surchargeFactor;
    }
}
