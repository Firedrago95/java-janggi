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
class ElephantMoveBehaviorTest {

    private final ElephantMoveBehavior elephantMoveBehavior = new ElephantMoveBehavior();

    public static Stream<Arguments> 상_이동_경로를_반환한다_테스트_케이스() {
        return Stream.of(
            Arguments.of(4,5,7,7,
                List.of(new Position(5,5), new Position(6,6), new Position(7,7))),
            Arguments.of(4,5,7,3,
                List.of(new Position(5,5), new Position(6,4), new Position(7,3))),
            Arguments.of(4,5,1,7,
                List.of(new Position(3,5), new Position(2,6), new Position(1,7))),
            Arguments.of(4,5,1,3,
                List.of(new Position(3,5), new Position(2,4), new Position(1,3))),
            Arguments.of(4,5,6,8,
                List.of(new Position(4,6), new Position(5,7), new Position(6,8))),
            Arguments.of(4,5,2,8,
                List.of(new Position(4,6), new Position(3,7), new Position(2,8))),
            Arguments.of(4,5,6,2,
                List.of(new Position(4,4), new Position(5,3), new Position(6,2))),
            Arguments.of(4,5,2,2,
                List.of(new Position(4,4), new Position(3,3), new Position(2,2)))
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"4,5,2,1", "4,5,3,4", "4,5,4,6", "4,5,7,8"})
    void 상_이동패턴이_아니면_이동할_수_없다(int startX, int startY, int destinationX, int destinationY) {
        // given
        Position start = new Position(startX, startY);
        Position destination = new Position(destinationX, destinationY);

        // when & then
        assertThatIllegalArgumentException()
            .isThrownBy(() -> elephantMoveBehavior.getPath(start, destination))
            .withMessage("상은 직선으로 한칸 이동 후 대각선으로 두칸 이동해야 합니다.");
    }

    @ParameterizedTest
    @MethodSource("상_이동_경로를_반환한다_테스트_케이스")
    void 상_이동_경로를_반환한다(int startX, int startY, int destinationX, int destinationY, List<Position> expected) {
        // given
        Position start = new Position(startX, startY);
        Position destination = new Position(destinationX, destinationY);

        // when & then
        List<Position> path = elephantMoveBehavior.getPath(start, destination);

        // then
        assertThat(path).isEqualTo(expected);
    }

    @Test
    void 목적지가_아닌_경로에_기물이_있는경우_이동할_수_없다() {
        // given
        Side cho = Side.CHO;
        Position destination = new Position(1, 5);
        Pieces pieceOnPath = new Pieces(
            Map.of(
                new Position(1, 3), new Piece(Side.CHO, PieceType.PAWN, new PawnMoveBehavior())
            )
        );

        // when
        boolean isMoveable = elephantMoveBehavior.canMove(pieceOnPath, destination, cho);

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
                new Position(1, 5), new Piece(Side.CHO, PieceType.PAWN, new PawnMoveBehavior())
            )
        );

        // when
        boolean isMoveable = elephantMoveBehavior.canMove(pieceOnPath, destination, cho);

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
                new Position(1, 5), new Piece(Side.HAN, PieceType.PAWN, new PawnMoveBehavior())
            )
        );

        // when & then
        assertThat(elephantMoveBehavior.canMove(pieceOnPath, destination, cho)).isTrue();
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
        assertThat(elephantMoveBehavior.canMove(pieceOnPath, destination, cho)).isTrue();
    }
}