package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.ChessboardImpl;
import ax.ha.tdd.chess.engine.Square;
import ax.ha.tdd.chess.engine.Player;

import java.util.Objects;

public class Pawn extends ChessPieceBase implements ChessPiece{

    public Pawn(Player player, Square location) {
        super(PieceType.PAWN, player, location);
    }

    @Override
    public String getSymbol() {
        return null;
    }


    public PieceType upgradePawn(){

        return PieceType.QUEEN;
    }




    public int getDirection( int y){
        int playerDirection;
        if (player == Player.WHITE) {
            //DO NOTE, PROGRAMMERS START AT 0 NOT 1

             return playerDirection = -1;  // Forward direction for white player
        } else {

            return playerDirection = 1; // Forward direction for black player
        }
    }


    public boolean AttackEnemy(Square targetSquare, Square startSquare, Chessboard chessboard){
        ChessPiece chessPiece = chessboard.getPieceAt(startSquare);
        int startX = startSquare.getX();
        int startY = startSquare.getY();
        int targetX = targetSquare.getX();
        int targetY = targetSquare.getY();

        if(Math.abs(targetX - startX) == 1 && targetY == startY + getDirection(startY)){
            if(chessPiece != null && chessPiece.getPlayer() != chessboard.getPieceAt(targetSquare).getPlayer()){
                return  true;
            }
        }
        else{
            System.out.println("we failed the attack check in pawn");
            return false;
        }
        return false;
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
    public boolean canMove(ChessboardImpl chessboard, Square destination) {
        boolean hasMoved = false;
        int destinationX = destination.getX();
        int destinationY = destination.getY();
        int startX = location.getX();
        int startY = location.getY();
        Square pieceLocation = new Square(startX,startY);


        if(startY != 2 && getPlayer() == Player.BLACK|| startY != 6 && getPlayer() == Player.WHITE){
            hasMoved = true;
        }

        System.out.println("HELLO WE HAVE REACHED CAN MOVE");
        //these variables are for checking if the square is empty
        Square destinationLocation = new Square(destinationX, destinationY);

        checkIfSquareEmpty(destinationLocation, chessboard);
        System.out.println("start coordinates: x = " + startX + " y = " + startY);
        System.out.println("destination coordinates: x = " + destinationX + " y = " + destinationY);
        //KAN GÅ ETT OCH TVÅ STEG FRAM
        //Must also check if there is a piece in the destination coordinates


        if(destinationX == startX && destinationY == startY + getDirection(startY)){
            System.out.println("move 1 square forward");
            if(getDirection( startY) > 0 && checkIfSquareEmpty(destinationLocation, chessboard) || getDirection( startY) < 0 && checkIfSquareEmpty(destinationLocation, chessboard) ){
                System.out.println("move 1 square forward successs");
                return true;
            }
        }
        else if (destinationX == startX && destinationY == startY + 2 * getDirection(startY) && !hasMoved){
            if (getDirection( startY) > 0 && checkIfSquareEmpty(destinationLocation, chessboard)|| getDirection( startY) < 0 && checkIfSquareEmpty(destinationLocation, chessboard) ){
                return true;
            }

        }

        //We must also make sure to check if the piece we are attacking is our piece which in that case = false, or an enemy piece which would be = true
        //We must also check if a piece is actually in the destination coordinates
//        else if((destinationX == locationX + 1 || locationX == locationX - 1) && locationY == destinationY + getDirection(locationY)){
//            if(){
//                return true;
//            }
//        }

        //@todo LOGIKEN ATT ANFALLA PÄJSER BEHÖVS Å


        return false;
    }

}
