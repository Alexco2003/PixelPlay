package com.example.pixelplay.chess.mechanics

import com.example.pixelplay.chess.position.PositionGenerator
import com.example.pixelplay.chess.position.Position
import com.example.pixelplay.chess.base.Square
import com.example.pixelplay.chess.mechanics.pieces.KnightMechanics
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class KnightMechanicsTest {
    private val initialPosition: Position = PositionGenerator.initialPosition()
    private val capturePosition: Position = PositionGenerator.customPosition(capture)

    @BeforeEach
    fun setUp() {
    }

    @Test
    fun attackingIndexesEdge() {
        val mechanics = KnightMechanics(initialPosition, Square(0, 1))
        val squares: MutableList<Square> = mechanics.attacks().toMutableList()
        squares.sort()
        val indexes = squares.map { obj: Square -> obj.getIndex() }.toList()
        Assertions.assertEquals(indexes, listOf(11, 16, 18))
    }

    @Test
    fun attackingIndexesCenter() {
        val mechanics = KnightMechanics(initialPosition, Square(3, 3))
        val squares: MutableList<Square> = mechanics.attacks().toMutableList()
        squares.sort()
        Assertions.assertEquals(squares, listOf(10, 12, 17, 21, 33, 37, 42, 44))
    }

    @Test
    fun moveWithCaptures() {

        val mechanics = KnightMechanics(capturePosition, Square(0, 3))
        val moves: MutableList<Square> = mechanics.moves().toMutableList()
        moves.sort()

        val expected: MutableList<Square> = mutableListOf(
                Square(1, 1),
                Square(1, 5)
        )
        expected.sort()
        Assertions.assertEquals(expected, moves)
    }

    companion object {
        private val capture = arrayOf(
            "...h....",
            ".....Q..",
            "..p.p...",
            "........",
            "........",
            "........",
            "........",
            "........"
        )
    }

}