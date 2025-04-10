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
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@ReplaceUnderBar
class RookMoveBehaviorTest {

    private RookMoveBehavior rookMoveBehavior = new RookMoveBehavior();

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
    @CsvSource(value = {"4,5,5,8","4,5,3,7","4,5,6,2","4,5,3,2"})
    void 수직_수평_관계가_아니면_이동할_수_없다(int startX, int startY, int destinationX, int destinationY) {
        // given
        Position start = new Position(startX, startY);
        Position destination = new Position(destinationX, destinationY);

        // when & then
        assertThatIllegalArgumentException()
            .isThrownBy(() -> rookMoveBehavior.getPath(start, destination))
            .withMessage("차는 상하좌우 직선으로만 움직일 수 있습니다.");
    }

    @Test
    void 목적지가_아닌_경로에_기물이_있는경우_이동할_수_없다() {
        // given
        Side cho = Side.CHO;
        Position destination = new Position(1, 5);
        Pieces pieceOnPath = new Pieces(
            Map.of(
                new Position(1, 3), new Piece(Side.CHO, PieceType.PAWN, new PawnMoveBehavior(Side.CHO))
            )
        );

        // when
        boolean isMoveable = rookMoveBehavior.canMove(pieceOnPath, destination, cho);

        // then
        assertThat(isMoveable).isFalse();
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
        boolean isMoveable = rookMoveBehavior.canMove(pieceOnPath, destination, cho);

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
        assertThat(rookMoveBehavior.canMove(pieceOnPath, destination, cho)).isTrue();
    }

    @Test
    void 경로상에_기물이_없는_경우_이동할_수_있다() {
        // given
        Side cho = Side.CHO;
        Position destination = new Position(1, 5);
        Pieces pieceOnPath = new Pieces(
            Map.of()
        );

        // when & then
        assertThat(rookMoveBehavior.canMove(pieceOnPath, destination, cho)).isTrue();
    }

    @ParameterizedTest
    @MethodSource("궁성_경로를_반환한다_테스트_케이스")
    void 궁성_경로를_반환한다(Position start, Position destination, List<Position> expected) {
        // when
        List<Position> path = rookMoveBehavior.getPath(start, destination);

        // then
        assertThat(path).isEqualTo(expected);
    }
}