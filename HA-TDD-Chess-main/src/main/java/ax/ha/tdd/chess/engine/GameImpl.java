package ax.ha.tdd.chess.engine;

public class GameImpl implements Game{

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
