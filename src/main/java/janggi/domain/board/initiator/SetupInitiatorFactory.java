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
        return switch (pieceSetup) {
            case RIGHT_SETUP -> new ChoRightSetupInitiator();
            case LEFT_SETUP -> new ChoLeftSetupInitiator();
            case INNER_SETUP -> new ChoInnerSetupInitiator();
            case OUTER_SETUP -> new ChoOuterSetupInitiator();
        };
    }

    private static SetupInitiator createHanSetupInitiator(PieceSetup pieceSetup) {
        return switch (pieceSetup) {
            case RIGHT_SETUP -> new HanRightSetupInitiator();
            case LEFT_SETUP -> new HanLeftSetupInitiator();
            case INNER_SETUP -> new HanInnerSetupInitiator();
            case OUTER_SETUP -> new HanOuterSetupInitiator();
        };
    }
}
