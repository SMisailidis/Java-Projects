package Pieces;

import java.awt.*;

public class Rook extends Piece{

    public Rook(int x, int y, Color color) {
        super(x, y, "Rook", color);
    }

    public String Move() {
        String send = "";

        for (int i = 1; i <8; i++) {
            int tempX = getX() + i;
            int tempY = getY() + i;

            if(tempX <= 7) {
                send += (tempX) + "," + getY() + "-";
            }
            if(tempY <= 7){
                send += getX() + "," + (tempY) + "-";
            }

            tempX = getX() -i;
            tempY = getY() -i;

            if (tempX >= 0) {
                send += (tempX) + "," + getY() + "-";
            }

            if(tempY >= 0){
                send += getX() + "," + (tempY) + "-";
            }
        }
        return send.substring(0, send.length()-1);
    }
}
