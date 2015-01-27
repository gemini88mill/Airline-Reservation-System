/**
 * Created by raphael on 1/26/15.
 */
public class Airplane {

    private String planeType;
    private String numberOfSeats;
    private boolean mealservice;
    private Airline airline;

    public Airplane(Airline airline, String planeType, String numberOfSeats, boolean mealservice) {
        this.airline = airline;
        this.planeType = planeType;
        this.numberOfSeats = numberOfSeats;
        this.mealservice = mealservice;
    }

    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    public String getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(String numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public boolean isMealservice() {
        return mealservice;
    }

    public void setMealservice(boolean mealservice) {
        this.mealservice = mealservice;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }
}
