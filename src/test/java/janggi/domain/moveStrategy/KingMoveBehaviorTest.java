package janggi.domain.moveStrategy;

import janggi.ReplaceUnderBar;
import janggi.domain.path.Position;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@ReplaceUnderBar
class KingMoveBehaviorTest {

    private final KingMoveBehavior kingMoveBehavior = new KingMoveBehavior();

    @Test
    void 왕은_궁성_밖으로_이동할_수_없다() {
        // given
        Position start = new Position(4, 2);
        Position destination = new Position(3, 2);

        // when & then
        assertThatIllegalArgumentException()
            .isThrownBy(() -> kingMoveBehavior.getPath(start, destination))
            .withMessage("왕은 궁성 밖으로 이동할 수 없습니다.");
    }
}