package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.ChessboardImpl;
import ax.ha.tdd.chess.engine.Square;
import ax.ha.tdd.chess.engine.Player;

/**
 *  Stub class in order to output a correct chessfield.
 *  This class should be deleted after implementations are done.
 */
public class ChessPieceStub extends ChessPieceBase {
    private final PieceType pieceType;

    public ChessPieceStub(final PieceType symbol, final Player player) {
        this(symbol, player, new Square(0,0));
    }

    public ChessPieceStub(final PieceType symbol,
                          final Player player,
                          final Square location) {
        super(symbol, player, location);
        this.pieceType = symbol;
    }

    @Override
    public String getSymbol() {
        return pieceType.getSymbol();
    }


    @Override
    public boolean canMove(ChessboardImpl chessboard, Square destination) {

        switch(pieceType) {
            case PAWN:
                System.out.println("entering case pawn");
                Pawn pawnCase = new Pawn(player,location);
                if (pawnCase.canMove(chessboard,destination)){
                    return true;
                }
                break;
            case BISHOP:
                // code block
                break;
            default:
                // code block
        }
        return false;
        //throw new UnsupportedOperationException("canMove has/will not be implemented in stub class");
    }
}
