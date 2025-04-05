package janggi.domain.board.initiator;

import janggi.domain.PieceSetup;
import janggi.domain.piece.Side;

public class SetupInitiatorFactory {

    public static SetupInitiator createSetupInitiator(Side side, PieceSetup pieceSetup) {
        if (side == Side.CHO) {
            return createChoSetupInitiator(pieceSetup);
        }
        return createHanSetupInitiator(pieceSetup);
    }

    private static SetupInitiator createChoSetupInitiator(PieceSetup pieceSetup) {
        if (pieceSetup == PieceSetup.RIGHT_SETUP) {
            return new ChoRightSetupInitiator();
        }
        if (pieceSetup == PieceSetup.LEFT_SETUP) {
            return new ChoLeftSetupInitiator();
        }
        if (pieceSetup == PieceSetup.INNER_SETUP) {
            return new ChoInnerSetupInitiator();
        }
        return new ChoOuterSetupInitiator();
    }

    private static SetupInitiator createHanSetupInitiator(PieceSetup pieceSetup) {
        if (pieceSetup == PieceSetup.RIGHT_SETUP) {
            return new HanRightSetupInitiator();
        }
        if (pieceSetup == PieceSetup.LEFT_SETUP) {
            return new HanLeftSetupInitiator();
        }
        if (pieceSetup == PieceSetup.INNER_SETUP) {
            return new HanInnerSetupInitiator();
        }
        return new HanOuterSetupInitiator();
    }
}
