import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JFrame implements ActionListener {


	private static final long serialVersionUID = 1L;

	private ArrayList<String> queryResults = new ArrayList<>();

    private JPanel panel3;

    private JFrame frame2;

    private JLabel label2;
    private JLabel label5;
    private JLabel label4;

    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;

    private Color ForegroundLabel;
    private Color ForegroundButton;
    private Color BackgroundButton;

    private String card;

    private Bank bank;

    public GUI(String card) {

        this.card = card;
        
        this.bank = new Bank(this.card);

        if(this.queryResults.isEmpty()){
            RetrieveCardData();
        }

        ForegroundLabel = new Color(43, 249, 194);
        ForegroundButton = new Color(43, 249, 194);
        BackgroundButton = new Color(77, 80, 79);

        frame2 = new JFrame();

        panel3 = new JPanel();

        label2 = new JLabel("Press \"Continue\"");
        label4 = new JLabel("------------------------(Card functions)------------------------");
        label5 = new JLabel("Welcome Back " + this.queryResults.get(1));
        
        button5 = new JButton("Deposit");
        button5.setBorder(BorderFactory.createLineBorder(ForegroundButton));

        button6 = new JButton("Withdrawal");
        button6.setBorder(BorderFactory.createLineBorder(ForegroundButton));

        button7= new JButton("Balance");
        button7.setBorder(BorderFactory.createLineBorder(ForegroundButton));

        button8= new JButton("Contant Bank");
        button8.setBorder(BorderFactory.createLineBorder(ForegroundButton));

        frame2.setSize(300,200);
        frame2.add(panel3);
        frame2.setResizable(false);
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);

        panel3.setSize(300,200);
        panel3.setLayout(null);
        panel3.setBackground(new Color(77, 80, 79));
        
        label5.setBounds(75,15,260,20);
        label5.setForeground(ForegroundLabel);
        
        label2.setBounds(95,10,300,100);
        label2.setForeground(ForegroundLabel);
        
        label4.setForeground(ForegroundLabel);
        label4.setBounds(0,30,300,50);

        button5.setForeground(ForegroundButton);
        button5.setBackground(BackgroundButton);
        button5.setBounds(1,80,100,30);
        button5.addActionListener(this);

        button6.setForeground(ForegroundButton);
        button6.setBackground(BackgroundButton);
        button6.setBounds(183,80,100,30);
        button6.addActionListener(this);

        button7.setForeground(ForegroundButton);
        button7.setBackground(BackgroundButton);
        button7.setBounds(1,130,100,30);
        button7.addActionListener(this);

        button8.setForeground(ForegroundButton);
        button8.setBackground(BackgroundButton);
        button8.setBounds(183,130,100,30);
        button8.addActionListener(this);

        
        panel3.add(label5);
        panel3.add(label4);
        panel3.add(button5);
        panel3.add(button6);
        panel3.add(button7);
        panel3.add(button8);

    }

    public void RetrieveCardData() {

        SQLiteConnection sqlConn = new SQLiteConnection();

        String query = "SELECT * FROM CARDS WHERE CARDS.card_number =" + "'" + this.card + "'";
        
        sqlConn.makeDMLQuery(query);

        this.queryResults.addAll(sqlConn.getQueryResults());
    }

    public void actionPerformed(ActionEvent e) {

    	
    	if (e.getSource().equals(button5)) {

            String deposit;

            deposit = JOptionPane.showInputDialog(null, "How much do you want to deposit?");

            if(bank.getBalance() < Integer.parseInt(deposit)) {

                JOptionPane.showMessageDialog(null, "Your balance was " + bank.getBalance() + ", we cant make the deposit.");

            }
            else {

                bank.Deposit(Integer.parseInt(deposit));

                JOptionPane.showMessageDialog(null, "Your balance after the deposit is: " + bank.getBalance() + " and your bank balance: " + bank.getBankBalance() + ".");
            }
        }
        else if (e.getSource().equals(button6)) {

            String withdrawal;

            withdrawal = JOptionPane.showInputDialog(null, "How much do you want to withdraw?");


            if(bank.getBankBalance() > Integer.parseInt(withdrawal)) {

                bank.Withdrawal(Integer.parseInt(withdrawal));

                JOptionPane.showMessageDialog(null, "Your balance after the withdraw is: " + bank.getBalance() + ".");
            }
            else {

                JOptionPane.showMessageDialog(null, "Bank doesn't have enough money to make the withdrawal.");
            }
        }
        else if (e.getSource().equals(button7)){
            JOptionPane.showMessageDialog(null, "Your balance is: " + bank.getBalance() + ".");
        }
        else if (e.getSource().equals(button8)){
            JOptionPane.showMessageDialog(null, "Website is currently offline.");
        }
    }
}
