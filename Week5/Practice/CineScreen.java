// CineScreen.java
public class CineScreen {
    private int seatsTotal;
    private int seatsAvailable;

    public CineScreen(int seatsTotal) {
        if (seatsTotal <= 0) throw new IllegalArgumentException("Seats must be > 0");
        this.seatsTotal = seatsTotal;
        this.seatsAvailable = seatsTotal;
    }

    public boolean bookSeat() {
        if (seatsAvailable > 0) { seatsAvailable--; return true; }
        return false;
    }

    public boolean cancelBooking() {
        if (seatsAvailable < seatsTotal) { seatsAvailable++; return true; }
        return false;
    }

    public int getSeatsAvailable() { return seatsAvailable; }

    public static void main(String[] args) {
        CineScreen screen = new CineScreen(100);
        screen.bookSeat();
        System.out.println("Available: " + screen.getSeatsAvailable());
    }
}
