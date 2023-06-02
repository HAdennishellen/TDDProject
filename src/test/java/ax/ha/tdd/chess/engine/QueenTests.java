package ax.ha.tdd.chess.engine;
import ax.ha.tdd.chess.console.ChessboardWriter;
import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.ChessPieceStub;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueenTests {
    @Test
    public void TestMoveDiagonallyForward(){
        Game game = new GameImpl(5);
        game.move("d1-d2");
        System.out.println(new ChessboardWriter().print(game.getBoard()));

        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("d2"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.QUEEN, piece.getPieceType());
        game.move("d2-f4");

        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }
    @Test
    public void TestMoveDiagonallyBackward(){
        Game game = new GameImpl(5);
        game.move("d1-d2");
        game.move("d2-f4");
        System.out.println(new ChessboardWriter().print(game.getBoard()));

        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("f4"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.QUEEN, piece.getPieceType());
        game.move("f4-d2");

        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }
    @Test
    public void TestMoveForward(){
        Game game = new GameImpl(5);
        System.out.println(new ChessboardWriter().print(game.getBoard()));

        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("d1"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.QUEEN, piece.getPieceType());
        game.move("d1-d5");

        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }
    @Test
    public void TestMoveBackward(){
        Game game = new GameImpl(5);
        game.move("d1-d5");
        System.out.println(new ChessboardWriter().print(game.getBoard()));

        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("d5"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.QUEEN, piece.getPieceType());
        game.move("d5-d1");

        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }
    @Test
    public void TestMoveLeft(){
        Game game = new GameImpl(5);
        System.out.println(new ChessboardWriter().print(game.getBoard()));

        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("d1"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.QUEEN, piece.getPieceType());
        game.move("d1-a1");

        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }
    @Test
    public void TestMoveRight(){
        Game game = new GameImpl(5);
        System.out.println(new ChessboardWriter().print(game.getBoard()));

        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("d1"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.QUEEN, piece.getPieceType());
        game.move("d1-f1");

        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }
    @Test
    public void TestMoveWithOwnPieceInTheWayIllegal(){
        Game game = new GameImpl(5);
        System.out.println(new ChessboardWriter().print(game.getBoard()));

        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("d1"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.QUEEN, piece.getPieceType());
        game.move("d1-f3");

        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }
    @Test
    public void TestTakeOpponentPiece(){
        Game game = new GameImpl(5);
        System.out.println(new ChessboardWriter().print(game.getBoard()));

        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("d1"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.QUEEN, piece.getPieceType());
        game.move("d1-d8");

        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }
    @Test
    public void TestTakeOwnPieceIllegal(){
        Game game = new GameImpl(5);
        System.out.println(new ChessboardWriter().print(game.getBoard()));

        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("d1"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.QUEEN, piece.getPieceType());

        game.move("d1-e2");

        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }
}
