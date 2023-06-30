import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class suspectPage extends JFrame implements ActionListener{

    private JPanel panel2; //Main panel (Suspect Page)
    private JPanel panel3; //Εμφάνιση στοιχείων suspect από την κλάση findSuspect
    private JPanel panel4; //Εμφάνιση μηνυμάτων μεταξύ του υπόπτου και ενός αριθμού δικιά μας επιλογής
    private JPanel panel5; //Εμφάνιση Πιθανών συνεργάτων του υπόπτου
    private JPanel panel6; //Εμφάνιση Προτεινόμενων συνεργάτων του υπόπτου

    private JTextField text2; //Εισαγωγή τηλεφωνικού αριθμού

    private JTextArea area1; //Περιοχή για εμφάνιση ονόματος του υπόπτου από την κλάση findSuspect
    private JTextArea area2; //Περιοχή για εμφάνιση codeName του υπόπτου από την κλάση findSuspect
    private JTextArea area3; //Περιοχή για εμφάνιση λίστας τηλεφωνικών αριθμών του υπόπτου από την κλάση findSuspect
    private JTextArea area4; //Περιοχή για εμφάνιση λίστας μηνυμάτων μεταξύ του υπόπτου και ενός αριθμόυ που πληκτρολογούμε εμείς
    private JTextArea area5; //Περιοχή για εμφάνιση πιθανών συνεργατών του υπόπτου
    private JTextArea area6; //Περιοχή για εμφάνιση Προτεινόμενων συνεργάτων του υπόπτου

    private JLabel label1; //Προτρεπτικό μήνυμα "Partners"
    private JLabel label2; //Προτρεπτικό μήνυμα "Suggested Partners"

    private JButton button2; //Κουμπί Find SMS
    private JButton button3; //Κουμπί Back to Search Screen

    private Registry registry;
    private Suspect sus;

    public suspectPage(Suspect sus, Registry registry) {

        this.sus = sus;
        this.registry = registry;

        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        panel6 = new JPanel();

        area1 = new JTextArea();
        area2 = new JTextArea();
        area3 = new JTextArea();
        area4 = new JTextArea(8,15);
        area5 = new JTextArea(11, 22);
        area6 = new JTextArea(5,20);

        text2 = new JTextField(11);

        label1 = new JLabel("Partners");
        label2 = new JLabel("Suggested Partners ----->");

        button2 = new JButton("Find SMS");
        button3 = new JButton("Back to Search Screen");

        //-----------------------------First panel--------------------------------//
        area1 = new JTextArea(this.sus.getName() + "       ");
        area1.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        area1.setEditable(false);

        area2 = new JTextArea(this.sus.getCodeName() + "       ");
        area2.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        area2.setEditable(false);

        area3.setEditable(false);
        for(int i = 0; i < this.sus.phoneNumbers.size(); i++){
            area3.append(this.sus.phoneNumbers.get(i) + "\n");
        }

        panel3.add(area1);
        panel3.add(area2);
        panel3.add(area3);
        panel3.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        //---------------------------------------------------------------------------//

        //-----------------------------Second panel--------------------------------//
        text2.setEditable(true);

        area4.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        area4.setEditable(false);

        button2.addActionListener(this);

        panel4.add(text2);
        panel4.add(area4);
        panel4.add(button2);
        panel4.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        //---------------------------------------------------------------------------//

        //-----------------------------Third panel--------------------------------//
        label1.setVisible(true);

        ArrayList<Suspect> tempList = new ArrayList<>();
        tempList = sus.possiblePartners;
        Collections.sort(tempList);

        area5.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        area5.setEditable(false);
        for(int i = 0; i < tempList.size(); i++) {
            area5.append(tempList.get(i).getName() + ", " + tempList.get(i).getCodeName() + "\n");
        }

        panel5.add(label1);
        panel5.add(area5);
        panel5.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        //---------------------------------------------------------------------------//

        //-----------------------------Fourth panel--------------------------------//
        label2.setVisible(true);

        area6.setVisible(true);
        area6.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        area6.setEditable(false);
        for(int i = 0;i < sus.suggestedPartners.size(); i++) {
            area6.append(sus.suggestedPartners.get(i).getName() + ", " + sus.suggestedPartners.get(i).getCodeName());
        }

        Collections.sort(sus.suggestedPartners);

        panel6.add(label2);
        panel6.add(area6);
        panel6.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        //---------------------------------------------------------------------------//

        this.setContentPane(panel2);
        this.setVisible(true);
        this.setSize(500,620);
        this.setTitle("Suspect Page");
        this.add(panel3);
        this.add(panel4);
        this.add(panel5);
        this.add(panel6);
        this.add(button3);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button3.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == button2) {

            String phone = text2.getText();
            ArrayList<SMS> message1 = new ArrayList<>();

            area4.setText("");

            for(SMS message : this.registry.sms) {

                for(int i = 0 ; i< this.registry.getMessagesBetween(message.getNumber1(), phone).size(); i++) {
                    if(!message1.contains(this.registry.getMessagesBetween(message.getNumber1(), phone).get(i)) &&
                            this.sus.phoneNumbers.contains(message.getNumber1())) {
                        message1.add(this.registry.getMessagesBetween(message.getNumber1(), phone).get(i));
                    }
                }

                for(int i = 0 ; i< this.registry.getMessagesBetween(phone, message.getNumber2()).size(); i++) {
                    if(!message1.contains(this.registry.getMessagesBetween(phone, message.getNumber2()).get(i)) &&
                            this.sus.phoneNumbers.contains(message.getNumber2())) {
                        message1.add(this.registry.getMessagesBetween(phone, message.getNumber2()).get(i));
                    }
                }
            }

            for(int i = 0; i < message1.size(); i++) {
                area4.append(message1.get(i).getContent() + "\n");
            }
        }

        if(e.getSource() == button3) {
            findSuspect find = new findSuspect(registry);
            this.setVisible(false);
        }
    }
}
