package com.example.pixelplay.chess.base;

import com.example.pixelplay.chess.mechanics.PieceMechanics;
import com.example.pixelplay.chess.mechanics.PieceMechanicsFactory;

import java.util.List;

public final class Piece {
    public final PieceType type;
    public final PieceMechanics mechanics;
    private final Position position;
    private final Square square;

    public Piece(PieceType type, Position position, Square square) {
        this.type = type;
        this.mechanics = PieceMechanicsFactory.getPieceMechanics(type);
        this.position = position;
        this.square = square;
    }
}
