package janggi.domain.board.initiator;

import janggi.domain.Position;
import janggi.domain.piece.Piece;

import java.util.Map;

public interface SetupInitiator {

    Map<Position, Piece> generateInitialPieces();
}
