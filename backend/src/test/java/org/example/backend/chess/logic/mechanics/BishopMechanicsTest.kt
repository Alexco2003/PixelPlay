package org.example.backend.chess.logic.mechanics

import org.example.backend.chess.logic.base.Square
import org.example.backend.chess.logic.mechanics.pieces.BishopMechanics
import org.example.backend.chess.logic.position.Position
import org.example.backend.chess.logic.position.PositionGenerator
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class BishopMechanicsTest {
    private val capture = arrayOf(
        ".......K",
        "........",
        "...R....",
        "....b...",
        "...p.p..",
        "........",
        "........",
        "........"
    )

    private val initialPosition: Position = PositionGenerator.initialPosition()
    private val capturePosition: Position = PositionGenerator.customPosition(capture)

    @Test
    fun attackingIndexes() {
        val mechanics = BishopMechanics(initialPosition, Square(3, 1))
        val squares: MutableList<Square> =mechanics.attacks().toMutableList()
        squares.sort()

        val expected: MutableList<Square> = mutableListOf(
                Square(1, 3),
                Square(2, 0),
                Square(2, 2),
                Square(4, 0),
                Square(4, 2),
                Square(5, 3),
                Square(6, 4)
        )
        Assertions.assertEquals(expected, squares)
    }

    @Test
    fun movesWithCapture() {
        val mechanics = BishopMechanics(capturePosition, Square(3, 4))
        val moves: MutableList<Square> = mechanics.moves().toMutableList()
        val expected: MutableList<Square> = mutableListOf(
                Square(2, 3),
                Square(0, 7),
                Square(1, 6),
                Square(2, 5)
        )

        moves.sort()
        expected.sort()

        Assertions.assertEquals(expected, moves)
    }
}