package janggi.domain.moveStrategy.palace;

import janggi.ReplaceUnderBar;
import janggi.domain.path.Position;
import janggi.domain.piece.Side;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@ReplaceUnderBar
class PawnPalaceMoveBehaviorTest {

    public static Stream<Arguments> 궁성_경로를_반환한다_테스트_케이스() {
        return Stream.of(
            Arguments.of(Side.CHO, new Position(5, 2), new Position(4,1), List.of(new Position(4,1))),
            Arguments.of(Side.CHO, new Position(5, 2), new Position(6,1), List.of(new Position(6,1))),
            Arguments.of(Side.HAN, new Position(5, 8), new Position(6,9), List.of(new Position(6,9))),
            Arguments.of(Side.HAN, new Position(5, 8), new Position(4,9), List.of(new Position(4,9)))
        );
    }

    public static Stream<Arguments> 궁성에서도_진영에따라_후진_할_수_없다_테스트_케이스() {
        return Stream.of(
            Arguments.of(Side.CHO, new Position(5, 2), new Position(4,3)),
            Arguments.of(Side.CHO, new Position(5, 2), new Position(6,3)),
            Arguments.of(Side.HAN, new Position(5, 8), new Position(6,7)),
            Arguments.of(Side.HAN, new Position(5, 8), new Position(4,7))
        );
    }

    @ParameterizedTest
    @MethodSource("궁성_경로를_반환한다_테스트_케이스")
    void 궁성_경로를_반환한다(Side side, Position start, Position destination, List<Position> expected) {
        // given
        PawnPalaceMoveBehavior palaceMoveBehavior = new PawnPalaceMoveBehavior(side);

        // when
        List<Position> path = palaceMoveBehavior.getPath(start, destination);

        // then
        assertThat(path).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("궁성에서도_진영에따라_후진_할_수_없다_테스트_케이스")
    void 궁성에서도_진영에따라_후진_할_수_없다(Side side, Position start, Position destination) {
        // given
        PawnPalaceMoveBehavior palaceMoveBehavior = new PawnPalaceMoveBehavior(side);

        // when
        assertThatIllegalArgumentException()
            .isThrownBy(() -> palaceMoveBehavior.getPath(start, destination))
            .withMessage("졸은 뒤로 이동 할 수 없습니다.");
    }
}