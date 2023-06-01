package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.ChessboardImpl;
import ax.ha.tdd.chess.engine.Square;
import ax.ha.tdd.chess.engine.Player;

import java.util.Iterator;

public class King extends ChessPieceBase implements ChessPiece {

    public King(Player player, Square location) {
        super(PieceType.KING, player, location);
    }

    @Override
    public String getSymbol() {
        return null;
    }

    @Override
    public boolean canMove(ChessboardImpl chessboard, Square destination) {


        int deltaX = destination.getX() - getLocation().getX();
        int deltaY = destination.getY() - getLocation().getY();

        // Check if the move is within one square in any direction
        if ((deltaX >= -1 && deltaX <= 1) && (deltaY >= -1 && deltaY <= 1)) {

            //ALSO CHECK IF THE SQUARE IS NOT EMPTY WHAT SORT OF PIECE IT IS IF ENEMY OR NOt
            if (chessboard.getPieceAt(destination) == null || chessboard.getPieceAt(destination).getPlayer() != getPlayer()) {

                //if the position is a dangerous one
                //DO A HYPOEHTICAL MOVE TO SEE IF I DANGER DANGER

                //THIS IS THE ORGINAL PIECE STANDING AT TARGET SAVE IT SO WE CAN PUT IT BACK MIGHT NOT WORK DUE TO CHESS PIECE STUB NEED TO TEST
                ChessPieceStub tempPiece = new ChessPieceStub(getPieceType(),getPlayer(),destination);

                chessboard.removePiece(location);
                chessboard.addPiece(new ChessPieceStub(PieceType.KING, getPlayer(), destination));


                //do the actual check
                boolean dangerCheck = checkForCheck(chessboard, getPlayer(),destination);

                if(dangerCheck == false){

                    chessboard.removePiece(destination);
                    chessboard.addPiece(tempPiece);
                    return true;
                }
                else{
                    chessboard.removePiece(destination);
                    chessboard.addPiece(new ChessPieceStub(PieceType.KING, getPlayer(), location));
                    return false;
                }
            }
        }
        return false;
    }

    public boolean checkForCheck(ChessboardImpl chessboard, Player currentPlayer, Square HypotheticalKingSquare) {

        int boardSize = chessboard.GetSize();


        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                Square currentSquare = new Square(row, col);


                // Check if the current piece exists and belongs to the opponent
                if (currentPiece != null && currentPiece.getPlayer() != currentPlayer) {
                    // Check if the current piece can attack the king's position
                    if (currentPiece.canMove(chessboard, kingSquare)) {
                        return true; // The king is in check
                    }
                }
            }
        }
        return false; // The king is not in check
    }
}


