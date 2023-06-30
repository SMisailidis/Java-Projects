public class SMS extends Communication{

    //-----------------------------------Variables/objects-----------------------------------//
    private String content;
    //---------------------------------------------------------------------------//

    //-----------------------------------Getters/Setters-----------------------------------//
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    //---------------------------------------------------------------------------//

    //-----------------------------------Constructor-----------------------------------//
    public SMS(String number1, String number2, int day, int month, int year, String content) {

        super(number1, number2, day, month, year);
        this.content = content;
    }
    //---------------------------------------------------------------------------//

    //-----------------------------------Abstract Method-----------------------------------//
    public void printInfo() {

        System.out.println("This SMS has the following info");
        System.out.println("Between " + getNumber1() + " --- " + getNumber2());
        System.out.println("on " + getYear() + "/" + getMonth() + "/" + getDay());
        System.out.println("Text: " + content);
    }
    //---------------------------------------------------------------------------//
}
