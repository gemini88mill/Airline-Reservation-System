/**
 * Created by raphael on 1/26/15.
 */
public class Airplane {

    private String planeType;
    private int numberOfSeats;
    private boolean mealService;
    private Airline airline;

    public Airplane(Airline airline, String planeType, int numberOfSeats, boolean mealService) {
        this.airline = airline;
        this.planeType = planeType;
        this.numberOfSeats = numberOfSeats;
        this.mealService = mealService;
    }

    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public boolean isMealService() {
        return mealService;
    }

    public void setMealService(boolean mealService) {
        this.mealService = mealService;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }
}
