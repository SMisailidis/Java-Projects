import java.util.ArrayList;

public class Suspect {

    //-----------------------------------Variables/objects-----------------------------------//
    private String name;
    private String codeName;
    private String City;

    ArrayList<String> phoneNumbers = new ArrayList<>();
    ArrayList<Suspect> possiblePartners = new ArrayList<>();
    ArrayList<Suspect> SuggestedPartners = new ArrayList<>();
    //---------------------------------------------------------------------------//

    //-----------------------------------Constructor-----------------------------------//
    public Suspect(String name, String codeName, String City) {
        this.name = name;
        this.codeName = codeName;
        this.City = City;
    }
    //---------------------------------------------------------------------------//

    //-----------------------------------Getters/Setters-----------------------------------//
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }
    //---------------------------------------------------------------------------//

    //-----------------------------------Methods-----------------------------------//
    public void addNumber(String number) {
        phoneNumbers.add(number);
    }

    public void addPartner(Suspect pp) {
        if(!possiblePartners.contains(pp))
            possiblePartners.add(pp);
    }

    public boolean isConnectedTo(Suspect aSuspect) {
        return possiblePartners.contains(aSuspect);
    }

    public ArrayList<Suspect> getCommonPartners(Suspect aSuspect){

        ArrayList<Suspect> commonPartners = new ArrayList<>();

        for(Suspect i : possiblePartners) {
            if(aSuspect.possiblePartners.contains(i))
                commonPartners.add(i);
        }
        return commonPartners;
    }

    public void printPartners() {
        for(Suspect i : possiblePartners) {
            System.out.println(i.name + ", " + i.codeName);
        }
    }

    public void SuggestedSuspects() {

        for(int i = 0 ; i <= possiblePartners.size(); i++) {
            for(int j = 0; j <= possiblePartners.get(i).possiblePartners.size(); j++) {
                if(!possiblePartners.contains(possiblePartners.get(i).possiblePartners.get(j))
                        && !(this.name == possiblePartners.get(i).possiblePartners.get(j).name)) {
                    SuggestedPartners.add(possiblePartners.get(i).possiblePartners.get(j));
                }
            }
        }
    }
    //---------------------------------------------------------------------------//
}
