import java.util.ArrayList;

public class Registry {

    //-----------------------------------Variables/objects-----------------------------------//
    ArrayList<PhoneCall> phoneCalls = new ArrayList<>();
    ArrayList<SMS> sms = new ArrayList<>();
    ArrayList<Suspect> suspects = new ArrayList<>();
    //---------------------------------------------------------------------------//

    //-----------------------------------Methods-----------------------------------//
    public void addSuspect(Suspect aSuspect) {
        suspects.add(aSuspect);
    }

    public void addCommunication(Communication aCommunication) {
        int firstSuspect = -1;
        int secondSuspect = -1;

        for(int i = 0; i < suspects.size(); i++) {
            if(suspects.get(i).phoneNumbers.contains(aCommunication.getNumber1()))
                firstSuspect = i;

            if(suspects.get(i).phoneNumbers.contains(aCommunication.getNumber2()))
                secondSuspect = i;
        }


        if(aCommunication instanceof PhoneCall) //Επειδή η κλάση communication έχει 2 υποκλάσεις, την PhoneCall και την SMS, μέσω της instanceof ελέγχω σε ποιο τύπο υποκλάσης ανήκει
            phoneCalls.add((PhoneCall) aCommunication); //Εισάγει στην αντίστοιχη ArrayList μέσω του typeCasting
        else
            sms.add((SMS) aCommunication);


        suspects.get(firstSuspect).addPartner(suspects.get(secondSuspect));
        suspects.get(secondSuspect).addPartner(suspects.get(firstSuspect));

    }

    public Suspect getSuspectWithMostPartners() {

        int max = -1;
        int indexMax = 0;

        for(int i = 1; i < suspects.size(); i++) {
            if(max < suspects.get(i).possiblePartners.size())
            {
                max = suspects.get(i).possiblePartners.size();
                indexMax = i;
            }

        }
        return suspects.get(indexMax);
    }


    public PhoneCall getLongestPhoneCallBetween(String number1, String number2) {

        int max = -1;
        int index =  -1;

        for(int i = 0; i < phoneCalls.size(); i++) {
            if(phoneCalls.get(i).getNumber1().equals(number1) && phoneCalls.get(i).getNumber2().equals(number2)) {
                if(max < phoneCalls.get(i).getLasted()) {
                    max = phoneCalls.get(i).getLasted();
                    index = i;
                }
            }
        }

        return phoneCalls.get(index);
    }

    public ArrayList<SMS> getMessagesBetween(String number1, String number2) {

        ArrayList<SMS> contents = new ArrayList<>();

        for(int i = 0; i < sms.size(); i++) {
            if(sms.get(i).getNumber1().equals(number1) && sms.get(i).getNumber2().equals(number2)) {
                if(sms.get(i).getContent().contains("Bomb") ||
                        sms.get(i).getContent().contains("Attack") ||
                        sms.get(i).getContent().contains("Explosives") ||
                        sms.get(i).getContent().contains("Gun")) {
                    contents.add(sms.get(i));
                }
            }
        }

        return contents;
    }
    //---------------------------------------------------------------------------//
}
