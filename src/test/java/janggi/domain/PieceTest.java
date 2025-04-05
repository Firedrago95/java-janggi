package janggi.domain;

import janggi.domain.moveStrategy.KingMoveBehavior;
import janggi.domain.piece.Piece;
import janggi.domain.piece.PieceType;
import janggi.domain.piece.Side;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

class PieceTest {

    @Test
    void 기물은_진영_기물타입_움직임전략을_가진다() {
        assertThatCode(() -> new Piece(Side.CHO, PieceType.KING, new KingMoveBehavior()))
            .doesNotThrowAnyException();
    }
}