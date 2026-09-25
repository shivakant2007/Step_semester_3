// HallTicket.java
public class HallTicket {
    String studentName;
    int seatNumber;

    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }

    public static void main(String[] args) {
        HallTicket priya = new HallTicket("Priya", 101);
        HallTicket ref = priya;
        ref.seatNumber = 202;
        System.out.println("First reference sees seat: " + priya.seatNumber);
        System.out.println("same reference: " + (ref == priya));

        HallTicket third = new HallTicket("Priya", 202);
        System.out.println("third == priya: " + (third == priya));
    }
}
