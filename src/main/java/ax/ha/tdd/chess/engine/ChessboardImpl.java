package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.ChessPieceBase;
import ax.ha.tdd.chess.engine.pieces.ChessPieceStub;
import ax.ha.tdd.chess.engine.pieces.PieceType;

import java.util.Iterator;
import java.util.List;

public class ChessboardImpl implements Chessboard {
    // This could just as easily be replaced with a List or Set,
    // since the ChessPieces right now keep track of their own location.
    // Feel free to change this however you like
    // [y][x]
    private final ChessPiece[][] board = new ChessPieceBase[8][8];

    public static ChessboardImpl startingBoard() {
        final ChessboardImpl chessboard = new ChessboardImpl();

        chessboard.withMirroredPiece(PieceType.PAWN, List.of(0,1,2,3,4,5,6,7), 1)
                .withMirroredPiece(PieceType.ROOK, List.of(0,7), 0)
                .withMirroredPiece(PieceType.KNIGHT, List.of(1,6), 0)
                .withMirroredPiece(PieceType.BISHOP, List.of(2,5), 0)
                .withMirroredPiece(PieceType.QUEEN, List.of(3), 0)
                .withMirroredPiece(PieceType.KING, List.of(4), 0);
        return chessboard;
    }
    public static ChessboardImpl emptyStartingBoard() {
        final ChessboardImpl chessboard = new ChessboardImpl();
        return chessboard;
    }
    public static ChessboardImpl bishopTestBoard(){
        final ChessboardImpl chessboard = new ChessboardImpl();
        chessboard.withMirroredPiece(PieceType.BISHOP, List.of(2,5), 0)
                  .withMirroredPiece(PieceType.PAWN, List.of(4), 1);
        return chessboard;
    }
    public static ChessboardImpl rookTestBoard(){
        final ChessboardImpl chessboard = new ChessboardImpl();
        chessboard.withMirroredPiece(PieceType.ROOK, List.of(0,7), 0)
                .withMirroredPiece(PieceType.KING, List.of(4), 0);
        return chessboard;
    }
    public static ChessboardImpl knightTestBoard(){
        final ChessboardImpl chessboard = new ChessboardImpl();
        chessboard.withMirroredPiece(PieceType.PAWN, List.of(0,1,2,3,4,5,6,7), 1)
                .withMirroredPiece(PieceType.KNIGHT, List.of(1,6), 0);
        return chessboard;
    }
    public static ChessboardImpl queenTestBoard(){
        final ChessboardImpl chessboard = new ChessboardImpl();
        chessboard.withMirroredPiece(PieceType.PAWN, List.of(0,1,2,4,5,6,7), 1)
                .withMirroredPiece(PieceType.QUEEN, List.of(3), 0);
        return chessboard;
    }
    public static ChessboardImpl kingTestBoard(){
        final ChessboardImpl chessboard = new ChessboardImpl();
        chessboard.withMirroredPiece(PieceType.PAWN, List.of(0,1,2,3,4,5,6,7), 1)
                .withMirroredPiece(PieceType.ROOK, List.of(0,7), 0)
                .withMirroredPiece(PieceType.KNIGHT, List.of(1,6), 0)
                .withMirroredPiece(PieceType.BISHOP, List.of(2,5), 0)
                .withMirroredPiece(PieceType.QUEEN, List.of(3), 0);
        return chessboard;
    }
    public static ChessboardImpl pawnTestBoard(){
        final ChessboardImpl chessboard = new ChessboardImpl();
        chessboard.withMirroredPiece(PieceType.PAWN, List.of(0,1,2,4,5,6,7), 1);

        return chessboard;
    }



    public ChessPiece getPieceAt(final Square square) {
        return board[square.getY()][square.getX()];
    }

    public void addPiece(final ChessPiece chessPiece) {
        board[chessPiece.getLocation().getY()][chessPiece.getLocation().getX()] = chessPiece;
    }

    public void removePiece(Square square){
        int TargetX = square.getX();
        int TargetY = square.getY();

        board[TargetY][TargetX] = null;

    }

    /**
     * Helper method to initialize chessboard with {@link ChessPieceStub}.
     * Basically mirrors all added pieces for both players.
     * When all pieces have been implemented, this should be replaced with the proper implementations.
     *
     * @param pieceType pieceType
     * @param xCoordinates xCoordinates
     * @param yCoordinate yCoordinateOffset
     * @return itself, like a builder pattern
     */
    private ChessboardImpl withMirroredPiece(final PieceType pieceType,
                                             final List<Integer> xCoordinates, final int yCoordinate) {
        xCoordinates.forEach(xCoordinate -> {
            addPiece(new ChessPieceStub(pieceType, Player.BLACK, new Square(xCoordinate, yCoordinate)));
            addPiece(new ChessPieceStub(pieceType, Player.WHITE, new Square(xCoordinate, 7 - yCoordinate)));
        });
        return this;
    }

    @Override
    public Iterator<ChessPiece[]> iterator() {
        return List.of(board).iterator();
    }

    public int GetSize(){
        return board.length;

    }

}
