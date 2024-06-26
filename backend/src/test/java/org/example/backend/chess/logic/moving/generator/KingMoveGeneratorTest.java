package org.example.backend.chess.logic.moving.generator;

import org.example.backend.chess.logic.base.Move;
import org.example.backend.chess.logic.base.Square;
import org.example.backend.chess.logic.position.Position;
import org.example.backend.chess.logic.position.PositionGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KingMoveGeneratorTest {
    private final Position position = PositionGenerator.customPosition(
            new String[] {
                    "R...K..R",
                    "PPPPPhPP",
                    "........",
                    "........",
                    "........",
                    "........",
                    "....k...",
                    "........",
            }
    );

    @Test
    public void getLegalMoves() {
        Square start = new Square(0, 4);
        KingMoveGenerator kingMoveGenerator = new KingMoveGenerator(position, start);
        ArrayList<Move> moves = (ArrayList<Move>) kingMoveGenerator.getLegalMoves();


        ArrayList<Move> expected = new ArrayList<>(List.of(
                new Move(start, new Square(0, 5)),
                new Move(start, new Square(0, 6)),
                new Move(start, new Square(1, 5))
        ));

        Collections.sort(moves);
        Collections.sort(expected);

        assertArrayEquals(expected.toArray(), moves.toArray());
    }



}