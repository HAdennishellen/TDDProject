package ax.ha.tdd.chess.engine;
import ax.ha.tdd.chess.console.ChessboardWriter;
import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.ChessPieceStub;
import ax.ha.tdd.chess.engine.pieces.Pawn;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RookTests {

    @Test
    public void TestMoveForward(){
        Game game = new GameImpl(2);
        System.out.println(new ChessboardWriter().print(game.getBoard()));

        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("a1"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.ROOK, piece.getPieceType());
        game.move("a1-a5");

        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }
    @Test
    public void TestMoveBackward(){
        Game game = new GameImpl(2);
        game.move("a1-a5");
        System.out.println(new ChessboardWriter().print(game.getBoard()));
        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("a5"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.ROOK, piece.getPieceType());
        game.move("a5-a1");

        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }
    @Test
    public void TestMoveLeft(){
        Game game = new GameImpl(2);
        System.out.println(new ChessboardWriter().print(game.getBoard()));

        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("h1"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.ROOK, piece.getPieceType());
        game.move("h1-e1");

        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }
    @Test
    public void TestMoveRight(){
        Game game = new GameImpl(2);
        game.move("h1-e1");
        System.out.println(new ChessboardWriter().print(game.getBoard()));

        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("e1"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.ROOK, piece.getPieceType());
        game.move("e1-h1");

        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }
    @Test
    public void TestMoveDiagonalIllegal(){
        Game game = new GameImpl(2);
        System.out.println(new ChessboardWriter().print(game.getBoard()));

        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("a1"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.ROOK, piece.getPieceType());
        game.move("a1-b2");

        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }
    @Test
    public void TestMoveWithOwnPieceInTheWayIllegal(){
        Game game = new GameImpl(2);
        System.out.println(new ChessboardWriter().print(game.getBoard()));

        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("a1"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.ROOK, piece.getPieceType());
        game.move("a1-f1");

        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }
    @Test
    public void TestTakeOpponentPiece(){
        Game game = new GameImpl(2);
        System.out.println(new ChessboardWriter().print(game.getBoard()));

        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("a1"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.ROOK, piece.getPieceType());
        game.move("a1-a8");

        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }
    @Test
    public void TestTakeOwnPieceIllegal(){
        Game game = new GameImpl(2);
        System.out.println(new ChessboardWriter().print(game.getBoard()));

        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("a1"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.ROOK, piece.getPieceType());
        game.move("a1-e1");

        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }
    @Test
    public void TestCastlingIllegal(){
        Game game = new GameImpl();
        System.out.println(new ChessboardWriter().print(game.getBoard()));

        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("a1"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.ROOK, piece.getPieceType());
        game.move("a1-e1");

        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }
    @Test
    public void TestCastlingLegal(){
        Game game = new GameImpl(2);
        System.out.println(new ChessboardWriter().print(game.getBoard()));

        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("a1"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.ROOK, piece.getPieceType());
        game.move("a1-e1");

        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }

}
