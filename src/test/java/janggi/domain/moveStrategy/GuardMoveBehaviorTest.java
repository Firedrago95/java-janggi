package janggi.domain.moveStrategy;

import janggi.ReplaceUnderBar;
import janggi.domain.path.Position;
import janggi.domain.piece.Piece;
import janggi.domain.piece.PieceType;
import janggi.domain.piece.Pieces;
import janggi.domain.piece.Side;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@ReplaceUnderBar
class GuardMoveBehaviorTest {

    private final GuardMoveBehavior guardMoveBehavior = new GuardMoveBehavior();

    public static Stream<Arguments> 사가_움직일_경로를_생성한다_테스트_케이스() {
        return Stream.of(
            Arguments.of(new Position(5,2), new Position(4,1), List.of(new Position(4,1))),
            Arguments.of(new Position(5,2), new Position(6,1), List.of(new Position(6,1))),
            Arguments.of(new Position(4,1), new Position(5,2), List.of(new Position(5,2))),
            Arguments.of(new Position(4,1), new Position(5,1), List.of(new Position(5,1))),
            Arguments.of(new Position(4,1), new Position(4,2), List.of(new Position(4,2)))
        );
    }

    @Test
    void 사는_궁성_밖으로_이동할_수_없다() {
        // given
        Position start = new Position(4, 2);
        Position destination = new Position(3, 2);

        // when & then
        assertThatIllegalArgumentException()
            .isThrownBy(() -> guardMoveBehavior.getPath(start, destination))
            .withMessage("사는 궁성 밖으로 이동할 수 없습니다.");
    }

    @ParameterizedTest
    @MethodSource("사가_움직일_경로를_생성한다_테스트_케이스")
    void 사가_움직일_경로를_생성한다(Position start, Position destination, List<Position> expected) {
        // when
        List<Position> path = guardMoveBehavior.getPath(start, destination);

        // then
        assertThat(path).isEqualTo(expected);
    }

    @Test
    void 목적지에_아군_기물이_있는경우_이동할_수_없다() {
        // given
        Side cho = Side.CHO;
        Position destination = new Position(1, 5);
        Pieces pieceOnPath = new Pieces(
            Map.of(
                new Position(1, 5), new Piece(Side.CHO, PieceType.PAWN, new PawnMoveBehavior(Side.CHO))
            )
        );

        // when
        boolean isMoveable = guardMoveBehavior.canMove(pieceOnPath, destination, cho);

        // then
        assertThat(isMoveable).isFalse();
    }

    @Test
    void 목적지에_적_기물이_있는경우_이동할_수_있다() {
        // given
        Side cho = Side.CHO;
        Position destination = new Position(1, 5);
        Pieces pieceOnPath = new Pieces(
            Map.of(
                new Position(1, 5), new Piece(Side.HAN, PieceType.PAWN, new PawnMoveBehavior(Side.HAN))
            )
        );

        // when & then
        assertThat(guardMoveBehavior.canMove(pieceOnPath, destination, cho)).isTrue();
    }
}