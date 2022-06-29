import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;


public class GUI {

	public GUI() {
		JFrame frame1 = new JFrame("Find Suspect");
		JTextField text1 = new JTextField("Please enter suspect's name");
		JButton button1 = new JButton("Find");
		
		frame1.setSize(300,200);
		frame1.setVisible(true);
		
		frame1.add(text1);
		frame1.add(button1);
		frame1.getContentPane().setLayout(null);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		text1.setBounds(30,10,167,20);
		button1.setBounds(205, 5, 60, 30);
		
	}
}
