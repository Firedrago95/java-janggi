package janggi.domain;

import janggi.domain.moveStrategy.CannonMoveBehavior;
import janggi.domain.moveStrategy.KingMoveBehavior;
import janggi.domain.moveStrategy.PawnMoveBehavior;
import janggi.domain.piece.Piece;
import janggi.domain.piece.PieceType;
import janggi.domain.piece.Side;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertAll;

class PieceTest {

    @Test
    void 기물은_진영_기물타입_움직임전략을_가진다() {
        assertThatCode(() -> new Piece(Side.CHO, PieceType.KING, new KingMoveBehavior()))
            .doesNotThrowAnyException();
    }

    @Test
    void 기물이_포_인지_확인한다() {
        // given
        Piece choCannon = new Piece(Side.CHO, PieceType.CANNON, new CannonMoveBehavior());
        Piece hanPawn = new Piece(Side.HAN, PieceType.PAWN, new PawnMoveBehavior((Side.HAN)));

        // when & then
        assertAll(
            () -> assertThat(choCannon.isCannon()).isTrue(),
            () -> assertThat(hanPawn.isCannon()).isFalse()
        );
    }

    @Test
    void 적_기물을_판단한다() {
        // given
        Piece choCannon = new Piece(Side.CHO, PieceType.CANNON, new CannonMoveBehavior());

        // when & then
        assertAll(
            () -> assertThat(choCannon.isEnemy(Side.HAN)).isTrue(),
            () -> assertThat(choCannon.isEnemy(Side.CHO)).isFalse()
        );
    }
}