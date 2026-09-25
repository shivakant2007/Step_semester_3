// DeliveryDrone.java
public class DeliveryDrone extends Drone implements Trackable {
    @Override
    public String fly() { return "DR-1 flying"; }
    @Override
    public String getLocation() { return "DR-1 at Sector 4"; }
}
