import Pieces.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ChessGUI extends JFrame{

    private final Square[][] squares;
    private Square tempS;

    public ChessGUI () {

        Color firstColor = new Color(203, 203, 177);
        Color secondColor = new Color(118, 150, 86);

        JFrame frame = new JFrame("Chess Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setLocationRelativeTo(null);
        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());

        JPanel chessBoard = new JPanel();
        chessBoard.setLayout(new GridLayout(8, 8));
        content.add(chessBoard, BorderLayout.CENTER);

        squares = new Square[8][8];

        String sColor;
        Color color;
        tempS = new Square();

        for(int i=0; i < 8; i++){

            if(i<=1){
                sColor = "WHITE";
                color = Color.WHITE;
            }
            else{
                sColor = "BLACK";
                color = Color.BLACK;
            }

            for(int j=0; j<8;j++){

                Square square = new Square();
                MyButton squareButton = new MyButton();


                if((i+j) % 2 != 0){
                    squareButton.setBackground(secondColor);
                }
                else{
                    squareButton.setBackground(firstColor);
                }

                if(i==1){
                    ImageIcon pawnIcon = new ImageIcon("images/WHITE-Pawn.png");
                    squareButton.setIcon(pawnIcon);
                    square.setPiece(new Pawn(i,j, color));
                }
                else if(i == 8 - 2){
                    ImageIcon pawnIcon = new ImageIcon("images/BLACK-Pawn.png");
                    squareButton.setIcon(pawnIcon);
                    square.setPiece(new Pawn(i,j, color));
                }
                else if( i == 0 || i == 8 - 1){
                    if( j == 0 || j == 8 - 1){
                        ImageIcon rookIcon = new ImageIcon("images/" + sColor + "-Rook.png");
                        squareButton.setIcon(rookIcon);
                        square.setPiece(new Rook(i, j, color));
                    }
                    else if( j == 1 || j == 8 - 2){
                        ImageIcon knightIcon = new ImageIcon("images/" + sColor + "-Knight.png");
                        squareButton.setIcon(knightIcon);
                        square.setPiece(new Knight(i, j, color));
                    }
                    else if( j == 2 || j == 8 - 3){
                        ImageIcon bishopIcon = new ImageIcon("images/" + sColor + "-Bishop.png");
                        squareButton.setIcon(bishopIcon);
                        square.setPiece(new Bishop(i, j, color));
                    }
                    else if (j == 3){
                        ImageIcon queenIcon = new ImageIcon("images/" + sColor + "-Queen.png");
                        squareButton.setIcon(queenIcon);
                        square.setPiece(new Queen(i, j, color));
                    }
                    else {
                        ImageIcon kingIcon = new ImageIcon("images/" + sColor + "-King.png");
                        squareButton.setIcon(kingIcon);
                        square.setPiece(new King(i, j, color));
                    }
                }

                squareButton.addActionListener(e -> {

                    if(squareButton.isHasCircle()){
                        makeMove(square, tempS);
                    }
                    else{
                        if(squareButton.getIcon() != null){
                            showPossibleMoves(square.getPiece());
                            this.tempS= square;
                        }
                    }


                });

                square.setIndexX(i);
                square.setIndexY(j);
                square.setButton(squareButton);
                squares[i][j] = square;
                chessBoard.add(square.getButton());
            }
        }
        frame.setVisible(true);
    }

    private void makeMove(Square square, Square prevSquare) {

        ImageIcon img = prevSquare.getIcon();

        square.setIcon(img);
        prevSquare.setIcon(null);

        square.setPiece(prevSquare.getPiece());
        square.confirmMove(square.getIndexX(), square.getIndexY());
        square.setFirstMove();

        removeDots();
    }

    private void showPossibleMoves(Piece piece) {

        removeDots();

        Move move = new Move(piece.getX(), piece.getY());
        ArrayList<String[]> validMoves =  move.checkValidity(squares, piece);

//        for(String[] r : s){
//
//            if(squares[Integer.parseInt(r[0])][Integer.parseInt(r[1])].getIcon() == null) {
//
//                squares[Integer.parseInt(r[0])][Integer.parseInt(r[1])].setHasCircle(true, piece.getColor());
//            }
//        }
    }

    private void removeDots() {

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                squares[i][j].setHasCircle(false, Color.WHITE);
            }
        }
    }
}
