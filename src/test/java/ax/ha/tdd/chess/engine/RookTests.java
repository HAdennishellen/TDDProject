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
        ChessPiece piece2 = game.getBoard().getPieceAt(new Square("a5"));
        assertEquals(Player.WHITE, piece2.getPlayer());
        assertEquals(PieceType.ROOK, piece2.getPieceType());
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
        ChessPiece piece2 = game.getBoard().getPieceAt(new Square("a1"));
        assertEquals(Player.WHITE, piece2.getPlayer());
        assertEquals(PieceType.ROOK, piece2.getPieceType());

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
        game.move("h1-f1");
        ChessPiece piece2 = game.getBoard().getPieceAt(new Square("f1"));
        assertEquals(Player.WHITE, piece2.getPlayer());
        assertEquals(PieceType.ROOK, piece2.getPieceType());

        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }
    @Test
    public void TestMoveRight(){
        Game game = new GameImpl(2);
        game.move("h1-f1");
        System.out.println(new ChessboardWriter().print(game.getBoard()));

        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("f1"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.ROOK, piece.getPieceType());
        game.move("f1-h1");
        ChessPiece piece2 = game.getBoard().getPieceAt(new Square("h1"));
        assertEquals(Player.WHITE, piece2.getPlayer());
        assertEquals(PieceType.ROOK, piece2.getPieceType());

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
        ChessPiece piece2 = game.getBoard().getPieceAt(new Square("a1"));
        assertEquals(Player.WHITE, piece2.getPlayer());
        assertEquals(PieceType.ROOK, piece2.getPieceType());

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
        ChessPiece piece2 = game.getBoard().getPieceAt(new Square("a1"));
        assertEquals(Player.WHITE, piece2.getPlayer());
        assertEquals(PieceType.ROOK, piece2.getPieceType());


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
        ChessPiece piece2 = game.getBoard().getPieceAt(new Square("a8"));
        assertEquals(Player.WHITE, piece2.getPlayer());
        assertEquals(PieceType.ROOK, piece2.getPieceType());

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
        ChessPiece piece2 = game.getBoard().getPieceAt(new Square("a1"));
        assertEquals(Player.WHITE, piece2.getPlayer());
        assertEquals(PieceType.ROOK, piece2.getPieceType());

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
        ChessPiece piece2 = game.getBoard().getPieceAt(new Square("a1"));
        assertEquals(Player.WHITE, piece2.getPlayer());
        assertEquals(PieceType.ROOK, piece2.getPieceType());
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

        game.move("a1-c1");
        ChessPiece piece2 = game.getBoard().getPieceAt(new Square("c1"));
        assertEquals(Player.WHITE, piece2.getPlayer());
        assertEquals(PieceType.ROOK, piece2.getPieceType());


        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }

}
