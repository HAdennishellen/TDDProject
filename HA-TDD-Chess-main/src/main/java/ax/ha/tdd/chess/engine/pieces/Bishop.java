package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.ChessboardImpl;
import ax.ha.tdd.chess.engine.Square;
import ax.ha.tdd.chess.engine.Player;

public class Bishop extends ChessPieceBase implements ChessPiece{

    public Bishop(Player player, Square location) {
        super(PieceType.BISHOP, player, location);
    }

    public boolean AttackEnemy(Square targetSquare, Square startSquare, Chessboard chessboard){
//        ChessPiece chessPiece = chessboard.getPieceAt(startSquare);
//        int startX = startSquare.getX();
//        int startY = startSquare.getY();
//        int targetX = targetSquare.getX();
//        int targetY = targetSquare.getY();
//
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
        int col =  startY;

        if(startX != destinationX && startY != destinationY){
            int rowOffset, colOffset;
            if(startX < destinationX ){
                rowOffset = 1;
            }else{
                rowOffset = -1;
            }

            if(startY < destinationY){
                colOffset = 1;
            }else{
                colOffset = -1;
            }

            while(row != destinationX && col != destinationY){

                if(!checkIfSquareEmpty(new Square(row, col), chessboard)){
                    if(chessboard.getPieceAt(new Square(row, col)) != null && chessboard.getPieceAt(new Square(row, col)).getPlayer() != chessboard.getPieceAt(new Square(row, col)).getPlayer()){
                        return true;
                    }else {
                        return false;
                    }

                }

                if(startY > startY + colOffset ){
                    col--;
                }
                if(startY < startY + colOffset) {
                    col++;
                }
            }

        }
        //check if the path is blocked
        //while/for något något

        //check if enemy on target square
            //if enemy do attack
            //remove piece/addpiece


        return false;
    }
}