package janggi.domain.board.initiator;

import janggi.domain.PieceSetup;
import janggi.domain.path.Position;
import janggi.domain.piece.Piece;
import janggi.domain.piece.Side;

import java.util.HashMap;
import java.util.Map;

public class BoardInitiator {

    private SetupInitiator hanSetupInitiator;
    private SetupInitiator choSetupInitiator;

    public BoardInitiator(PieceSetup hanPieceSetup, PieceSetup choPieceSetup) {
        this.hanSetupInitiator = SetupInitiatorFactory.createSetupInitiator(Side.HAN, hanPieceSetup);
        this.choSetupInitiator = SetupInitiatorFactory.createSetupInitiator(Side.CHO, choPieceSetup);
    }

    public Map<Position, Piece> generateInitialPieces() {
        Map<Position, Piece> initialPieces = new HashMap<>();
        initialPieces.putAll(hanSetupInitiator.generateInitialPieces());
        initialPieces.putAll(choSetupInitiator.generateInitialPieces());
        return initialPieces;
    }
}
