package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.console.ChessboardWriter;
import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.ChessPieceStub;
import ax.ha.tdd.chess.engine.pieces.Pawn;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTests {

    //If you use exceptions for your illegal moves, change this test to expect an exception instead.
    @Test
    public void testMoveMoreThanTwoSquaresAtStartShouldBeIllegal(){
        //Arrange
        Game game = new GameImpl();

        //Act
        game.move("e2-e5"); //if you use real chess notation in your implementation, use simply "e5"

        //Assert
        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("e2"));

        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.PAWN, piece.getPieceType());


        //For debugging, you can print the board to console, or if you want
        //to implement a command line interface for the game
        System.out.println(new ChessboardWriter().print(game.getBoard()));

    }
    //@TODO more tests
    @Test
    public void testMoveOneSquareForwardInEmptySquareShouldBeLegal(){
        Game game = new GameImpl();

        System.out.println(new ChessboardWriter().print(game.getBoard()));

        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("e2"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.PAWN, piece.getPieceType());
        game.move("e2-e3");

        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }
    //@TODO more tests
    @Test
    public void testMoveTwoSquaresForwardFromStartEmptySquaresShouldBeLegal(){
        Game game = new GameImpl();

        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("e2"));

        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.PAWN, piece.getPieceType());
        game.move("e2-e4");

        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }

    @Test
    public void testMoveTwoSquaresForwardFromMiddleEmptySquaresShouldBeIllegal(){
        Game game = new GameImpl();
        game.move("e2-e3");
        System.out.println(new ChessboardWriter().print(game.getBoard()));
        game.move("e3-e5");


        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("e3"));
        ChessPiece piece2 = game.getBoard().getPieceAt(new Square("e3"));
        assertEquals(Player.WHITE, piece2.getPlayer());
        assertEquals(PieceType.PAWN, piece2.getPieceType());

        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }



    @Test
    public void testMoveForwardIntoOccupiedSquareShouldBeIllegal(){
        Game game = new GameImpl();
        game.move("e2-e4");
        game.move("e4-e5");
        game.move("e5-e6");
        System.out.println(new ChessboardWriter().print(game.getBoard()));

        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("e6"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.PAWN, piece.getPieceType());
        game.move("e6-e7");

        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }


    //@TODO more tests
    @Test
    public void testTakeOpponentPiece(){
        Game game = new GameImpl();

        game.move("e2-e4");
        game.move("e4-e5");
        game.move("e5-e6");
        System.out.println(new ChessboardWriter().print(game.getBoard()));


        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("e6"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.PAWN, piece.getPieceType());
        game.move("e6-f7");
        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }
    @Test
    public void testCanNotTakeOwnPiece(){
        Game game = new GameImpl();
        game.move("f2-f3");
        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("f3"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.PAWN, piece.getPieceType());
        game.move("e2-f3");
        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }
    @Test
    public void testCanNotMoveBackwards(){
        Game game = new GameImpl();
        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("e2"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.PAWN, piece.getPieceType());
        game.move("e2-e1");
        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }

    @Test
    public void PawnUpgradeIntoQueen(){
        Game game = new GameImpl();

        game.getBoard().removePiece(new Square("d7"));
        game.getBoard().removePiece(new Square("d8"));

        game.move("d2-d4");
        game.move("d4-d5");
        game.move("d5-d6");
        game.move("d6-d7");
        System.out.println(new ChessboardWriter().print(game.getBoard()));
        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("d7"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.PAWN, piece.getPieceType());
        game.move("d7-d8");
        piece = game.getBoard().getPieceAt(new Square("d8"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.QUEEN, piece.getPieceType());

        System.out.println(new ChessboardWriter().print(game.getBoard()));

    }
}
