
public class PhoneCall extends Communication {

    //-----------------------------------Variables/objects-----------------------------------//
    private int lasted;
    //---------------------------------------------------------------------------//

    //-----------------------------------Getters/Setters-----------------------------------//
    public int getLasted() {
        return lasted;
    }

    public void setLasted(int lasted) {
        this.lasted = lasted;
    }
    //---------------------------------------------------------------------------//

    //-----------------------------------Constructor-----------------------------------//
    public PhoneCall(String number1, String number2, int day, int month, int year, int lasted) {

        super(number1, number2, day, month, year);
        this.lasted = lasted;
    }
    //---------------------------------------------------------------------------//

    //-----------------------------------Abstract Method-----------------------------------//
    public void printInfo() {

        System.out.println("This phone call has the following info");
        System.out.println("Between " + getNumber1() + " --- " + getNumber2());
        System.out.println("on " + getYear() + "/" + getMonth() + "/" + getDay());
        System.out.println("Duration: " + lasted);
    }
    //---------------------------------------------------------------------------//
}
