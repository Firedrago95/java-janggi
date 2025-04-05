package janggi.domain.board;

import janggi.ReplaceUnderBar;
import janggi.domain.PieceSetup;
import janggi.domain.board.initiator.ChoInnerSetupInitiator;
import janggi.domain.board.initiator.ChoLeftSetupInitiator;
import janggi.domain.board.initiator.ChoOuterSetupInitiator;
import janggi.domain.board.initiator.ChoRightSetupInitiator;
import janggi.domain.board.initiator.HanInnerSetupInitiator;
import janggi.domain.board.initiator.HanLeftSetupInitiator;
import janggi.domain.board.initiator.HanOuterSetupInitiator;
import janggi.domain.board.initiator.HanRightSetupInitiator;
import janggi.domain.board.initiator.SetupInitiator;
import janggi.domain.board.initiator.SetupInitiatorFactory;
import janggi.domain.piece.Side;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@ReplaceUnderBar
class SetupInitiatorFactoryTest {

    public static Stream<Arguments> 셋업별_상차림_구현체를_반환한다_테스트_케이스() {
        return Stream.of(
            Arguments.of(Side.CHO, PieceSetup.LEFT_SETUP, new ChoLeftSetupInitiator()),
            Arguments.of(Side.CHO, PieceSetup.RIGHT_SETUP, new ChoRightSetupInitiator()),
            Arguments.of(Side.CHO, PieceSetup.OUTER_SETUP, new ChoOuterSetupInitiator()),
            Arguments.of(Side.CHO, PieceSetup.INNER_SETUP, new ChoInnerSetupInitiator()),

            Arguments.of(Side.HAN, PieceSetup.LEFT_SETUP, new HanLeftSetupInitiator()),
            Arguments.of(Side.HAN, PieceSetup.RIGHT_SETUP, new HanRightSetupInitiator()),
            Arguments.of(Side.HAN, PieceSetup.OUTER_SETUP, new HanOuterSetupInitiator()),
            Arguments.of(Side.HAN, PieceSetup.INNER_SETUP, new HanInnerSetupInitiator())
        );
    }

    @ParameterizedTest
    @MethodSource("셋업별_상차림_구현체를_반환한다_테스트_케이스")
    void 셋업별_상차림_구현체를_반환한다(
        Side side,
        PieceSetup pieceSetup,
        SetupInitiator createdSetupInitiator) {
        assertThat(SetupInitiatorFactory.createSetupInitiator(side, pieceSetup))
            .isEqualTo(createdSetupInitiator);
    }
}