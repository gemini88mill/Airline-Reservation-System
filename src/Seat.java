/**
 * Created by raphael on 1/26/15.
 */
public class Seat{

    private String seatType; //first class, business or economy
    private int seatRow; //numbers
    private char seatLetter; // a,b,c
    private Airplane airplane; //
    private Airline airline;

    public Seat(String seatType, int seatRow, char seatLetter, Airplane airplane, Airline airline) {
        this.seatType = seatType;
        this.seatRow = seatRow;
        this.seatLetter = seatLetter;
        this.airplane = airplane;
        this.airline = airline;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public int getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(int seatRow) {
        this.seatRow = seatRow;
    }

    public char getSeatLetter() {
        return seatLetter;
    }

    public void setSeatLetter(char seatLetter) {
        this.seatLetter = seatLetter;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }
}
