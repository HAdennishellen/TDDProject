package ax.ha.tdd.chess.engine;
import ax.ha.tdd.chess.console.ChessboardWriter;
import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.ChessPieceStub;
import ax.ha.tdd.chess.engine.pieces.Pawn;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class KnightTests {

    @Test
    public void TestMoveForward(){
        Game game = new GameImpl(4);
        System.out.println(new ChessboardWriter().print(game.getBoard()));

        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("b1"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.KNIGHT, piece.getPieceType());
        game.move("b1-c3");

        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }
    @Test
    public void TestMoveBackwards(){
        Game game = new GameImpl(4);
        game.move("b1-c3");

        System.out.println(new ChessboardWriter().print(game.getBoard()));

        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("c3"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.KNIGHT, piece.getPieceType());
        game.move("c3-b1");

        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }
    @Test
    public void TestTakeOwnPieceIllegal(){
        Game game = new GameImpl(4);
        game.move("b1-c3");
        System.out.println(new ChessboardWriter().print(game.getBoard()));

        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("c3"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.KNIGHT, piece.getPieceType());
        game.move("c3-e2");

        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }
    @Test
    public void TestJumpOverPieceOneSquareAround(){
        Game game = new GameImpl(4);
        System.out.println(new ChessboardWriter().print(game.getBoard()));

        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("b1"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.KNIGHT, piece.getPieceType());
        game.move("b1-c3");

        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }
    @Test
    public void TestTakeOpponentPiece(){
        Game game = new GameImpl(4);
        game.move("b1-c3");
        game.move("c3-d5");
        System.out.println(new ChessboardWriter().print(game.getBoard()));

        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("d5"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.KNIGHT, piece.getPieceType());
        game.move("d5-e7");

        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }


}
