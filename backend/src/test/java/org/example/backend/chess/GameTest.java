package org.example.backend.chess;

import org.example.backend.chess.logic.Game;
import org.example.backend.chess.logic.base.*;
import org.example.backend.chess.logic.position.Position;
import org.example.backend.chess.logic.position.PositionGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private static final Game game = new Game();

    @Test
    void makeMove() {
        Move pawnMove = new Move(new Square(1, 3), new Square(3, 3));
        Piece knight = game.getPosition().getPiece(pawnMove.start());
        game.makeMove(pawnMove);

        assertEquals(knight, game.getPosition().getPiece(pawnMove.end()));
        assertEquals(PieceType.None, game.getPosition().getPiece(pawnMove.start()).type());
    }

    @Test
    void makeFirstMove_black() {
        Game game = new Game();
        Move pawnMove = new Move(new Square(6, 3), new Square(5, 3));

        assertThrows(RuntimeException.class, () -> game.makeMove(pawnMove));
    }

    @Test
    void makeMove_twoWhiteMoves() {
        Game game = new Game();
        Move pawnMove = new Move(new Square(1, 3), new Square(2, 3));
        Move knightMove = new Move(new Square(0, 1), new Square(2, 2));

        game.makeMove(pawnMove);
        assertThrows(RuntimeException.class, () -> game.makeMove(knightMove));
    }

    @Test
    void makeMove_shortCastle() {
        Position position = PositionGenerator.customPosition(stringPosition, Color.BLACK);
        Game game = new Game(position);

        Move shortCastle = new Move(new Square(7, 4), new Square(7, 6));
        game.makeMove(shortCastle);

        assertEquals(PieceType.King, position.getPiece(new Square(7, 6)).type());
        assertEquals(PieceType.Rook, position.getPiece(new Square(7, 5)).type());
    }

    private final static String[] stringPosition = new String[]{
            "........",
            "PPPPPP.p",
            "........",
            "p.......",
            "........",
            "........",
            ".ppppppp",
            "r...k..r"
    };


    private final Position promotionPosition = PositionGenerator.customPosition(
            new String[]{
                    "........",
                    ".....k.K",
                    "........",
                    "........",
                    "........",
                    "........",
                    ".P......",
                    "..r.....",
            }
    );

    @Test
    void move_promoteToBishop() {
        Game game = new Game(promotionPosition);
        Square start = new Square(6, 1);
        Square end = new Square(7, 2);
        Move move = new Move(start, end, PieceType.Bishop);
        game.makeMove(move);
        assertEquals(PieceType.Bishop, game.getPosition().getPiece(end).type());
    }

    private final Position enPassantPosition = PositionGenerator.customPosition(
            new String[]{
                    "...K....",
                    "PPPPPPPP",
                    "........",
                    "..p.....",
                    "........",
                    "........",
                    "........",
                    ".....k.."
            }
    );

    @Test
    void move_enPassant() {
        Game game = new Game(enPassantPosition);
        Move whitePawnJump = new Move(new Square(1, 3), new Square(3, 3));
        Move blackEnPassant = new Move(new Square(3, 2), new Square(2, 3));

        game.makeMove(whitePawnJump);
        game.makeMove(blackEnPassant);

        assertEquals(PieceType.Pawn, game.getPosition().getPiece(new Square(2, 3)).type());
        assertEquals(PieceType.None, game.getPosition().getPiece(new Square(3, 3)).type());
    }
}