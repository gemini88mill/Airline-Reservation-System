/**
 * Created by raphael on 1/26/15.
 */
public class Airline {

    private String airlineName;
    private String hubLocation;
    private String[] destination;

    public Airline(String airlineName, String hubLocation, String[] destination) {
        this.airlineName = airlineName;
        this.hubLocation = hubLocation;
        this.destination = destination;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getHubLocation() {
        return hubLocation;
    }

    public void setHubLocation(String hubLocation) {
        this.hubLocation = hubLocation;
    }

    public String[] getDestination() {
        return destination;
    }

    public void setDestination(String[] destination) {
        this.destination = destination;
    }
}
