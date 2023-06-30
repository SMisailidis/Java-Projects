import java.util.ArrayList;

public class Fleet {

    private String town;


    public Fleet(String town) {

        this.town = town;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void storeTaxi(ArrayList<Taxi> taxis, Taxi taxi){

        taxis.add(taxi);
    }
}

