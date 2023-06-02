package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;


public class RookMovement implements Movement {

    @Override
    public boolean canMove(Chessboard board, Square destination) {
        /*
        Square currentLocation = getLocation();

        int startX = currentLocation.getX();
        int startY = currentLocation.getY();
        int destinationX = destination.getX();
        int destinationY = destination.getY();

        // Rooks can move horizontally or vertically
        if (startX == destinationX || startY == destinationY) {
            // Check if there are any pieces blocking the path
            int xDirection = Integer.compare(destinationX, startX);
            int yDirection = Integer.compare(destinationY, startY);

            int col = startX + xDirection;
            int row = startY + yDirection;

            while (col != destinationX || row != destinationY) {
                Square squareToCheck = new Square(col,row);

                if (board.getPieceAt(squareToCheck) != null) {
                    // Path is blocked
                    return false;
                }
                col += xDirection;
                row += yDirection;
            }

            // Check if the destination square is empty or occupied by an opponent's piece
            ChessPiece pieceAtDestination = chessboard.getPieceAt(destination);
            return pieceAtDestination == null || !pieceAtDestination.getPlayer().equals(getPlayer());
        }
        return false;
    }
    */
        return false;
    }
}
