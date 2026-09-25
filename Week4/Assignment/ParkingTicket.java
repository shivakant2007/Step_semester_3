// ParkingTicket.java
public class ParkingTicket {
    String vehicleNo;
    double ratePerMinute;

    public ParkingTicket(String vehicleNo, double ratePerMinute) {
        this.vehicleNo = vehicleNo;
        this.ratePerMinute = ratePerMinute;
    }

    public final double calculateFine(int overstayMinutes) {
        if (overstayMinutes <= 0) return 0;
        return ratePerMinute * overstayMinutes;
    }

    public final void printReceipt(int overstayMinutes) {
        if (overstayMinutes > 0) {
            System.out.println(vehicleNo + " - Fine: Rs " + calculateFine(overstayMinutes));
        } else {
            System.out.println(vehicleNo + " - No fine, within allotted time");
        }
    }

    public static void main(String[] args) {
        String[] vehicles = {"TN09AB1234", "TN22CD5678", "TN09EF9012", "TN10GH3456"};
        double[] rates = {3.0, 0, 0, 3.2};
        int[] overstay = {10, 0, 0, 5};
        for (int i = 0; i < vehicles.length; i++) {
            ParkingTicket t = new ParkingTicket(vehicles[i], rates[i]);
            t.printReceipt(overstay[i]);
        }
    }
}
