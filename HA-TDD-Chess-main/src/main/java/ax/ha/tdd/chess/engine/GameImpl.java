package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.*;

public class GameImpl implements Game {

    ChessboardImpl board;

    //Feel free to delete this stuff, Just for initial testing.
    boolean isNewGame = true;

    public GameImpl(){
        board = ChessboardImpl.startingBoard();
    }

    //We use this constructor to set up appropriate testing boards
    public GameImpl(int value) {

        if(value == 2){
            board = ChessboardImpl.rookTestBoard();
        }
        else if(value == 3){
            board = ChessboardImpl.bishopTestBoard();
        }
        else if(value == 4){
            board = ChessboardImpl.knightTestBoard();
        }
        else if (value == 5) {
            board = ChessboardImpl.queenTestBoard();
        }
        else if(value == 6){
            board = ChessboardImpl.kingTestBoard();
        }
        else if (value == 7) {
            board = ChessboardImpl.pawnTestBoard();
        }
    }

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
                Pawn pawnCase = new Pawn(getPlayerToMove(), startSquare);
                    if(pawnCase.canMove(board, destinationSquare)){

                        board.addPiece(new ChessPieceStub(chessPieceStart.getPieceType(), getPlayerToMove(), destinationSquare));

                        board.removePiece(startSquare);
                        System.out.println("The old square is:" + startSquare.toString());
                        if(destinationSquare.getY() > 6){
                            board.removePiece(destinationSquare);
                            board.addPiece(new ChessPieceStub(PieceType.QUEEN, Player.BLACK, destinationSquare));

                        } else if (destinationSquare.getY() < 1) {
                            board.removePiece(destinationSquare);
                            board.addPiece(new ChessPieceStub(PieceType.QUEEN, Player.WHITE, destinationSquare));
                        }
                    }
                    if(pawnCase.AttackEnemy(destinationSquare,startSquare,board)){

                        board.removePiece(startSquare);
                        board.removePiece(destinationSquare);
                        board.addPiece(new ChessPieceStub(chessPieceStart.getPieceType(), getPlayerToMove(), destinationSquare));

                    }
                break;
            case ROOK:
                Rook rookCase = new Rook(getPlayerToMove(), startSquare);

                if(rookCase.canMove(board,destinationSquare)){
                    board.removePiece(startSquare);
                    board.addPiece(new ChessPieceStub(chessPieceStart.getPieceType(),getPlayerToMove(),destinationSquare));
                }
                break;
            case BISHOP:
                Bishop bishopCase = new Bishop(getPlayerToMove(), startSquare);

                if(bishopCase.canMove(board,destinationSquare)){


                    board.removePiece(startSquare);
                    board.addPiece(new ChessPieceStub(chessPieceStart.getPieceType(),getPlayerToMove(),destinationSquare));
                }
                break;
            case QUEEN:
                Queen queenCase = new Queen(getPlayerToMove(), startSquare);

                if(queenCase.canMove(board,destinationSquare)){
                    board.removePiece(startSquare);
                    board.addPiece(new ChessPieceStub(chessPieceStart.getPieceType(),getPlayerToMove(),destinationSquare));
                }
                break;
            case KNIGHT:
                Knight knightCase = new Knight(getPlayerToMove(), startSquare);

                if(knightCase.canMove(board,destinationSquare)){
                    board.removePiece(startSquare);
                    board.addPiece(new ChessPieceStub(chessPieceStart.getPieceType(),getPlayerToMove(),destinationSquare));
                }
                // code block
                break;
            case KING:
                King kingCase = new King(getPlayerToMove(), startSquare);

                if(kingCase.canMove(board,destinationSquare)){
                    board.removePiece(startSquare);
                    board.addPiece(new ChessPieceStub(chessPieceStart.getPieceType(),getPlayerToMove(),destinationSquare));
                }
                break;
            default:
                //here we should update the player to play etc. etc. if the move logic passed
        }
    }
}
