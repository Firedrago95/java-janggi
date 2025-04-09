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

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@ReplaceUnderBar
class CannonMoveBehaviorTest {

    private CannonMoveBehavior cannonMoveBehavior = new CannonMoveBehavior();

    @ParameterizedTest
    @CsvSource(value = {"4,5,5,8","4,5,3,7","4,5,6,2","4,5,3,2"})
    void 수직_수평_관계가_아니면_이동할_수_없다(int startX, int startY, int destinationX, int destinationY) {
        // given
        Position start = new Position(startX, startY);
        Position destination = new Position(destinationX, destinationY);

        // when & then
        assertThatIllegalArgumentException()
            .isThrownBy(() -> cannonMoveBehavior.getPath(start, destination))
            .withMessage("포는 상하좌우 직선으로만 움직일 수 있습니다.");
    }

    @Test
    void 목적지까지_이동_경로를_반환한다() {
        // given
        Position start = new Position(4, 5);
        Position destination = new Position(4, 9);

        // when
        List<Position> path = cannonMoveBehavior.getPath(start, destination);

        // then
        List<Position> expected = List.of(
                new Position(4, 6), new Position(4, 7),
                new Position(4, 8), new Position(4, 9)
        );
        assertThat(path).isEqualTo(expected);
    }

    @Test
    void 경로상에_포가_있을경우_이동할_수_없다() {
        // given
        Side pieceSide = Side.HAN;
        Position destination = new Position(1, 6);
        Pieces pieceOnPath = new Pieces(
            Map.of(
                new Position(1, 3), new Piece(Side.CHO, PieceType.CANNON, new CannonMoveBehavior())
            )
        );

        // when
        boolean isMoveable = cannonMoveBehavior.canMove(pieceOnPath, destination, pieceSide);

        // then
        assertThat(isMoveable).isFalse();
    }

    @Test
    void 경로상에_두개_이상의_기물이_있는_경우_이동할_수_없다() {
        // given
        Side pieceSide = Side.HAN;
        Position destination = new Position(1, 6);
        Pieces pieceOnPath = new Pieces(
            Map.of(
                new Position(1, 3), new Piece(Side.CHO, PieceType.ROOK, new RookMoveBehavior()),
                new Position(1, 5), new Piece(Side.HAN, PieceType.PAWN, new PawnMoveBehavior(Side.HAN))
            )
        );

        // when
        boolean isMoveable = cannonMoveBehavior.canMove(pieceOnPath, destination, pieceSide);

        // then
        assertThat(isMoveable).isFalse();
    }

    @Test
    void 목적지에_포가_있는_경우_이동할_수_없다() {
        // given
        Side pieceSide = Side.HAN;
        Position destination = new Position(1, 6);
        Pieces pieceOnPath = new Pieces(
            Map.of(
                new Position(1, 6), new Piece(Side.CHO, PieceType.CANNON, new CannonMoveBehavior())
            )
        );

        // when
        boolean isMoveable = cannonMoveBehavior.canMove(pieceOnPath, destination, pieceSide);

        // then
        assertThat(isMoveable).isFalse();
    }

    @Test
    void 목적지에_아군_기물이_존재하는_경우_이동할_수_없다() {
        // given
        Side pieceSide = Side.HAN;
        Position destination = new Position(1, 6);
        Pieces pieceOnPath = new Pieces(
            Map.of(
                new Position(1, 6), new Piece(Side.HAN, PieceType.PAWN, new PawnMoveBehavior(Side.HAN))
            )
        );

        // when
        boolean isMoveable = cannonMoveBehavior.canMove(pieceOnPath, destination, pieceSide);

        // then
        assertThat(isMoveable).isFalse();
    }

    @Test
    void 목적지에_포가아닌_적_기물이_존재하는_경우_이동할_수_있다() {
        // given
        Side pieceSide = Side.HAN;
        Position destination = new Position(1, 6);
        Pieces pieceOnPath = new Pieces(
            Map.of(
                new Position(1, 6), new Piece(Side.CHO, PieceType.PAWN, new PawnMoveBehavior(Side.CHO))
            )
        );

        // when
        boolean isMoveable = cannonMoveBehavior.canMove(pieceOnPath, destination, pieceSide);

        // then
        assertThat(isMoveable).isTrue();
    }
}