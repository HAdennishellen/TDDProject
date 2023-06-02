package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.ChessboardImpl;
import ax.ha.tdd.chess.engine.Square;
import ax.ha.tdd.chess.engine.Player;

public class Knight extends ChessPieceBase implements ChessPiece{

    public Knight(Player player, Square location) {
        super(PieceType.KNIGHT, player, location);
    }

    @Override
    public String getSymbol() {
        return null;
    }

    @Override
    public boolean canMove(ChessboardImpl chessboard, Square destination) {

        int deltaX = Math.abs(destination.getX() - getLocation().getX());
        int deltaY = Math.abs(destination.getY() - getLocation().getY());


        if(chessboard.getPieceAt(destination) != null) {
            if (chessboard.getPieceAt(destination).getPlayer().equals(player)) {
                return false;
            }
        }
        // Check if the move is "L" shape for the knight
        return (deltaX == 2 && deltaY == 1) || (deltaX == 1 && deltaY == 2);
    }
}
