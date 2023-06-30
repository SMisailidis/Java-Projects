public class ElectricalTaxi extends Taxi{

    private int capacity;

    public ElectricalTaxi(String town, String number, String name, int capacity) {

        super(town, number, name);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double calcAutonomy() {
        double autonomy;

        return autonomy = 70 * this.capacity;
    }
}

