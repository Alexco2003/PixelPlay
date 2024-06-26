package org.example.backend.chess.logic.moving.generator;

import org.example.backend.chess.logic.base.Move;
import org.example.backend.chess.logic.base.Square;
import org.example.backend.chess.logic.moving.MoveGenerator;
import org.example.backend.chess.logic.position.Position;
import org.example.backend.chess.logic.position.PositionGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LongRangeMoveGeneratorTest {
    private final Position position = PositionGenerator.customPosition(
            new String[] {
                    "..k.....",
                    "........",
                    "...b....",
                    ".p.R....",
                    "...K....",
                    "........",
                    "........",
                    "........",
            }
    );

    @Test
    public void getLegalMoves() {
        Square square = new Square(3, 3);
        MoveGenerator moveGenerator = new LongRangeMoveGenerator(position, square);

        List<Move> moves = moveGenerator.getLegalMoves();
        List<Move> expected = new ArrayList<>(List.of(
                new Move(square, new Square(2,3 )),
                new Move(square, new Square(3,1 )),
                new Move(square, new Square(3,2 )),
                new Move(square, new Square(3,4 )),
                new Move(square, new Square(3,5 )),
                new Move(square, new Square(3,6 )),
                new Move(square, new Square(3,7 ))
        ));

        Collections.sort(moves);
        Collections.sort(expected);

        assertEquals(expected, moves);
    }

}