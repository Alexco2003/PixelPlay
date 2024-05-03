package com.example.pixelplay.chess.mechanics;

import com.example.pixelplay.chess.base.Piece;
import com.example.pixelplay.chess.base.PieceType;
import com.example.pixelplay.chess.position.Position;
import com.example.pixelplay.chess.base.Square;
import com.example.pixelplay.chess.mechanics.pieces.*;

public class PieceMechanicsFactory {
    private PieceMechanicsFactory() {}

    public static PieceMechanics getPieceMechanics(Piece piece) {
        Position position = piece.position();
        Square square = piece.square();
        return switch (piece.type()) {
            case PieceType.BlackKing, PieceType.WhiteKing -> new KingMechanics(position, square);
            case PieceType.BlackBishop, PieceType.WhiteBishop -> new BishopMechanics(position, square);
            case PieceType.BlackKnight, PieceType.WhiteKnight -> new KnightMechanics(position, square);
            case PieceType.BlackPawn -> new BlackPawnMechanics(position, square);
            case PieceType.BlackQueen, PieceType.WhiteQueen -> new QueenMechanics(position, square);
            case PieceType.BlackRook, PieceType.WhiteRook -> new RookMechanics(position, square);
            case PieceType.WhitePawn -> new WhitePawnMechanics(position, square);
            default -> new EmptyMechanics(position, square);
        };
    }
}
