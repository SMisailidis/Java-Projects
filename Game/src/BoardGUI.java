import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class BoardGUI extends JFrame{

	protected ImageIcon logo;
	
	protected JButton dice;

	public int roll;
	
	public BoardGUI() {

		JFrame board = new JFrame();

		logo = new ImageIcon("src\\M.png"); // Frame's logo
			
		JPanel panel = new BoardPanelGUI();
		
		board.add(panel);
		board.pack();

		board.setIconImage(logo.getImage()); // Logo definition
		board.setTitle("Board");
		board.setResizable(false);
		board.setLocationRelativeTo(null);
		board.setVisible(true);
		board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
