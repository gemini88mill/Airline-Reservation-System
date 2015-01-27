/**
 * Created by raphael on 1/26/15.
 */
public class InfoGet {

    Airline Delta;
    Airplane AirbusA340;
    Seat seat;

    public static void main(String args[]){
        //main class code starts here...
        InfoGet ig = new InfoGet();
        ig.setGate();



    }

    private void setGate() {
        Delta = new Airline("Delta", "Atlanta", new String[100]);
        AirbusA340 = new Airplane(Delta, "Airbus", 340, true);
        seat = new Seat("economy", 32, 'b', AirbusA340, Delta, false);
    }


}
