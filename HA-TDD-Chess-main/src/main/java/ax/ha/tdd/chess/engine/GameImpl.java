package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.ChessPieceBase;
import ax.ha.tdd.chess.engine.pieces.ChessPieceStub;
import ax.ha.tdd.chess.engine.pieces.Pawn;

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
        Pawn pawn;


        //check what piece is in start square of the move string and what player
        chessPieceStart = new ChessPieceStub(board.getPieceAt(startSquare).getPieceType(),   getPlayerToMove());


        System.out.println("Player tried to perform move with piece: " + chessPieceStart.toString());

        //check if it can be allowed to do the move in the second part of the string
        if(chessPieceStart.canMove(board, destinationSquare)){
            //if both logic checks out do the move

           //if(destinationSquare == null)

            //remove whatever piece is on that square if attack successful
//                board.removePiece(destinationSquare);

                //Remove the moving piece away from it's old position
            board.removePiece(startSquare);

            //set new location for chessPieceStart
            board.addPiece(chessPieceStart);


            //updated the game board with the moved piece
        }
        System.out.println("Player tried to perform move: " + move);
    }



    /*
    public void move(String move) {
        isNewGame = false;
        String[] moveArray = move.split("-");
        Square startSquare = new Square(moveArray[0]);
        Square destinationSquare = new Square(moveArray[1]);

        ChessPiece chessPieceStart = board.getPieceAt(startSquare);

        System.out.println("Player tried to perform move with piece: " + chessPieceStart);

        // Check if the chess piece exists and belongs to the current player
        if (chessPieceStart != null && chessPieceStart.getPlayer() == getPlayerToMove()) {
            if (chessPieceStart.canMove(destinationSquare)) {

                // Perform the move
                board.movePiece(startSquare, destinationSquare);

                System.out.println("Player performed move: " + move);
            } else {
                System.out.println("Invalid move: " + move);
            }
        } else {
            System.out.println("Invalid piece or not player's turn: " + move);
        }

     */

    }
