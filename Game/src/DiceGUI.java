import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class DiceGUI extends JFrame implements ActionListener{
    
    protected JButton dice;

	public int roll;

    BoardPanelGUI gp;

    public DiceGUI(BoardPanelGUI gp){

        this.gp = gp;
        JFrame diceFrame = new JFrame();
		diceFrame.setSize(300,300);
		diceFrame.setResizable(false);
		diceFrame.setVisible(true);
		diceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel dicePanel = new JPanel();
		dicePanel.setSize(300,300);
		dicePanel.setBackground(Color.black);
		dicePanel.setLayout(null);

		dice = new JButton("Roll");
		dice.setBounds(120,190,50,30);
		dice.setForeground(Color.red);
		dice.setBackground(Color.BLACK);
		dice.setBorder(BorderFactory.createLineBorder(Color.RED)); // Border color definition
		dice.addActionListener(this);
		
		dicePanel.add(dice);
		diceFrame.add(dicePanel);
	}
	
	public void actionPerformed(ActionEvent e) {

		if(e.getSource().equals(dice)) {

			Random dice = new Random();
		
			roll = dice.nextInt(6) + 1 ;

            this.gp.roundFlag = true;
            this.gp.roll = roll; 
		}
	}
}
