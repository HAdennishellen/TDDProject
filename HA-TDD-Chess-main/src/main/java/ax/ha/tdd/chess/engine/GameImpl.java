package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.*;

import javax.print.attribute.standard.Destination;

public class GameImpl implements Game {

    final ChessboardImpl board = ChessboardImpl.startingBoard();

    //Feel free to delete this stuff. Just for initial testing.
    boolean isNewGame = true;

    @Override
    public Player getPlayerToMove() {
        //TODO this should reflect the current state.
        return Player.WHITE;
    }

    @Override
    public Chessboard getBoard() {
        return board;
    }

    @Override
    public String getLastMoveResult() {
        //TODO this should be used to show the player what happened
        //Illegal move, correct move, e2 moved to e4 etc. up to you!
        if (isNewGame) {
            return "Game hasn't begun";
        }
        return "Last move was successful (default reply, change this)";
    }

    @Override
    public void move(String move) {
        //TODO this should trigger your move logic.
        isNewGame = false;
        ChessPieceBase chessPieceStart;
        String[] moveArray = move.split("-");
        Square startSquare = new Square(moveArray[0]);
        Square destinationSquare = new Square(moveArray[1]);

        //check what piece is in start square of the move string and what player
        chessPieceStart = new ChessPieceStub(board.getPieceAt(startSquare).getPieceType(), getPlayerToMove());

        System.out.println("Player tried to perform move with piece: " + chessPieceStart.toString());

        System.out.println("The piece was" + chessPieceStart.getPieceType());

        switch (chessPieceStart.getPieceType()) {
            case PAWN:
                System.out.println("Entering case PAWN in GAME IMLP");
                Pawn pawnCase = new Pawn(getPlayerToMove(), startSquare);
                    if(pawnCase.canMove(board, destinationSquare)){

                    System.out.println("WE SURPASSED THE CANMOVE CHECK HOORAY");
                    board.addPiece(new ChessPieceStub(chessPieceStart.getPieceType(), getPlayerToMove(), destinationSquare));

                    board.removePiece(startSquare);
                    System.out.println("The old square is:" + startSquare.toString());
                }else {
                        System.out.println("We failed the if check");
                    }
                //set new location for the chesspiece that moved
                //remove it from it's old one
                break;
            case BISHOP:
                // code block
                break;
            default:
                // code block
        }
    }
}
