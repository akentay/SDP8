package vehiclerental;


public class MaintenanceVisitor implements Visitor<String> {
    @Override
    public String visit(Car car) {
        return "Maintenance checklist for Car: oil check, tire pressure, brakes inspection.";
    }

    @Override
    public String visit(Bike bike) {
        return "Maintenance checklist for Bike: chain lubrication, brake pads check, battery (if electric).";
    }

    @Override
    public String visit(Van van) {
        return "Maintenance checklist for Van: engine oil, tire wear, cargo door check, load straps.";
    }
}
