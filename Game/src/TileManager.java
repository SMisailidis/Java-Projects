import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import java.awt.*;

public class TileManager {
    
    BoardPanelGUI gp;
    Tile[] tile;
    int mapTileNum[][];

    public TileManager(BoardPanelGUI gp) {

        this.gp = gp;

        tile = new Tile[20];
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];

        getTileImage();

        loadMap("maps/map01.txt");
    }

    public void getTileImage() {

        try {

            tile[0] = new Tile();
            tile[0].image = ImageIO.read((getClass().getResourceAsStream("tiles/start tile.png")));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read((getClass().getResourceAsStream("tiles/path horizontal.png")));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read((getClass().getResourceAsStream("tiles/purple.png")));
            tile[2].specialTile = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read((getClass().getResourceAsStream("tiles/gold.png")));
            tile[3].specialTile = true;
            
            tile[4] = new Tile();
            tile[4].image = ImageIO.read((getClass().getResourceAsStream("tiles/right turn.png")));

            tile[5] = new Tile();
            tile[5].image = ImageIO.read((getClass().getResourceAsStream("tiles/left turn.png")));

            tile[6] = new Tile();
            tile[6].image = ImageIO.read((getClass().getResourceAsStream("tiles/cyan.png")));
            tile[6].specialTile = true;

            tile[7] = new Tile();
            tile[7].image = ImageIO.read((getClass().getResourceAsStream("tiles/green.png")));
            tile[7].specialTile = true;

            tile[8] = new Tile();
            tile[8].image = ImageIO.read((getClass().getResourceAsStream("tiles/orange.png")));
            tile[8].specialTile = true;
            
            tile[9] = new Tile();
            tile[9].image = ImageIO.read((getClass().getResourceAsStream("tiles/left down turn.png")));

            tile[10] = new Tile();
            tile[10].image = ImageIO.read((getClass().getResourceAsStream("tiles/right down turn.png")));

            tile[11] = new Tile();
            tile[11].image = ImageIO.read((getClass().getResourceAsStream("tiles/red.png")));
            tile[11].specialTile = true;

            tile[12] = new Tile();
            tile[12].image = ImageIO.read((getClass().getResourceAsStream("tiles/start tile.png")));

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void loadMap(String path) {

        try{

            InputStream is = getClass().getResourceAsStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0, row = 0;

            while(col < gp.maxScreenCol && row < gp.maxScreenRow) {

                String line = br.readLine();

                while(col < gp.maxScreenCol) {

                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;

                    col++;
                }
                if(col == gp.maxScreenCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {

        int col=0, row=0, x=0, y=0;

        for (int[] is : mapTileNum) {
            for (int i : is) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        while(col < gp.maxScreenCol && row < gp.maxScreenRow) {

            int tileNum = mapTileNum[col][row];

            g2.drawImage(tile[tileNum].image, x, y , gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;

            if(col == gp.maxScreenCol) {

                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }

        // g2.drawImage(tile[0].image, 0, 0, gp.tileSize, gp.tileSize, null);
        // g2.drawImage(tile[1].image, gp.tileSize, 0, gp.tileSize, gp.tileSize, null);
        // g2.drawImage(tile[2].image, gp.tileSize*2, 0, gp.tileSize, gp.tileSize, null);
        // g2.drawImage(tile[3].image, (gp.tileSize - gp.HeroesSize)/2, (gp.tileSize - gp.HeroesSize)/2, gp.HeroesSize, gp.HeroesSize, null);
    }
}
