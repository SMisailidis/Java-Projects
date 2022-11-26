import java.awt.*;
import javax.swing.*;


public class BoardPanelGUI extends JPanel implements Runnable{

	//Screen settings
	final int originalTileSize = 64; // For tiles
	final int originalHeroesSize = 16; //For heroes
	final int scale = 1;
	final int heroScale = 1;

	final int tileSize = originalTileSize * scale;
	final int HeroesSize = originalHeroesSize * heroScale;
	final int maxScreenCol = 10;
	final int maxScreenRow = 10;
	final int screenWidth = tileSize * maxScreenCol;
	final int screenHeight = tileSize * maxScreenRow;

	public int round = 0;
	public int roll = 0;
	public int stopUpdate = 0;
	public boolean roundFlag = false;

	int[] playersX = new int[Game.selectedHeroes.size()];
	int[] playersY = new int[Game.selectedHeroes.size()];

	final int FPS = 60;

	Thread gameThread;

	DiceGUI dGUI = new DiceGUI(this);
	TileManager tileM = new TileManager(this);
	PlayerTileManager pTileM = new PlayerTileManager(this);
	GamePlay gPlay = new GamePlay(this);

	public BoardPanelGUI() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);

		for (int i = 0; i < playersX.length; i++) {
			playersX[i] = tileSize - HeroesSize;
			playersY[i] = (tileSize - HeroesSize) / 2;
		}

		startGameThread();
	}

	public void startGameThread(){

		gameThread = new Thread(this);
		gameThread.start();
	}

	public void run() {
		
		double drawInterval = 1000000000 / FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;

		while(gameThread != null) {

			currentTime = System.nanoTime();

			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;

			if(delta >= 1){

				update();

				repaint();

				delta--;
				drawCount++;

				//System.out.println("running");
			}

			if(timer >= 1000000000){
				drawCount = 0;
				timer = 0;
			}
		}
	}

	public void update() {

		if(stopUpdate < roll * tileSize){
			playersX[round]++;
			stopUpdate++;
		}
		else if(stopUpdate == roll * tileSize && roundFlag) {

			stopUpdate = 0;
			roll = 0;
			roundFlag = false;

			if(round < Game.selectedHeroes.size() - 1){
				
            	round++;
			}
			else{
                round = 0;
			}
		}
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D)g;

		tileM.draw(g2);
		pTileM.draw(g2);

		g2.dispose();

	}

	
}
