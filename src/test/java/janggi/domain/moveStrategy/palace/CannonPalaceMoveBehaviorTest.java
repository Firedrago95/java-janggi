package janggi.domain.moveStrategy.palace;

import janggi.ReplaceUnderBar;
import janggi.domain.path.Position;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@ReplaceUnderBar
class CannonPalaceMoveBehaviorTest {

    private CannonPalaceMoveBehavior cannonPalaceMoveBehavior = new CannonPalaceMoveBehavior();

    public static Stream<Arguments> 궁성_경로를_반환한다_테스트_케이스() {
        return Stream.of(
            Arguments.of(new Position(4,1), new Position(6,3),
                List.of(new Position(5,2), new Position(6,3))),
            Arguments.of(new Position(6,1), new Position(4,3),
                List.of(new Position(5,2), new Position(4,3))),
            Arguments.of(new Position(6,3), new Position(4,1),
                List.of(new Position(5,2), new Position(4,1))),
            Arguments.of(new Position(4,3), new Position(6,1),
                List.of(new Position(5,2), new Position(6,1))),

            Arguments.of(new Position(4,10), new Position(6,8),
                List.of(new Position(5,9), new Position(6,8))),
            Arguments.of(new Position(6,10), new Position(4,8),
                List.of(new Position(5,9), new Position(4,8))),
            Arguments.of(new Position(4,8), new Position(6,10),
                List.of(new Position(5,9), new Position(6,10))),
            Arguments.of(new Position(6,8), new Position(4,10),
                List.of(new Position(5,9), new Position(4,10)))

        );
    }

    @ParameterizedTest
    @MethodSource("궁성_경로를_반환한다_테스트_케이스")
    void 궁성_경로를_반환한다(Position start, Position destination, List<Position> expected) {
        // when
        List<Position> path = cannonPalaceMoveBehavior.getPath(start, destination);

        // then
        assertThat(path).isEqualTo(expected);
    }
}