package ax.ha.tdd.chess.engine;


public class BishopMovement implements Movement {



    @Override
    public boolean canMove(Chessboard chess ,Square destination) {
//        int destinationX = destination.getX();
//        int destinationY = destination.getY();
//        int startX = location.getX();
//        int startY = location.getY();
//
//        int row = startX;
//        int col = startY;
//
//        if (startX != destinationX && startY != destinationY) {
//            int rowOffset, colOffset;
//            if (startX < destinationX) {
//                rowOffset = 1;
//            } else {
//                rowOffset = -1;
//            }
//            if (startY < destinationY) {
//                colOffset = 1;
//            } else {
//                colOffset = -1;
//            }
//
//            while (row != destinationX && col != destinationY) {
//
//                if (!checkIfSquareEmpty(new Square(row + rowOffset, col + colOffset), chessboard)) {
//
//                    if (chessboard.getPieceAt(new Square(row + rowOffset, col + colOffset)) != null && chessboard.getPieceAt(new Square(row + rowOffset, col + colOffset)).getPlayer() == Player.WHITE) {
//                        return false;
//                    }
//                    return true;
//                }
//
//                if (startY > startY + colOffset) {
//                    col--;
//                }
//                if (startY < startY + colOffset) {
//                    col++;
//                }
//                if (startX > startX + rowOffset) {
//                    row--;
//                }
//                if (startX < startX + rowOffset) {
//                    row++;
//                }
//
//                if (row == destinationX && col == destinationY) {
//                    return true;
//                }
//            }
//        }
        return false;
    }
}

