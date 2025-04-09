package janggi.domain.moveStrategy;

import janggi.ReplaceUnderBar;
import janggi.domain.path.Position;
import janggi.domain.piece.Piece;
import janggi.domain.piece.PieceType;
import janggi.domain.piece.Pieces;
import janggi.domain.piece.Side;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@ReplaceUnderBar
class PawnMoveBehaviorTest {

    private final PawnMoveBehavior pawnMoveBehavior = new PawnMoveBehavior(Side.CHO);

    @ParameterizedTest
    @CsvSource(value = {"4,5,3,6", "4,5,3,4", "4,5,5,6", "4,5,5,4"})
    void 졸_이동경로가_아니면_이동할_수_없다(int startX, int startY, int destinationX, int destinationY) {
        // given
        Position start = new Position(startX, startY);
        Position destination = new Position(destinationX, destinationY);

        // when & then
        assertThatIllegalArgumentException()
            .isThrownBy(() -> pawnMoveBehavior.getPath(start, destination))
            .withMessage("졸은 직진과 좌우로 한칸 이동 할 수 있습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"4,5,3,5", "4,5,5,5", "4,5,4,4"})
    void 졸_직선으로_한칸_이동할_수_있다(int startX, int startY, int destinationX, int destinationY) {
        // given
        Position start = new Position(startX, startY);
        Position destination = new Position(destinationX, destinationY);

        // when & then
            assertThatCode(() -> pawnMoveBehavior.getPath(start, destination)).doesNotThrowAnyException();
    }

    @Test
    void 목적지까지_이동_경로를_반환한다() {
        // given
        Position start = new Position(4, 5);
        Position destination = new Position(4, 4);

        // when
        List<Position> path = pawnMoveBehavior.getPath(start, destination);

        // then
        List<Position> expected = List.of(
            new Position(4, 4)
        );
        assertThat(path).isEqualTo(expected);
    }

    @Test
    void 초나라_졸은_y값_증가방향으로_움직일_수_없다() {
        // given
        Side pieceSide = Side.CHO;
        Position start = new Position(4, 5);
        Position destination = new Position(4, 6);
        PawnMoveBehavior choPawnMoveBehavior = new PawnMoveBehavior(pieceSide);

        // when & then
        assertThatIllegalArgumentException()
            .isThrownBy(() -> choPawnMoveBehavior.getPath(start, destination))
            .withMessage("졸은 뒤로 이동 할 수 없습니다.");
    }

    @Test
    void 한나라_졸은_y값_감소방향으로_움직일_수_없다() {
        // given
        Side pieceSide = Side.HAN;
        Position start = new Position(4, 5);
        Position destination = new Position(4, 4);
        PawnMoveBehavior hanPawnMoveBehavior = new PawnMoveBehavior(pieceSide);

        // when & then
        assertThatIllegalArgumentException()
            .isThrownBy(() -> hanPawnMoveBehavior.getPath(start, destination))
            .withMessage("졸은 뒤로 이동 할 수 없습니다.");
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
        boolean isMoveable = pawnMoveBehavior.canMove(pieceOnPath, destination, cho);

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
        assertThat(pawnMoveBehavior.canMove(pieceOnPath, destination, cho)).isTrue();
    }
}
