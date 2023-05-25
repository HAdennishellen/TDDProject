package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.ChessboardImpl;
import ax.ha.tdd.chess.engine.Square;
import ax.ha.tdd.chess.engine.Player;

public class Rook extends ChessPieceBase implements ChessPiece{

    public Rook(Player player, Square location) {
        super(PieceType.ROOK, player, location);
    }

    @Override
    public String getSymbol() {
        return null;
    }


    //    public int getDirection( int y){
//        int playerDirection;
//        if (player == Player.WHITE) {
//            //DO NOTE, PROGRAMMERS START AT 0 NOT 1
//
//            return playerDirection = -1;  // Forward direction for white player
//        } else {
//
//            return playerDirection = 1; // Forward direction for black player
//        }
//    }
    public boolean checkIfSquareEmpty(Square target, ChessboardImpl chessboard) {
        final ChessPiece chessPiece;
        chessPiece = chessboard.getPieceAt(target);

        //System.out.println(chessPiece.toString());

        if (chessPiece == null) {
            return true;
        } else return false;
    }

    public boolean AttackEnemy(Square targetSquare, Square startSquare, Chessboard chessboard) {
        ChessPiece chessPiece = chessboard.getPieceAt(startSquare);
        int startX = startSquare.getX();
        int startY = startSquare.getY();
        int targetX = targetSquare.getX();
        int targetY = targetSquare.getY();

//        if(Math.abs(targetX - startX) == 1 && targetY == startY + getDirection(startY)){
//            if(chessPiece != null && chessPiece.getPlayer() != chessboard.getPieceAt(targetSquare).getPlayer()){
//                return  true;
//            }
//        }
//        else{
//            System.out.println("we failed the attack check in pawn");
//            return false;
//        }
        return false;
    }
    @Override
    public boolean canMove(ChessboardImpl chessboard, Square destination) {
        Square currentLocation = getLocation();

        int startX = currentLocation.getX();
        int startY = currentLocation.getY();
        int destinationX = destination.getX();
        int destinationY = destination.getY();

        // Rooks can move horizontally or vertically
        if (startX == destinationX || startY == destinationY) {
            // Check if there are any pieces blocking the path
            int xDirection = Integer.compare(destinationX, startX);
            int yDirection = Integer.compare(destinationY, startY);

            int col = startX + xDirection;
            int row = startY + yDirection;

            while (col != destinationX || row != destinationY) {
                Square squaretocheck = new Square(col,row);

                if (chessboard.getPieceAt(squaretocheck) != null) {
                    // Path is blocked
                    return false;
                }

                col += xDirection;
                row += yDirection;
            }

            // Check if the destination square is empty or occupied by an opponent's piece
            ChessPiece pieceAtDestination = chessboard.getPieceAt(destination);
            return pieceAtDestination == null || !pieceAtDestination.getPlayer().equals(getPlayer());
        }
        return false;
    }
}

