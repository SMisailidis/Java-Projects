import Pieces.Pawn;
import Pieces.Piece;

import javax.swing.*;
import java.awt.*;

public class Square {
    private MyButton button = new MyButton();
    private Piece piece;
    private int indexX, indexY;

    public MyButton getButton() {
        return button;
    }

    public void setButton(MyButton button) {
        this.button = button;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void setHasCircle(boolean b, Color color) {
        button.setHasCircle(b, color);
    }

    public void setFirstMove(){
        piece.isFirstMove(false);
    }

    public void setIcon(ImageIcon icon) {
        button.setIcon(icon);
    }

    public int getX() {
        return piece.getX();
    }

    public int getY() {
        return piece.getY();
    }

    public void confirmMove(int x, int y) {
        piece.confirmMove(x, y);
    }

    public int getIndexX() {
        return indexX;
    }

    public void setIndexX(int indexX) {
        this.indexX = indexX;
    }

    public int getIndexY() {
        return indexY;
    }

    public void setIndexY(int indexY) {
        this.indexY = indexY;
    }
    public ImageIcon getIcon() {
        return (ImageIcon) button.getIcon();
    }
}
