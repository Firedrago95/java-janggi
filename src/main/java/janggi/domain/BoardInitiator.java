package janggi.domain;

import janggi.domain.moveStrategy.CannonMoveBehavior;
import janggi.domain.moveStrategy.ElephantMoveBehavior;
import janggi.domain.moveStrategy.GuardMoveBehavior;
import janggi.domain.moveStrategy.KingMoveBehavior;
import janggi.domain.moveStrategy.KnightMoveBehavior;
import janggi.domain.moveStrategy.PawnMoveBehavior;
import janggi.domain.moveStrategy.RookMoveBehavior;
import janggi.domain.piece.Piece;
import janggi.domain.piece.PieceType;
import janggi.domain.piece.Side;

import java.util.HashMap;
import java.util.Map;

public class BoardInitiator {


    public Map<Position, Piece> generateInitialPieces(PieceSetup hanPieceSetup, PieceSetup choPieceSetup) {
        Map<Position, Piece> fixedInitialPieces = generateFixedInitialPieces();
        addHanSetupPieces(hanPieceSetup, fixedInitialPieces);
        addChoSetupPieces(choPieceSetup, fixedInitialPieces);
        return fixedInitialPieces;
    }

    private void addHanSetupPieces(PieceSetup hanPieceSetup, Map<Position, Piece> fixedInitialPieces) {
        if (hanPieceSetup == PieceSetup.LEFT_SETUP) {
            fixedInitialPieces.putAll(generateHanLeftSetupPieces());
            return;
        }
        if (hanPieceSetup == PieceSetup.RIGHT_SETUP) {
            fixedInitialPieces.putAll(generateHanRightSetupPiece());
            return;
        }
        if (hanPieceSetup == PieceSetup.INNER_SETUP) {
            fixedInitialPieces.putAll(generateHanInnerSetupPiece());
            return;
        }
        fixedInitialPieces.putAll(generateHanOuterSetupPiece());
    }

    private void addChoSetupPieces(PieceSetup choPieceSetup, Map<Position, Piece> fixedInitialPieces) {
        if (choPieceSetup == PieceSetup.LEFT_SETUP) {
            fixedInitialPieces.putAll(generateChoLeftSetupPieces());
            return;
        }
        if (choPieceSetup == PieceSetup.RIGHT_SETUP) {
            fixedInitialPieces.putAll(generateChoRightSetupPiece());
            return;
        }
        if (choPieceSetup == PieceSetup.INNER_SETUP) {
            fixedInitialPieces.putAll(generateChoInnerSetupPiece());
            return;
        }
        fixedInitialPieces.putAll(generateChoOuterSetupPiece());
    }

    private Map<Position, Piece> generateFixedInitialPieces() {
        Map<Position, Piece> fixedPieces = new HashMap<>();
        fixedPieces.put(new Position(1, 10), new Piece(Side.CHO, PieceType.ROOK, new RookMoveBehavior()));
        fixedPieces.put(new Position(4, 10), new Piece(Side.CHO, PieceType.GUARD, new GuardMoveBehavior()));
        fixedPieces.put(new Position(6, 10), new Piece(Side.CHO, PieceType.GUARD, new GuardMoveBehavior()));
        fixedPieces.put(new Position(9, 10), new Piece(Side.CHO, PieceType.ROOK, new RookMoveBehavior()));
        fixedPieces.put(new Position(5, 9), new Piece(Side.CHO, PieceType.KING, new KnightMoveBehavior()));
        fixedPieces.put(new Position(2, 8), new Piece(Side.CHO, PieceType.CANNON, new CannonMoveBehavior()));
        fixedPieces.put(new Position(8, 8), new Piece(Side.CHO, PieceType.CANNON, new CannonMoveBehavior()));
        fixedPieces.put(new Position(1, 7), new Piece(Side.CHO, PieceType.PAWN, new PawnMoveBehavior()));
        fixedPieces.put(new Position(3, 7), new Piece(Side.CHO, PieceType.PAWN, new PawnMoveBehavior()));
        fixedPieces.put(new Position(5, 7), new Piece(Side.CHO, PieceType.PAWN, new PawnMoveBehavior()));
        fixedPieces.put(new Position(7, 7), new Piece(Side.CHO, PieceType.PAWN, new PawnMoveBehavior()));
        fixedPieces.put(new Position(9, 7), new Piece(Side.CHO, PieceType.PAWN, new PawnMoveBehavior()));

        fixedPieces.put(new Position(1, 1), new Piece(Side.HAN, PieceType.ROOK, new RookMoveBehavior()));
        fixedPieces.put(new Position(4, 1), new Piece(Side.HAN, PieceType.GUARD, new GuardMoveBehavior()));
        fixedPieces.put(new Position(6, 1), new Piece(Side.HAN, PieceType.GUARD, new GuardMoveBehavior()));
        fixedPieces.put(new Position(9, 1), new Piece(Side.HAN, PieceType.ROOK, new RookMoveBehavior()));
        fixedPieces.put(new Position(5, 2), new Piece(Side.HAN, PieceType.KING, new KingMoveBehavior()));
        fixedPieces.put(new Position(2, 3), new Piece(Side.HAN, PieceType.CANNON, new CannonMoveBehavior()));
        fixedPieces.put(new Position(8, 3), new Piece(Side.HAN, PieceType.CANNON, new CannonMoveBehavior()));
        fixedPieces.put(new Position(1, 4), new Piece(Side.HAN, PieceType.PAWN, new PawnMoveBehavior()));
        fixedPieces.put(new Position(3, 4), new Piece(Side.HAN, PieceType.PAWN, new PawnMoveBehavior()));
        fixedPieces.put(new Position(5, 4), new Piece(Side.HAN, PieceType.PAWN, new PawnMoveBehavior()));
        fixedPieces.put(new Position(7, 4), new Piece(Side.HAN, PieceType.PAWN, new PawnMoveBehavior()));
        fixedPieces.put(new Position(9, 4), new Piece(Side.HAN, PieceType.PAWN, new PawnMoveBehavior()));
        return fixedPieces;
    }

