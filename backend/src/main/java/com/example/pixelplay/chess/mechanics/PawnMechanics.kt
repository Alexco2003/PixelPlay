package com.example.pixelplay.chess.mechanics

import com.example.pixelplay.chess.Position

abstract class PawnMechanics(protected val position: Position, @JvmField protected val index: Byte) : PieceMechanics {
    protected val isOnLeftEdge: Boolean
        get() = index% 8 == 0

    protected val isOnRightEdge: Boolean
        get() = (index- 7) % 8 == 0
}
