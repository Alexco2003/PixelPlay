package com.example.pixelplay.chess.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Position {
    private final Piece[][] board = new Piece[8][8];
    private Color turn = Color.WHITE;

    public Position(PieceType[][] board, boolean castlingFlags) {
        setBoard(board);
    }


    public PieceType getPieceType(Square square) {
        return board[square.getRank()][square.getFile()].type;
    }
    public Piece getPiece(Square square) {
        return board[square.getRank()][square.getFile()];
    }
    public Color getPieceColor(Square square) {
        return getPieceType(square).color();
    }

    public boolean isFree(Square square) {
        return board[square.getRank()][square.getFile()].type == PieceType.None;
    }

    private boolean checkBoardSize(PieceType[][] board) {
        if (board.length != 8) {
            return false;
        }
        for(int i = 0; i < 8; i++) {
            if(board[i].length != 8) {
                return false;
            }
        }
        return true;
    }

    private void setBoard(PieceType[][] board) {
        if(!checkBoardSize(board)) {
            throw new IllegalArgumentException("Board is not valid");
        }

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                PieceType type = board[i][j];
                this.board[i][j] = createPiece(type, i, j);
            }
        }
    }

    private Piece createPiece(PieceType type, int rank, int file) {
        return new Piece(type, this, new Square(rank, file));
    }

    public Square findKing(Color color) {
        PieceType king;
        if(color == Color.WHITE) {
            king = PieceType.WhiteKing;
        }
        else {
            king = PieceType.BlackKing;
        }

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(board[i][j].type == king) {
                    return new Square(i, j);
                }
            }
        }
        return null;
    }

    private void setPiece(Square square, Piece piece) {
        board[square.getRank()][square.getFile()] = piece;
    }

    public void makeMove(Move move) {
        Piece piece = getPiece(move.start);
        setPiece(move.end, piece);
        setPiece(move.start, new Piece(PieceType.None, this, move.start));
        turn = turn.reverse();
    }

    public Color getTurn() {
        return turn;
    }
}
