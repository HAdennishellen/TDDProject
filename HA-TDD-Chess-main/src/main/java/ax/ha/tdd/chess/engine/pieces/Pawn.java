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




    public int getDirection(int x, int y){
        int playerDirection;
        if (player == Player.WHITE) {
            //DO NOTE, PROGRAMMERS START AT 0 NOT 1
            if(y == 1){
               return playerDirection = 2;
            }
             return playerDirection = 1;  // Forward direction for white player
        } else {
            if(y == 6){
                return playerDirection = -2;
            }
            return playerDirection = -1; // Forward direction for black player
        }
    }


//    public boolean AttackEnemy(Square targetSquare, Chessboard chessboard){
//        ChessPiece chessPiece = chessboard.getPieceAt(targetSquare);
//
//        if(chessPiece != null && chessPiece.getPlayer() !=)
//    }
    public boolean checkIfSquareEmpty(Square target, ChessboardImpl chessboard){
        final ChessPiece chessPiece;
        chessPiece = chessboard.getPieceAt(target);

        System.out.println(chessPiece.toString());

        if(chessPiece == null){
            return true;
        }
        else return false;
    }


    @Override
    public boolean canMove(ChessboardImpl chessboard, Square destination) {
        
        int destinationX = destination.getX();
        int destinationY = destination.getY();
        int locationX = location.getX();
        int locationY = location.getY();
        Square pieceLocation = new Square(locationX,locationY);



        //these variables are for checking if the square is empty
        Square destinationLocation = new Square(destinationX, destinationY);

        checkIfSquareEmpty(destinationLocation, chessboard);

        

        //KAN GÅ ETT OCH TVÅ STEG FRAM
        //Must also check if there is a piece in the destination coordinates
        if(destinationX == locationX && destinationY == locationY + getDirection(locationX, locationY)){
            if(getDirection(locationX, locationY) == 1 && checkIfSquareEmpty(destinationLocation, chessboard)){
                return true;
            }
        }
        else if (destinationX == locationX && destinationY == locationY + 2 * getDirection(locationX, locationY)){
            if (getDirection(locationX, locationY) == 2){
                return true;
            }

        }

        //We must also make sure to check if the piece we are attacking is our piece which in that case = false, or an enemy piece which would be = true
        //We must also check if a piece is actually in the destination coordinates
        else if((destinationX == locationX + 1 || locationX == locationX - 1) && locationY == destinationY + getDirection(locationX, locationY)){
            return true;
        }



        //@todo LOGIKEN ATT ANFALLA PÄJSER BEHÖVS Å



        return false;
    }

    /*

        if(player.equals(Player.WHITE)){
            if(y == 8){
                upgradePawn();
            } else if () {

            }
        }
        else if(player.equals(Player.BLACK)){
            if(y == 1){
                upgradePawn();
            }

        }
        return false;
     */
}
