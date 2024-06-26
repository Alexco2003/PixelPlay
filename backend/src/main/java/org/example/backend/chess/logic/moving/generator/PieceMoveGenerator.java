package org.example.backend.chess.logic.moving.generator;

import org.example.backend.chess.logic.base.Move;
import org.example.backend.chess.logic.moving.MoveGenerator;
import org.example.backend.chess.logic.position.Position;
import org.example.backend.chess.logic.base.Square;

import java.util.List;

public class PieceMoveGenerator implements MoveGenerator {
    private final Position position;
    private final Square square;

    public PieceMoveGenerator(Position position, Square square) {
        this.position = position;
        this.square = square;
    }


    @Override
    public List<Move> getLegalMoves() {
        MoveGenerator generator = getGenerator();
        return generator.getLegalMoves();
    }

    private MoveGenerator getGenerator() {
        return switch (position.getPiece(square).type()) {
            case Pawn -> new PawnMoveGenerator(position, square);
            case Knight -> new KnightMoveGenerator(position, square);
            case Bishop, Rook, Queen -> new LongRangeMoveGenerator(position, square);
            case King -> new KingMoveGenerator(position, square);
            case None -> new EmptyMoveGenerator();
        };
    }
}
