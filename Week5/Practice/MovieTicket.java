// MovieTicket.java
public class MovieTicket {
    public String movieName;
    String genre;
    private double ticketPrice;
    protected int seatNumber;

    public MovieTicket(String movieName, String genre, double ticketPrice, int seatNumber) {
        this.movieName = movieName;
        this.genre = genre;
        this.ticketPrice = ticketPrice;
        this.seatNumber = seatNumber;
    }
}
