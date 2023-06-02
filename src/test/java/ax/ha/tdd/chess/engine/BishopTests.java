package ax.ha.tdd.chess.engine;
import ax.ha.tdd.chess.console.ChessboardWriter;
import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.ChessPieceStub;
import ax.ha.tdd.chess.engine.pieces.Pawn;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BishopTests {
    @Test
    public void TestMoveDiagonallyForward(){
        Game game = new GameImpl(3);
        System.out.println(new ChessboardWriter().print(game.getBoard()));

        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("c1"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.BISHOP, piece.getPieceType());
        game.move("c1-e3");

        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }
    @Test
    public void TestMoveDiagonallyBackward(){
        Game game = new GameImpl(3);
        game.move("c1-e3");
        System.out.println(new ChessboardWriter().print(game.getBoard()));

        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("e3"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.BISHOP, piece.getPieceType());
        game.move("e3-c1");

        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }
    @Test
    public void TestMoveStraightIllegal(){
        Game game = new GameImpl(3);
        System.out.println(new ChessboardWriter().print(game.getBoard()));

        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("c1"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.BISHOP, piece.getPieceType());
        game.move("c1-c3");

        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }
    @Test
    public void TestMoveWithOwnPieceInTheWayIllegal(){
        Game game = new GameImpl(3);
        System.out.println(new ChessboardWriter().print(game.getBoard()));

        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("f1"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.BISHOP, piece.getPieceType());
        game.move("f1-d3");

        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }
    @Test
    public void TestTakeOpponentPiece(){
        Game game = new GameImpl(3);
        System.out.println(new ChessboardWriter().print(game.getBoard()));

        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("c1"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.BISHOP, piece.getPieceType());
        game.move("c1-a3");
        game.move("a3-f7");

        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }
    @Test
    public void TestTakeOwnPieceIllegal(){
        Game game = new GameImpl(3);
        System.out.println(new ChessboardWriter().print(game.getBoard()));

        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("f1"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.BISHOP, piece.getPieceType());
        game.move("f1-e2");


        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }
}
