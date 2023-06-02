package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.ChessboardImpl;
import ax.ha.tdd.chess.engine.Square;
import ax.ha.tdd.chess.engine.Player;

public class Queen extends ChessPieceBase implements ChessPiece{

    public Queen(Player player, Square location) {
        super(PieceType.QUEEN, player, location);
    }

    @Override
    public String getSymbol() {
        return null;
    }

    public boolean moveTypeCheckDiagonal(Square destination) {

        int startX = location.getX();
        int startY = location.getY();
        int destinationX = destination.getX();
        int destinationY = destination.getY();

        if(startX != destinationX && startY != destinationY){
            return true;
        }
        return false;
    }

    public boolean checkIfSquareEmpty(Square targetSquare, ChessboardImpl chessboard){
        final ChessPiece chessPiece;
        chessPiece = chessboard.getPieceAt(targetSquare);

        if(chessPiece == null){
            return true;
        }
        else return false;
    }

    @Override
    public boolean canMove(ChessboardImpl chessboard, Square destination) {

        int destinationX = destination.getX();
        int destinationY = destination.getY();
        int startX = location.getX();
        int startY = location.getY();
        //USE THIS TO DETERMINE MOVE TYPE

        boolean diagonalMove = moveTypeCheckDiagonal(destination);

            if (diagonalMove == false) {
                //do rook logic
                if (startX == destinationX || startY == destinationY) {
                    // Check if there are any pieces blocking the path
                    int xDirection = Integer.compare(destinationX, startX);
                    int yDirection = Integer.compare(destinationY, startY);

                    int col = startX + xDirection;
                    int row = startY + yDirection;

                    while (col != destinationX || row != destinationY) {
                        Square squareToCheck = new Square(col, row);

                        if (chessboard.getPieceAt(squareToCheck) != null) {
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
            }

            if (diagonalMove == true) {
                //do bishop logic
                int row = startX;
                int col = startY;

                if (startX != destinationX && startY != destinationY) {
                    int rowOffset, colOffset;
                    if (startX < destinationX) {
                        rowOffset = 1;
                    } else {
                        rowOffset = -1;
                    }
                    if (startY < destinationY) {
                        colOffset = 1;
                    } else {
                        colOffset = -1;
                    }
                    while (row != destinationX && col != destinationY) {
                        if (!checkIfSquareEmpty(new Square(row + rowOffset, col + colOffset), chessboard)) {

                            if (chessboard.getPieceAt(new Square(row + rowOffset, col + colOffset)) != null && chessboard.getPieceAt(new Square(row + rowOffset, col + colOffset)).getPlayer() == Player.WHITE) {

                                return false;
                            }
                            return true;

                        }
                        if (startY > startY + colOffset) {
                            col--;
                        }
                        if (startY < startY + colOffset) {
                            col++;
                        }
                        if (startX > startX + rowOffset) {
                            row--;
                        }
                        if (startX < startX + rowOffset) {
                            row++;
                        }
                        if (row == destinationX && col == destinationY) {
                            return true;
                        }
                    }
                }
                return false;
            }
//        }
        return false;
    }
}