import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.*;

public class HeroSelectGUI extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	protected ArrayList<String[]> resultsArrayList;
	protected String receivedData;
	protected String query;
	protected String text;
	
	protected String number; // Number of players
	protected int j=2; // Int for help
	
	protected ArrayList<Heroes> selectedHeroes; // A list with the selectedPlayers
	protected JComboBox<String> dropDownList; // DropdownList
	protected TreeMap<String,String> imgHero = new TreeMap<String,String>(); // TreeMap/HashTable sorted
	
	protected JFrame frame; // Main frame
	
	protected JLabel imageLabel = new JLabel(); // Image label
	protected JLabel playerChooseLabel; // Choose hero label
	protected JLabel copyrightLabel; // Game by : MISA

	protected JTextArea infoTextArea; // Info textArea
	
	protected JButton selectButton; // Select button
	
	protected ImageIcon icon; // Image icon
	protected ImageIcon logo; // Mini icon in the frame

	public HeroSelectGUI() {

		this.resultsArrayList = new ArrayList<String[]>();
		this.receivedData = "";
		this.query = "";
		this.text = "";

		String message = null;
		this.number = null;
		this.selectedHeroes = new ArrayList<Heroes>();
		
		treeFill(); // Fill the treeMap
		
		do {
			number = JOptionPane.showInputDialog(message, "Give me the number of players (from 1 to 4)");
		}while(Integer.parseInt(number) < 1 || Integer.parseInt(number) > 4);
		
		//----------Frame----------\\
		logo = new ImageIcon("src\\M.png"); // Frame's logo
		
		frame = new JFrame(); // Frame creation
		frame.getContentPane().setLayout(null); // Layout setup
		frame.getContentPane().setBackground(Color.BLACK); // Background color definition
		frame.setTitle("Hero Select"); // Title definition
		frame.setIconImage(logo.getImage()); // Logo definition
		frame.setSize(800,500); // Set definition
		frame.setResizable(false); // Doesn't allow the frame to resize 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close when you press "X" on the frame
		//-------------------------\\
		
		//----------dropDownList----------\\
		dropDownList = new JComboBox<String>(); // dropDownList creation
		dropDownList.setBounds(20,100,150,50); // Bounds definition
		dropDownList.setBackground(Color.BLACK); // Background color definition
		dropDownList.setForeground(Color.RED); // Foreground color definition
		
		for(Map.Entry<String, String> i : this.imgHero.entrySet()) { 
			dropDownList.addItem(i.getKey()); // Fill dropDownList
		}
		
		dropDownList.addActionListener(this); // allows dropDownList to have actions
		this.query = "SELECT HEROES.description FROM HEROES WHERE name= 'Ant-Man'";

		if(Game.sql.makeDMLQuery(this.query)){
			
			this.resultsArrayList.clear();

			this.receivedData = Game.sql.getQueryResults(); // Gets the first info from the .txt

			this.resultsArrayList = Game.spliterator(this.receivedData);
			
			this.text = this.resultsArrayList.get(0)[0];
		}
		
		//-----------------------\\
		
		//----------imageLabel----------\\
		icon = new ImageIcon(this.imgHero.get(dropDownList.getSelectedItem())); // Take the first image from the dropDownList
		this.imageLabel.setBounds(600,89,200,250); // Bounds definition
		imageLabel.setIcon(icon); // Define the heroIcon to the imageLabel
		//------------------------------\\
		
		//----------playerChooseLabel----------\\
		playerChooseLabel = new JLabel(); // playerChooseLabel creation
		playerChooseLabel.setBounds(300,10,195,30); // Bounds definition
		playerChooseLabel.setBackground(Color.BLACK); // Background color definition
		playerChooseLabel.setForeground(Color.RED); // Foreground color definition
		playerChooseLabel.setBorder(BorderFactory.createLineBorder(Color.RED)); // Border color definition
		playerChooseLabel.setFont(new Font("Arial", Font.BOLD, 15)); // font definition
		playerChooseLabel.setText("Player 1, choose your Hero"); // set the text into playerChooseLabel
		//-------------------------------------\\
		
		//----------copyrightLabel----------\\
		copyrightLabel = new JLabel(); // copyrightLabel creation
		copyrightLabel.setBounds(325,400,130,30); // Bounds definition
		copyrightLabel.setBackground(Color.BLACK); // Background color definition
		copyrightLabel.setForeground(Color.RED); // Foreground color definition
		copyrightLabel.setBorder(BorderFactory.createLineBorder(Color.RED)); // Border color definition
		copyrightLabel.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 18)); // font definition
		copyrightLabel.setText("Game by: MISA"); // set the text into copyrightLabel
		//----------------------------------\\
		
		//----------selectButton----------\\
		selectButton = new JButton("Select"); // selectButton creation
		selectButton.setBounds(340,300,100,30); // Bounds definition
		selectButton.setBackground(Color.BLACK); // Background color definition
		selectButton.setForeground(Color.RED); // Foreground color definition
		selectButton.setBorder(BorderFactory.createLineBorder(Color.RED)); // Border color definition
		selectButton.addActionListener(this); // allows selectButton to have actions
		//--------------------------------\\
		
		//----------infoTextArea----------\\
		infoTextArea = new JTextArea(); // infoTextArea creation
		infoTextArea.setBounds(200,100,380,160); // Bounds definition
		infoTextArea.setBackground(Color.BLACK); // Background color definition
		infoTextArea.setForeground(Color.RED); // Foreground color definition
		infoTextArea.setBorder(BorderFactory.createLineBorder(Color.RED)); // Border color definition
		infoTextArea.setFont(new Font("Arial", Font.BOLD, 12)); // font definition
		infoTextArea.setEditable(false); // Doesn't allow the infoTextArea to edit 
		infoTextArea.setLineWrap(true); // idk
		infoTextArea.setWrapStyleWord(true); // idk
		infoTextArea.setText(text); // set the text into infoTextArea 
		//--------------------------------\\

		//----------frame displays----------\\
		frame.add(selectButton); // Add button to the frame
		frame.add(imageLabel); // Add imageLabel to the frame
		frame.add(playerChooseLabel); // Add playerChooseLabel to the frame
		frame.add(copyrightLabel); // Add copyrightLabel to the frame
		frame.add(infoTextArea); // Add infoTextArea to the frame
		frame.add(dropDownList); // Add dropDownList to the frame
		frame.setVisible(true); // Makes the frame visible
		//----------------------------------\\
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==dropDownList) {
			
			icon = new ImageIcon(this.imgHero.get(dropDownList.getSelectedItem()));
			imageLabel.setIcon(icon);
			frame.add(imageLabel);
			
			this.query = "SELECT HEROES.description FROM HEROES WHERE name=" + '"' + this.dropDownList.getSelectedItem() + '"';

			if(Game.sql.makeDMLQuery(this.query)){

				this.resultsArrayList.clear();

				this.receivedData = Game.sql.getQueryResults();

				this.resultsArrayList = Game.spliterator(this.receivedData);

				infoTextArea.setText(this.resultsArrayList.get(0)[0]);
			}
		}
		
		if(e.getSource()==selectButton) {
			
			Game.select(dropDownList.getSelectedItem().toString());
			dropDownList.removeItem(dropDownList.getSelectedItem());
			
			if(this.j <= Integer.parseInt(this.number)) {
				this.playerChooseLabel.setText("Player " + this.j + ", choose your Hero");
				j++;
			}
			else {
				//BoardGUI board = new BoardGUI();
				frame.setVisible(false);
			}

		}
	}
	
	public void treeFill() {

		this.query = "SELECT HEROES.name FROM HEROES";

		if(Game.sql.makeDMLQuery(this.query)){

			this.resultsArrayList.clear();

			this.receivedData = Game.sql.getQueryResults();

			this.resultsArrayList = Game.spliterator(this.receivedData);

			for (String[] r : this.resultsArrayList) {

				String location = "src\\Heroes\\" + r[0] + ".png";
				this.imgHero.put(r[0], location);
			}
		}
	}
}
