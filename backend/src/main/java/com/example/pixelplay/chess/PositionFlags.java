package com.example.pixelplay.chess;

import java.util.HashMap;
import java.util.Map;

public class PositionFlags {
    private final Map<Flag, Boolean> flags = new HashMap<>();

    public PositionFlags() {
        flags.put(Flag.WHITE_KING_MOVED, false);
        flags.put(Flag.BLACK_KING_MOVED, false);
        flags.put(Flag.BLACK_SHORT_ROOK_MOVED, false);
        flags.put(Flag.WHITE_SHORT_ROOK_MOVED, false);
        flags.put(Flag.BLACK_LONG_ROOK_MOVED, false);
        flags.put(Flag.WHITE_LONG_ROOK_MOVED, false);
    }

    public boolean getFlag(Flag flag) {
        return flags.get(flag);
    }

    public void setFlag(Flag flag, boolean value) {
        flags.put(flag, value);
    }

    public enum Flag {
        WHITE_KING_MOVED,
        BLACK_KING_MOVED,
        WHITE_SHORT_ROOK_MOVED,
        BLACK_SHORT_ROOK_MOVED,
        BLACK_LONG_ROOK_MOVED,
        WHITE_LONG_ROOK_MOVED,
    }
}
