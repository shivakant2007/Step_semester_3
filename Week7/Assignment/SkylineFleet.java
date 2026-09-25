// SkylineFleet.java
public class SkylineFleet {
    public static String getLocationIfTrackable(Object o) {
        if (o instanceof Trackable) {
            return ((Trackable) o).getLocation();
        }
        return "Tracking not available";
    }

    public static void main(String[] args) {
        System.out.println("DeliveryDrone -> \"" + getLocationIfTrackable(new DeliveryDrone()) + "\"");
        System.out.println("ScoutDrone -> \"" + getLocationIfTrackable(new ScoutDrone()) + "\"");
        System.out.println("GroundRobot -> \"" + getLocationIfTrackable(new GroundRobot()) + "\"");
    }
}
