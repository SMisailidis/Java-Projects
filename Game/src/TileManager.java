import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import java.awt.*;

public class TileManager {
    
    BoardPanelGUI gp;
    Tile[] tile;
    int mapTileNum[][];

    public ArrayList<Rectangle> rects;

    public TileManager(BoardPanelGUI gp) {

        this.gp = gp;

        tile = new Tile[16];
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];

        getTileImage();

        loadMap("maps/map01.txt");

        rects = arrayListFill();
    }

    public void getTileImage() {

        try {

            tile[0] = new Tile();
            tile[0].image = ImageIO.read((getClass().getResourceAsStream("tiles/start tile.png")));
            tile[0].name = "start tile";

            tile[1] = new Tile();
            tile[1].image = ImageIO.read((getClass().getResourceAsStream("tiles/path horizontal.png")));
            tile[1].name = "path horizontal";

            tile[2] = new Tile();
            tile[2].image = ImageIO.read((getClass().getResourceAsStream("tiles/purple.png")));
            tile[2].name = "purple";

            tile[3] = new Tile();
            tile[3].image = ImageIO.read((getClass().getResourceAsStream("tiles/gold.png")));
            tile[3].name = "gold";
            
            tile[4] = new Tile();
            tile[4].image = ImageIO.read((getClass().getResourceAsStream("tiles/right turn.png")));
            tile[4].name = "right turn";

            tile[5] = new Tile();
            tile[5].image = ImageIO.read((getClass().getResourceAsStream("tiles/left turn.png")));
            tile[5].name = "left turn";

            tile[6] = new Tile();
            tile[6].image = ImageIO.read((getClass().getResourceAsStream("tiles/cyan.png")));
            tile[6].name = "cyan";

            tile[7] = new Tile();
            tile[7].image = ImageIO.read((getClass().getResourceAsStream("tiles/green.png")));
            tile[7].name = "green";

            tile[8] = new Tile();
            tile[8].image = ImageIO.read((getClass().getResourceAsStream("tiles/orange.png")));
            tile[8].name = "orange";
            
            tile[9] = new Tile();
            tile[9].image = ImageIO.read((getClass().getResourceAsStream("tiles/left down turn.png")));
            tile[9].name = "left down turn";

            tile[10] = new Tile();
            tile[10].image = ImageIO.read((getClass().getResourceAsStream("tiles/right down turn.png")));
            tile[10].name = "right down turn";

            tile[11] = new Tile();
            tile[11].image = ImageIO.read((getClass().getResourceAsStream("tiles/red.png")));
            tile[11].name = "red";

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

        while(col < gp.maxScreenCol && row < gp.maxScreenRow) {

            int tileNum = mapTileNum[col][row];

            g2.drawImage(tile[tileNum].image, x, y , gp.tileSize, gp.tileSize, null);
            
            if(tileNum == 2 || tileNum == 3 || tileNum == 6 || tileNum == 7 || tileNum == 8 || tileNum == 11){

                tile[tileNum].rect.x = x;
                tile[tileNum].rect.y = y;

                if(rects.size() < 14){
                    rects.add(new Rectangle(x,y,64,64));
                }
            }

            col++;
            x += gp.tileSize;

            if(col == gp.maxScreenCol) {

                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }     
    }

    public ArrayList<Rectangle> arrayListFill() {

        ArrayList<Rectangle> temp = new ArrayList<Rectangle>();

        int col=0, row=0, x=0, y=0;

        while(col < gp.maxScreenCol && row < gp.maxScreenRow) {

            int tileNum = mapTileNum[col][row];

            if(tileNum == 2 || tileNum == 3 || tileNum == 6 || tileNum == 7 || tileNum == 8 || tileNum == 11){

                tile[tileNum].rect.x = x;
                tile[tileNum].rect.y = y;

                if(temp.size() < 14){
                    temp.add(new Rectangle(x,y,64,64));
                    
                }
            }

            col++;
            x += gp.tileSize;

            if(col == gp.maxScreenCol) {

                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        } 

        return temp;
    }
}
