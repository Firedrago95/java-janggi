package janggi.view;

import janggi.domain.path.Position;
import janggi.domain.board.Board;
import janggi.domain.piece.Piece;
import janggi.domain.piece.Side;

import java.util.Map;

public class OutputView {

    private static final String RED = "\u001B[31m";
    private static final String BLUE = "\u001B[34m";
    private static final String GRAY = "\u001B[37m";
    private static final String EXIT = "\u001B[0m";

    public static void printBoard(Board board) {
        Map<Position, Piece> pieces = board.getPieces();
        for (int y = 10; y > 0; y--) {
            if (y == 10) {
                System.out.print(y + " ");
            } else {
                System.out.print(y + "  ");
            }
            for (int x = 1; x < 10; x++) {
                Position position = new Position(x, y);
                Piece piece = pieces.get(position);
                System.out.print(convertPrintFormat(piece) + " ");
            }
            System.out.println();
        }
        System.out.println("   1ㅤ2ㅤ3ㅤ4  5ㅤ6ㅤ7ㅤ8ㅤ9");
    }

    public static void printWinner(Side turn) {
        System.out.println(convertPrintFormat(turn) + " 승리");
    }

    private static String convertPrintFormat(Piece piece) {
        if (piece == null) {
            return String.format(GRAY + "ㅁ" + EXIT);
        }

        String color = piece.getSide() == Side.CHO ? BLUE : RED;
        return switch (piece.getPieceType()) {
            case CANNON -> String.format(color + "포" + EXIT);
            case ELEPHANT -> String.format(color + "상" + EXIT);
            case GUARD -> String.format(color + "사" + EXIT);
            case KING -> String.format(color + "왕" + EXIT);
            case KNIGHT -> String.format(color + "마" + EXIT);
            case PAWN -> String.format(color + "졸" + EXIT);
            case ROOK -> String.format(color + "차" + EXIT);
        };
    }

    private static String convertPrintFormat(Side turn) {
        if (turn == Side.CHO) {
            return "초나라";
        }
        return "한나라";
    }
}
