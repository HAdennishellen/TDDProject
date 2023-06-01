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

        System.out.println(boardSize);


        for (int row = 0; row < boardSize; row++) {

            for (int col = 0; col < boardSize; col++) {

                Square currentSquare = new Square(row, col);


                // Check if the current piece exists and belongs to the opponent
                if (chessboard.getPieceAt(currentSquare) != null && chessboard.getPieceAt(currentSquare).getPlayer() != currentPlayer) {

                    ChessPieceStub currentPiece = new ChessPieceStub(chessboard.getPieceAt(currentSquare).getPieceType(),chessboard.getPieceAt(currentSquare).getPlayer(),currentSquare);

                    System.out.println(currentPiece.getPlayer());
                    System.out.println(currentPiece.getPieceType());


                    switch (currentPiece.getPieceType()) {
                        case ROOK:
                            System.out.println("Entering case rook in GAME check4check");
                            Rook rookCase = new Rook((currentPiece.getPlayer()), currentSquare);
                            if (rookCase.canMove(chessboard, HypotheticalKingSquare)) {
                                return true; // The king is in check
                            }
                            break;
                        case QUEEN:
                            System.out.println("Entering case rook in GAME check4check");
                            Queen queenCase = new Queen((currentPiece.getPlayer()), currentSquare);
                            if (queenCase.canMove(chessboard, HypotheticalKingSquare)) {
                                return true; // The king is in check
                            }
                            break;
                        case KNIGHT:
                            System.out.println("Entering case rook in GAME check4check");
                            Knight knightCase = new Knight((currentPiece.getPlayer()), currentSquare);
                            if (knightCase.canMove(chessboard, HypotheticalKingSquare)) {
                                return true; // The king is in check
                            }
                            break;
                        case PAWN:
                            System.out.println("Entering case rook in GAME check4check");
                            Pawn pawnCase = new Pawn((currentPiece.getPlayer()), currentSquare);
                            if (pawnCase.canMove(chessboard, HypotheticalKingSquare)) {
                                return true; // The king is in check
                            }
                            break;
                        case BISHOP:
                            System.out.println("Entering case rook in GAME check4check");
                            Bishop bishopCase = new Bishop((currentPiece.getPlayer()), currentSquare);
                            if (bishopCase.canMove(chessboard, HypotheticalKingSquare)) {
                                return true; // The king is in check
                            }
                            break;
                        case KING:
                            System.out.println("Entering case rook in GAME check4check");
                            King kingCase = new King((currentPiece.getPlayer()), currentSquare);
                            if (kingCase.canMove(chessboard, HypotheticalKingSquare)) {
                                return true; // The king is in check
                            }
                            break;
                        default:
                            return false;
                    }
                }
            }
        }
        return false; // The king is not in check
    }
}


