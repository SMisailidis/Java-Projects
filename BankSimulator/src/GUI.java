import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GUI extends JFrame implements ActionListener {

	private ArrayList<String> queryResults = new ArrayList<>();

    private ImageIcon icon; // Image icon

    private JFrame DepositPageBankFrame;
    private JFrame WithdrawalPageBankFrame;
    private JFrame BalancePageBankFrame;
    private JFrame ContactPageBankFrame;

    private JPanel MainPageBankPanel;
    private JPanel DepositPageBankPanel;
    private JPanel WithdrawalPageBankPanel;
    private JPanel BalancePageBankPanel;
    private JPanel ContactPageBankPanel;

    private JLabel MainPageBankWelcomeLabel;
    private JLabel MainPageBankFunctionsLabel;

    private JButton MainPageBankDepositButton;
    private JButton MainPageBankWithdrawalButton;
    private JButton MainPageBankBalanceButton;
    private JButton MainPageBankContactButton;
    private JButton DepositPageBankSubmitButton;
    private JButton DepositPageBankHomeButton;
    private JButton WithdrawalPageBankHomeButton;
    private JButton BalancePageBankHomeButton;    
    private JButton ContactPageBankHomeButton;

    private JTextField DepositPageBankTextField;
    private JTextPane DepositPageBankPrivacyTextPane;

    private Color ForegroundLabel;
    private Color ForegroundButton;
    private Color BackgroundButton;

    private Bank bank;

    private Card card;

    public GUI(String card) {

        this.card = new Card(card);
        
        this.bank = new Bank(this.card);

        //--Colors--\\
        ForegroundLabel = new Color(43, 249, 194);
        ForegroundButton = new Color(43, 249, 194);
        BackgroundButton = new Color(77, 80, 79);
        //----------\\

        //--Icons--\\
        icon = new ImageIcon("Home.png");
        //---------\\

        //--Frames--\\
        DepositPageBankFrame = new JFrame();
        DepositPageBankFrame.setTitle("Deposit frame");
        DepositPageBankFrame.setSize(350,200);
        DepositPageBankFrame.setLayout(null);
        DepositPageBankFrame.setLocationRelativeTo(null);
        DepositPageBankFrame.setResizable(false);
        DepositPageBankFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        WithdrawalPageBankFrame = new JFrame();
        WithdrawalPageBankFrame.setTitle("Withdrawal frame");
        WithdrawalPageBankFrame.setSize(350,220);
        WithdrawalPageBankFrame.setLayout(null);
        WithdrawalPageBankFrame.setLocationRelativeTo(null);
        WithdrawalPageBankFrame.setResizable(false);
        WithdrawalPageBankFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BalancePageBankFrame = new JFrame();
        BalancePageBankFrame.setTitle("Balance frame");
        BalancePageBankFrame.setSize(350,220);
        BalancePageBankFrame.setLayout(null);
        BalancePageBankFrame.setLocationRelativeTo(null);
        BalancePageBankFrame.setResizable(false);
        BalancePageBankFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ContactPageBankFrame = new JFrame();
        ContactPageBankFrame.setTitle("Contact frame");
        ContactPageBankFrame.setSize(350,220);
        ContactPageBankFrame.setLayout(null);
        ContactPageBankFrame.setLocationRelativeTo(null);
        ContactPageBankFrame.setResizable(false);
        ContactPageBankFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //----------\\

        //--Panels--\\
        MainPageBankPanel = new JPanel();
        MainPageBankPanel.setBackground(new Color(77, 80, 79));
        this.setContentPane(MainPageBankPanel);
        this.setSize(300,200);
        this.setTitle("Welcome to our bank!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);

        DepositPageBankPanel = new JPanel();
        DepositPageBankPanel.setBackground(new Color(77, 80, 79));
        DepositPageBankPanel.setSize(350,220);
        DepositPageBankPanel.setLayout(null);

        WithdrawalPageBankPanel = new JPanel();
        WithdrawalPageBankPanel.setBackground(new Color(77, 80, 79));
        WithdrawalPageBankPanel.setSize(350,220);
        WithdrawalPageBankPanel.setLayout(null);

        BalancePageBankPanel = new JPanel();
        BalancePageBankPanel.setBackground(new Color(77, 80, 79));
        BalancePageBankPanel.setSize(350,220);
        BalancePageBankPanel.setLayout(null);

        ContactPageBankPanel = new JPanel();
        ContactPageBankPanel.setBackground(new Color(77, 80, 79));
        ContactPageBankPanel.setSize(350,220);
        ContactPageBankPanel.setLayout(null);
        //----------\\
        
        //--Labels--\\
        MainPageBankFunctionsLabel = new JLabel("------------------------(Card functions)------------------------");
        MainPageBankFunctionsLabel.setForeground(ForegroundLabel);
        MainPageBankFunctionsLabel.setBackground(BackgroundButton);
        MainPageBankFunctionsLabel.setBounds(0,30,300,50);

        MainPageBankWelcomeLabel = new JLabel("Welcome Back " + this.card.getCardData().get(1));
        MainPageBankWelcomeLabel.setForeground(ForegroundLabel);
        MainPageBankWelcomeLabel.setBounds(75,15,260,20);
        //----------\\

        //--Buttons--\\
        MainPageBankDepositButton = new JButton("Deposit");
        MainPageBankDepositButton.setForeground(ForegroundButton);
        MainPageBankDepositButton.setBackground(BackgroundButton);
        MainPageBankDepositButton.addActionListener(this);
        MainPageBankDepositButton.setBorder(BorderFactory.createLineBorder(ForegroundButton));
        MainPageBankDepositButton.setBounds(1,80,100,30);
        
        MainPageBankWithdrawalButton = new JButton("Withdrawal");
        MainPageBankWithdrawalButton.setForeground(ForegroundButton);
        MainPageBankWithdrawalButton.setBackground(BackgroundButton);
        MainPageBankWithdrawalButton.addActionListener(this);
        MainPageBankWithdrawalButton.setBorder(BorderFactory.createLineBorder(ForegroundButton));
        MainPageBankWithdrawalButton.setBounds(183,80,100,30);
 
        MainPageBankBalanceButton= new JButton("Balance");
        MainPageBankBalanceButton.setForeground(ForegroundButton);
        MainPageBankBalanceButton.setBackground(BackgroundButton);
        MainPageBankBalanceButton.addActionListener(this);
        MainPageBankBalanceButton.setBorder(BorderFactory.createLineBorder(ForegroundButton)); 
        MainPageBankBalanceButton.setBounds(1,130,100,30);
        
        MainPageBankContactButton= new JButton("Contact Bank");
        MainPageBankContactButton.setForeground(ForegroundButton);
        MainPageBankContactButton.setBackground(BackgroundButton);
        MainPageBankContactButton.addActionListener(this);
        MainPageBankContactButton.setBorder(BorderFactory.createLineBorder(ForegroundButton));
        MainPageBankContactButton.setBounds(183,130,100,30);

        DepositPageBankSubmitButton = new JButton("Submit");
        DepositPageBankSubmitButton.setForeground(ForegroundButton);
        DepositPageBankSubmitButton.setBackground(BackgroundButton);
        DepositPageBankSubmitButton.addActionListener(this);
        DepositPageBankSubmitButton.setBorder(BorderFactory.createLineBorder(ForegroundButton));
        DepositPageBankSubmitButton.setBounds(128, 110, 80,30);

        DepositPageBankHomeButton = new JButton(icon);
        DepositPageBankHomeButton.setForeground(ForegroundButton);
        DepositPageBankHomeButton.setBackground(BackgroundButton);
        DepositPageBankHomeButton.addActionListener(this);
        DepositPageBankHomeButton.setBorder(BorderFactory.createLineBorder(ForegroundButton));
        DepositPageBankHomeButton.setBounds(5, 5, 37,37);

        WithdrawalPageBankHomeButton = new JButton(icon);
        WithdrawalPageBankHomeButton.setForeground(ForegroundButton);
        WithdrawalPageBankHomeButton.setBackground(BackgroundButton);
        WithdrawalPageBankHomeButton.addActionListener(this);
        WithdrawalPageBankHomeButton.setBorder(BorderFactory.createLineBorder(ForegroundButton));
        WithdrawalPageBankHomeButton.setBounds(5, 5, 37,37);

        BalancePageBankHomeButton = new JButton(icon);
        BalancePageBankHomeButton.setForeground(ForegroundButton);
        BalancePageBankHomeButton.setBackground(BackgroundButton);
        BalancePageBankHomeButton.addActionListener(this);
        BalancePageBankHomeButton.setBorder(BorderFactory.createLineBorder(ForegroundButton));
        BalancePageBankHomeButton.setBounds(5, 5, 37,37);

        ContactPageBankHomeButton = new JButton(icon);
        ContactPageBankHomeButton.setForeground(ForegroundButton);
        ContactPageBankHomeButton.setBackground(BackgroundButton);
        ContactPageBankHomeButton.addActionListener(this);
        ContactPageBankHomeButton.setBorder(BorderFactory.createLineBorder(ForegroundButton));
        ContactPageBankHomeButton.setBounds(5, 5, 37,37);
        //-----------\\

        //--TextFields--\\
        DepositPageBankTextField = new JTextField("How much do you want to deposit?");
        DepositPageBankTextField.setBackground(BackgroundButton);
        DepositPageBankTextField.setForeground(ForegroundButton);
        DepositPageBankTextField.setBorder(BorderFactory.createLineBorder(ForegroundButton));
        DepositPageBankTextField.setBounds(75,69,185,19);

        DepositPageBankPrivacyTextPane = new JTextPane();
        DepositPageBankPrivacyTextPane.setContentType("text/html");
        DepositPageBankPrivacyTextPane.setText("<html><body><p style='color:rgb(43, 249, 194);font-size:7px;position:relative;margin-top:1rem;'><strong style='color:red;'>DISCLAIMER!</strong>Our bank provides all protection and security during the deposit of money in your account.<p style='color:rgb(43, 249, 194);font-size:7px;position:absolute;margin-left:130px;margin-top:0.5rem;'>©2022 MISA Privacy Policy</p></p></body></html>");
        DepositPageBankPrivacyTextPane.setBackground(BackgroundButton);
        DepositPageBankPrivacyTextPane.setForeground(ForegroundButton);
        DepositPageBankPrivacyTextPane.setBorder(BorderFactory.createLineBorder(ForegroundButton));
        DepositPageBankPrivacyTextPane.setBounds(50,5,280,37);
        //--------------\\

        //--frames/Panels content--\\
        this.add(MainPageBankWelcomeLabel);
        this.add(MainPageBankFunctionsLabel);
        this.add(MainPageBankDepositButton);
        this.add(MainPageBankWithdrawalButton);
        this.add(MainPageBankBalanceButton);
        this.add(MainPageBankContactButton);

        DepositPageBankPanel.add(DepositPageBankTextField);
        DepositPageBankPanel.add(DepositPageBankPrivacyTextPane);
        DepositPageBankPanel.add(DepositPageBankHomeButton);
        DepositPageBankPanel.add(DepositPageBankSubmitButton);
        WithdrawalPageBankPanel.add(WithdrawalPageBankHomeButton);
        BalancePageBankPanel.add(BalancePageBankHomeButton);
        ContactPageBankPanel.add(ContactPageBankHomeButton);


        DepositPageBankFrame.add(DepositPageBankPanel);
        WithdrawalPageBankFrame.add(WithdrawalPageBankPanel);
        BalancePageBankFrame.add(BalancePageBankPanel);
        ContactPageBankFrame.add(ContactPageBankPanel);
        //-------------------------\\

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

    	
    	if (e.getSource().equals(MainPageBankDepositButton)) {

            this.DepositPageBankFrame.setVisible(true);
        }
        else if (e.getSource().equals(MainPageBankWithdrawalButton)) {

            this.WithdrawalPageBankFrame.setVisible(true);
            // String withdrawal;

            // withdrawal = JOptionPane.showInputDialog(null, "How much do you want to withdraw?");


            // if(bank.getBankBalance() > Integer.parseInt(withdrawal)) {

            //     bank.Withdrawal(Integer.parseInt(withdrawal));

            //     JOptionPane.showMessageDialog(null, "Your balance after the withdraw is: " + bank.getBalance() + ".");
            // }
            // else {

            //     JOptionPane.showMessageDialog(null, "Bank doesn't have enough money to make the withdrawal.");
            // }
        }
        else if (e.getSource().equals(MainPageBankBalanceButton)){
            this.BalancePageBankFrame.setVisible(true);
            // JOptionPane.showMessageDialog(null, "Your balance is: " + bank.getBalance() + ".");
        }
        else if (e.getSource().equals(MainPageBankContactButton)){
            this.ContactPageBankFrame.setVisible(true);
            // JOptionPane.showMessageDialog(null, "Website is currently offline.");
        }
        else if (e.getSource().equals(DepositPageBankSubmitButton)){
            String deposit = DepositPageBankTextField.getText();
            System.out.println(this.bank.Deposit(Integer.parseInt(deposit)));
        }
    }
}
