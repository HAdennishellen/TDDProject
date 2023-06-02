package ax.ha.tdd.chess.engine;
import ax.ha.tdd.chess.console.ChessboardWriter;
import ax.ha.tdd.chess.engine.pieces.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KingTests {
    @Test
    public void TestMoveDiagonallyForward(){

        //do the test variant of using can move directly from the piece
        //creating an empty chessboard directly form chessboardImpl instead of from gameImpl
        ChessboardImpl board = ChessboardImpl.emptyStartingBoard();
        King king = new King(Player.WHITE, new Square("e1"));
        board.addPiece(new ChessPieceStub(PieceType.KING, Player.WHITE, new Square("e1")));
        System.out.println(new ChessboardWriter().print(board));

        assertEquals(Player.WHITE, board.getPieceAt(new Square("e1")).getPlayer());
        ChessPiece piece = board.getPieceAt(new Square("e1"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.KING, piece.getPieceType());
        assertTrue(king.canMove(board, new Square("f2")));
        System.out.println(new ChessboardWriter().print(board));
    }
    @Test
    public void TestMoveForward(){

        //do the test variant of using can move directly from the piece
        //creating an empty chessboard directly form chessboardImpl instead of from gameImpl
        ChessboardImpl board = ChessboardImpl.emptyStartingBoard();
        King king = new King(Player.WHITE, new Square("e1"));
        board.addPiece(new ChessPieceStub(PieceType.KING, Player.WHITE, new Square("e1")));
        System.out.println(new ChessboardWriter().print(board));

        assertEquals(Player.WHITE, board.getPieceAt(new Square("e1")).getPlayer());
        ChessPiece piece = board.getPieceAt(new Square("e1"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.KING, piece.getPieceType());
        assertTrue(king.canMove(board, new Square("e2")));
        System.out.println(new ChessboardWriter().print(board));
    }
    @Test
    public void TestMoveDiagonallyBackward(){

        //do the test variant of using can move directly from the piece
        //creating an empty chessboard directly form chessboardImpl instead of from gameImpl
        ChessboardImpl board = ChessboardImpl.emptyStartingBoard();
        King king = new King(Player.WHITE, new Square("e2"));
        board.addPiece(new ChessPieceStub(PieceType.KING, Player.WHITE, new Square("e2")));
        System.out.println(new ChessboardWriter().print(board));

        assertEquals(Player.WHITE, board.getPieceAt(new Square("e2")).getPlayer());
        ChessPiece piece = board.getPieceAt(new Square("e2"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.KING, piece.getPieceType());
        assertTrue(king.canMove(board, new Square("f1")));
        System.out.println(new ChessboardWriter().print(board));
    }
    @Test
    public void TestMoveBackward(){

        //do the test variant of using can move directly from the piece
        //creating an empty chessboard directly form chessboardImpl instead of from gameImpl
        ChessboardImpl board = ChessboardImpl.emptyStartingBoard();
        King king = new King(Player.WHITE, new Square("e2"));
        board.addPiece(new ChessPieceStub(PieceType.KING, Player.WHITE, new Square("e2")));
        System.out.println(new ChessboardWriter().print(board));

        assertEquals(Player.WHITE, board.getPieceAt(new Square("e2")).getPlayer());
        ChessPiece piece = board.getPieceAt(new Square("e2"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.KING, piece.getPieceType());
        assertTrue(king.canMove(board, new Square("e1")));
        System.out.println(new ChessboardWriter().print(board));
    }
    @Test
    public void TestMoveRight(){

        //do the test variant of using can move directly from the piece
        //creating an empty chessboard directly form chessboardImpl instead of from gameImpl
        ChessboardImpl board = ChessboardImpl.emptyStartingBoard();
        King king = new King(Player.WHITE, new Square("e1"));
        board.addPiece(new ChessPieceStub(PieceType.KING, Player.WHITE, new Square("e1")));
        System.out.println(new ChessboardWriter().print(board));

        assertEquals(Player.WHITE, board.getPieceAt(new Square("e1")).getPlayer());
        ChessPiece piece = board.getPieceAt(new Square("e1"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.KING, piece.getPieceType());
        assertTrue(king.canMove(board, new Square("f1")));

        System.out.println(new ChessboardWriter().print(board));
    }
    @Test
    public void TestMoveLeft(){

        //do the test variant of using can move directly from the piece
        //creating an empty chessboard directly form chessboardImpl instead of from gameImpl
        ChessboardImpl board = ChessboardImpl.emptyStartingBoard();
        King king = new King(Player.WHITE, new Square("e1"));
        board.addPiece(new ChessPieceStub(PieceType.KING, Player.WHITE, new Square("e1")));
        System.out.println(new ChessboardWriter().print(board));

        assertEquals(Player.WHITE, board.getPieceAt(new Square("e1")).getPlayer());
        ChessPiece piece = board.getPieceAt(new Square("e1"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.KING, piece.getPieceType());
        assertTrue(king.canMove(board, new Square("d1")));
        System.out.println(new ChessboardWriter().print(board));
    }
    @Test
    public void TestMoveMoreThanOneSquareIllegal(){

        //do the test variant of using can move directly from the piece
        //creating an empty chessboard directly form chessboardImpl instead of from gameImpl
        ChessboardImpl board = ChessboardImpl.emptyStartingBoard();
        King king = new King(Player.WHITE, new Square("e1"));
        board.addPiece(new ChessPieceStub(PieceType.KING, Player.WHITE, new Square("e1")));
        System.out.println(new ChessboardWriter().print(board) +"\n");

        assertEquals(Player.WHITE, board.getPieceAt(new Square("e1")).getPlayer());
        ChessPiece piece = board.getPieceAt(new Square("e1"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.KING, piece.getPieceType());
        assertFalse(king.canMove(board, new Square("e3")));
        System.out.println(new ChessboardWriter().print(board));
    }
    @Test
    public void TestTestTakeOwnPieceIllegal(){

        //do the test variant of using can move directly from the piece
        //creating an empty chessboard directly form chessboardImpl instead of from gameImpl
        ChessboardImpl board = ChessboardImpl.emptyStartingBoard();
        King king = new King(Player.WHITE, new Square("e1"));
        board.addPiece(new ChessPieceStub(PieceType.KING, Player.WHITE, new Square("e1")));
        board.addPiece(new ChessPieceStub(PieceType.PAWN, Player.WHITE, new Square("e2")));
        System.out.println(new ChessboardWriter().print(board)+"\n");

        assertEquals(Player.WHITE, board.getPieceAt(new Square("e1")).getPlayer());
        ChessPiece piece = board.getPieceAt(new Square("e1"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.KING, piece.getPieceType());
        assertFalse(king.canMove(board, new Square("e2")));
        System.out.println(new ChessboardWriter().print(board));
    }
    @Test
    public void TestTakeOpponentPiece(){

        //do the test variant of using can move directly from the piece
        //creating an empty chessboard directly form chessboardImpl instead of from gameImpl
        ChessboardImpl board = ChessboardImpl.emptyStartingBoard();
        King king = new King(Player.WHITE, new Square("e1"));
        board.addPiece(new ChessPieceStub(PieceType.KING, Player.WHITE, new Square("e1")));
        board.addPiece(new ChessPieceStub(PieceType.PAWN, Player.BLACK, new Square("e2")));
        System.out.println(new ChessboardWriter().print(board)+"\n");

        assertEquals(Player.WHITE, board.getPieceAt(new Square("e1")).getPlayer());
        ChessPiece piece = board.getPieceAt(new Square("e1"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.KING, piece.getPieceType());
        assertTrue(king.canMove(board, new Square("e2")));
        System.out.println(new ChessboardWriter().print(board));
    }
    @Test
    public void TestInCheck(){

        //do the test variant of using can move directly from the piece
        //creating an empty chessboard directly form chessboardImpl instead of from gameImpl
        ChessboardImpl board = ChessboardImpl.emptyStartingBoard();
        King king = new King(Player.WHITE, new Square("e1"));
        board.addPiece(new ChessPieceStub(PieceType.KING, Player.WHITE, new Square("e1")));
        board.addPiece(new ChessPieceStub(PieceType.ROOK, Player.BLACK, new Square("f3")));
        System.out.println(new ChessboardWriter().print(board)+"\n");

        assertEquals(Player.WHITE, board.getPieceAt(new Square("e1")).getPlayer());
        ChessPiece piece = board.getPieceAt(new Square("e1"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.KING, piece.getPieceType());

        assertFalse(king.canMove(board, new Square("f1")));
        System.out.println(new ChessboardWriter().print(board));
    }
    @Test
    public void TestCheckMate(){

        //do the test variant of using can move directly from the piece
        //creating an empty chessboard directly form chessboardImpl instead of from gameImpl
        ChessboardImpl board = ChessboardImpl.emptyStartingBoard();
        King king = new King(Player.WHITE, new Square("e1"));
        board.addPiece(new ChessPieceStub(PieceType.KING, Player.WHITE, new Square("e1")));
        board.addPiece(new ChessPieceStub(PieceType.ROOK, Player.BLACK, new Square("e3")));
        board.addPiece(new ChessPieceStub(PieceType.ROOK, Player.BLACK, new Square("f4")));
        board.addPiece(new ChessPieceStub(PieceType.QUEEN, Player.BLACK, new Square("d3")));

        assertEquals(Player.WHITE, board.getPieceAt(new Square("e1")).getPlayer());
        ChessPiece piece = board.getPieceAt(new Square("e1"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.KING, piece.getPieceType());
        assertFalse(king.canMove(board, new Square("f1")));
    }
    @Test
    public void TestCheckCastlingLegal(){

        //do the test variant of using can move directly from the piece
        //creating an empty chessboard directly form chessboardImpl instead of from gameImpl
        ChessboardImpl board = ChessboardImpl.emptyStartingBoard();
        King king = new King(Player.WHITE, new Square("e1"));
        board.addPiece(new ChessPieceStub(PieceType.KING, Player.WHITE, new Square("e1")));
        board.addPiece(new ChessPieceStub(PieceType.ROOK, Player.WHITE, new Square("a1")));
        board.addPiece(new ChessPieceStub(PieceType.ROOK, Player.WHITE, new Square("h1")));

        assertEquals(Player.WHITE, board.getPieceAt(new Square("e1")).getPlayer());
        ChessPiece piece = board.getPieceAt(new Square("e1"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.KING, piece.getPieceType());
        assertTrue(king.canMove(board, new Square("a1")));
    }
    /*
    @Test
    public void TestCheckCastlingIllegal(){

        //do the test variant of using can move directly from the piece
        //creating an empty chessboard directly form chessboardImpl instead of from gameImpl
        ChessboardImpl board = ChessboardImpl.kingTestBoard();
        King king = new King(Player.WHITE, new Square("e1"));
        board.addPiece(new ChessPieceStub(PieceType.KING, Player.WHITE, new Square("e1")));

        assertEquals(Player.WHITE, board.getPieceAt(new Square("e1")).getPlayer());
        ChessPiece piece = board.getPieceAt(new Square("e1"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.KING, piece.getPieceType());
        assertFalse(king.canMove(board, new Square("a1")));
    }

     */




}
