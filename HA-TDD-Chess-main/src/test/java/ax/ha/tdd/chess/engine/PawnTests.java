package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.console.ChessboardWriter;
import ax.ha.tdd.chess.engine.pieces.ChessPiece;
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

        game.move("e4-e5");

        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("e5"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.PAWN, piece.getPieceType());

        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }
    //@TODO more tests
    @Test
    public void testMoveOneSquareForwardInOccupiedSquareShouldBeIllegal(){
        Game game = new GameImpl();

        game.move("e4-e5");

        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("e5"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.PAWN, piece.getPieceType());

        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }
    //@TODO more tests
    @Test
    public void testTakeOpponentPiece(){
        Game game = new GameImpl();

        game.move("e4-f5");

        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("f5"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.PAWN, piece.getPieceType());

        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }

    @Test
    public void PawnUpgradeIntoQueen(){

        assertEquals(1,1);
    }
}
