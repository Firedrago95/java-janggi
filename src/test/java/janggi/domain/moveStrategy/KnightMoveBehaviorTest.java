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
class KnightMoveBehaviorTest {

    private final KnightMoveBehavior knightMoveBehavior = new KnightMoveBehavior();

    public static Stream<Arguments> 마_이동_경로를_반환한다_테스트_케이스() {
        return Stream.of(
            Arguments.of(4,5,6,6,
                List.of(new Position(5,5), new Position(6,6))),
            Arguments.of(4,5,6,4,
                List.of(new Position(5,5), new Position(6,4))),
            Arguments.of(4,5,2,6,
                List.of(new Position(3,5), new Position(2,6))),
            Arguments.of(4,5,2,4,
                List.of(new Position(3,5), new Position(2,4))),
            Arguments.of(4,5,5,7,
                List.of(new Position(4,6), new Position(5,7))),
            Arguments.of(4,5,3,7,
                List.of(new Position(4,6), new Position(3,7))),
            Arguments.of(4,5,5,3,
                List.of(new Position(4,4), new Position(5,3))),
            Arguments.of(4,5,3,3,
                List.of(new Position(4,4), new Position(3,3)))
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"4,5,2,1", "4,5,3,4", "4,5,4,6", "4,5,7,8"})
    void 마_이동패턴이_아니면_이동할_수_없다(int startX, int startY, int destinationX, int destinationY) {
        // given
        Position start = new Position(startX, startY);
        Position destination = new Position(destinationX, destinationY);

        // when & then
        assertThatIllegalArgumentException()
            .isThrownBy(() -> knightMoveBehavior.getPath(start, destination))
            .withMessage("마는 직선으로 한칸 이동 후 대각선으로 한칸 이동해야 합니다.");
    }

    @ParameterizedTest
    @MethodSource("마_이동_경로를_반환한다_테스트_케이스")
    void 마_이동_경로를_반환한다(int startX, int startY, int destinationX, int destinationY, List<Position> expected) {
        // given
        Position start = new Position(startX, startY);
        Position destination = new Position(destinationX, destinationY);

        // when & then
        List<Position> path = knightMoveBehavior.getPath(start, destination);

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
        boolean isMoveable = knightMoveBehavior.canMove(pieceOnPath, destination, cho);

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
        boolean isMoveable = knightMoveBehavior.canMove(pieceOnPath, destination, cho);

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
        assertThat(knightMoveBehavior.canMove(pieceOnPath, destination, cho)).isTrue();
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
        assertThat(knightMoveBehavior.canMove(pieceOnPath, destination, cho)).isTrue();
    }
}