    private Map<Position, Piece> generateHanLeftSetupPieces() {
        Map<Position, Piece> hanLeftSetup = new HashMap<>();
        hanLeftSetup.put(new Position(2, 1), new Piece(Side.HAN, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        hanLeftSetup.put(new Position(3, 1), new Piece(Side.HAN, PieceType.KNIGHT, new KnightMoveBehavior()));
        hanLeftSetup.put(new Position(7, 1), new Piece(Side.HAN, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        hanLeftSetup.put(new Position(8, 1), new Piece(Side.HAN, PieceType.KNIGHT, new KnightMoveBehavior()));
        return hanLeftSetup;
    }

    private Map<Position, Piece> generateHanRightSetupPiece() {
        Map<Position, Piece> hanLeftSetup = new HashMap<>();
        hanLeftSetup.put(new Position(2, 1), new Piece(Side.HAN, PieceType.KNIGHT, new KnightMoveBehavior()));
        hanLeftSetup.put(new Position(3, 1), new Piece(Side.HAN, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        hanLeftSetup.put(new Position(7, 1), new Piece(Side.HAN, PieceType.KNIGHT, new KnightMoveBehavior()));
        hanLeftSetup.put(new Position(8, 1), new Piece(Side.HAN, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        return hanLeftSetup;
    }

    private Map<Position, Piece> generateHanOuterSetupPiece() {
        Map<Position, Piece> hanLeftSetup = new HashMap<>();
        hanLeftSetup.put(new Position(2, 1), new Piece(Side.HAN, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        hanLeftSetup.put(new Position(3, 1), new Piece(Side.HAN, PieceType.KNIGHT, new KnightMoveBehavior()));
        hanLeftSetup.put(new Position(7, 1), new Piece(Side.HAN, PieceType.KNIGHT, new KnightMoveBehavior()));
        hanLeftSetup.put(new Position(8, 1), new Piece(Side.HAN, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        return hanLeftSetup;
    }

    private Map<Position, Piece> generateHanInnerSetupPiece() {
        Map<Position, Piece> hanLeftSetup = new HashMap<>();
        hanLeftSetup.put(new Position(2, 1), new Piece(Side.HAN, PieceType.KNIGHT, new KnightMoveBehavior()));
        hanLeftSetup.put(new Position(3, 1), new Piece(Side.HAN, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        hanLeftSetup.put(new Position(7, 1), new Piece(Side.HAN, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        hanLeftSetup.put(new Position(8, 1), new Piece(Side.HAN, PieceType.KNIGHT, new KnightMoveBehavior()));
        return hanLeftSetup;
    }

    private Map<Position, Piece> generateChoLeftSetupPieces() {
        Map<Position, Piece> choLeftSetup = new HashMap<>();
        choLeftSetup.put(new Position(2, 10), new Piece(Side.CHO, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        choLeftSetup.put(new Position(3, 10), new Piece(Side.CHO, PieceType.KNIGHT, new KnightMoveBehavior()));
        choLeftSetup.put(new Position(7, 10), new Piece(Side.CHO, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        choLeftSetup.put(new Position(8, 10), new Piece(Side.CHO, PieceType.KNIGHT, new KnightMoveBehavior()));
        return choLeftSetup;
    }

    private Map<Position, Piece> generateChoRightSetupPiece() {
        Map<Position, Piece> choRightSetup = new HashMap<>();
        choRightSetup.put(new Position(2, 10), new Piece(Side.CHO, PieceType.KNIGHT, new KnightMoveBehavior()));
        choRightSetup.put(new Position(3, 10), new Piece(Side.CHO, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        choRightSetup.put(new Position(7, 10), new Piece(Side.CHO, PieceType.KNIGHT, new KnightMoveBehavior()));
        choRightSetup.put(new Position(8, 10), new Piece(Side.CHO, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        return choRightSetup;
    }

    private Map<Position, Piece> generateChoOuterSetupPiece() {
        Map<Position, Piece> choOuterSetup = new HashMap<>();
        choOuterSetup.put(new Position(2, 10), new Piece(Side.CHO, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        choOuterSetup.put(new Position(3, 10), new Piece(Side.CHO, PieceType.KNIGHT, new KnightMoveBehavior()));
        choOuterSetup.put(new Position(7, 10), new Piece(Side.CHO, PieceType.KNIGHT, new KnightMoveBehavior()));
        choOuterSetup.put(new Position(8, 10), new Piece(Side.CHO, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        return choOuterSetup;
    }

    private Map<Position, Piece> generateChoInnerSetupPiece() {
        Map<Position, Piece> choInnerSetup = new HashMap<>();
        choInnerSetup.put(new Position(2, 10), new Piece(Side.CHO, PieceType.KNIGHT, new KnightMoveBehavior()));
        choInnerSetup.put(new Position(3, 10), new Piece(Side.CHO, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        choInnerSetup.put(new Position(7, 10), new Piece(Side.CHO, PieceType.ELEPHANT, new ElephantMoveBehavior()));
        choInnerSetup.put(new Position(8, 10), new Piece(Side.CHO, PieceType.KNIGHT, new KnightMoveBehavior()));
        return choInnerSetup;
    }
}
