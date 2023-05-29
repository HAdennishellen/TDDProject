package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.ChessboardImpl;
import ax.ha.tdd.chess.engine.Square;
import ax.ha.tdd.chess.engine.Player;

public class Bishop extends ChessPieceBase implements ChessPiece{

    public Bishop(Player player, Square location) {
        super(PieceType.BISHOP, player, location);
    }

    public boolean checkIfSquareEmpty(Square targetSquare, ChessboardImpl chessboard){
        final ChessPiece chessPiece;
        chessPiece = chessboard.getPieceAt(targetSquare);

        if(chessPiece == null){
            return true;
        }
        else return false;
    }
    @Override
    public String getSymbol() {
        return null;
    }

    @Override
    public boolean canMove(ChessboardImpl chessboard, Square destination) {
        int destinationX = destination.getX();
        int destinationY = destination.getY();
        int startX = location.getX();
        int startY = location.getY();


        int row = startX;
        int col = startY;

        if (startX != destinationX && startY != destinationY) {
            int rowOffset, colOffset;
            if (startX < destinationX) {
                rowOffset = 1;
            } else {
                rowOffset = -1;
            }
            if (startY < destinationY) {
                colOffset = 1;
            } else {
                colOffset = -1;
            }

            while (row != destinationX && col != destinationY) {

                if (!checkIfSquareEmpty(new Square(row + rowOffset, col + colOffset), chessboard)) {

                    if (chessboard.getPieceAt(new Square(row + rowOffset, col + colOffset)) != null && chessboard.getPieceAt(new Square(row + rowOffset, col + colOffset)).getPlayer() == Player.WHITE) {

                        return false;
                    }
                    return true;

                }


                if (startY > startY + colOffset) {
                    col--;
                }
                if (startY < startY + colOffset) {
                    col++;
                }
                if (startX > startX + rowOffset) {
                    row--;
                }
                if (startX < startX + rowOffset) {
                    row++;
                }

                if (row == destinationX && col == destinationY) {
                    return true;
                }
            }
        }
        return false;
    }
}