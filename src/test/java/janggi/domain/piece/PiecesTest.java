package janggi.domain.piece;

import janggi.ReplaceUnderBar;
import janggi.domain.moveStrategy.CannonMoveBehavior;
import janggi.domain.moveStrategy.ElephantMoveBehavior;
import janggi.domain.moveStrategy.PawnMoveBehavior;
import janggi.domain.moveStrategy.RookMoveBehavior;
import janggi.domain.path.Position;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@ReplaceUnderBar
class PiecesTest {


    @Test
    void 경로상에_포가_있는지_확인한다() {
        // given
        Pieces cannonPieceOnPath = new Pieces(
            Map.of(
                new Position(1, 3), new Piece(Side.CHO, PieceType.CANNON, new CannonMoveBehavior())
            )
        );
        Pieces pawnPieceOnPath = new Pieces(
            Map.of(
                new Position(1, 3), new Piece(Side.CHO, PieceType.PAWN, new PawnMoveBehavior(Side.CHO))
            )
        );

        // when & then
        assertAll(
            () -> assertThat(cannonPieceOnPath.hasCannon()).isTrue(),
            () -> assertThat(pawnPieceOnPath.hasCannon()).isFalse()
        );
    }

    @Test
    void 목적지가_아닌_경로상에_하나의_기물이_있는지_확인한다() {
        // given
        Pieces cannonPieceOnPath = new Pieces(
            Map.of(
                new Position(1, 4), new Piece(Side.CHO, PieceType.ROOK, new RookMoveBehavior())
            )
        );
        Pieces pawnPieceOnPath = new Pieces(
            Map.of(
                new Position(1, 3), new Piece(Side.CHO, PieceType.PAWN, new PawnMoveBehavior(Side.CHO)),
                new Position(1, 4), new Piece(Side.HAN, PieceType.ELEPHANT, new ElephantMoveBehavior())
            )
        );
        Position destination = new Position(1, 4);

        // when & then
        assertAll(
            () -> assertThat(cannonPieceOnPath.hasOnePieceOnPath(destination)).isFalse(),
            () -> assertThat(pawnPieceOnPath.hasOnePieceOnPath(destination)).isTrue()
        );
    }

    @Test
    void 목적지에_적_기물이_존재하는지_확인한댜() {
        // given
        Position destination = new Position(1, 5);
        Side pieceSide = Side.CHO;
        Pieces piecesOnPath = new Pieces(
            Map.of(destination, new Piece(Side.HAN, PieceType.PAWN, new PawnMoveBehavior(Side.HAN)))
        );

        // when & then
        assertThat(piecesOnPath.hasEnemyOnDestination(destination, pieceSide)).isTrue();
    }

    @Test
    void 목적지에_아군_기물이_존재하는지_확인한다() {
        // given
        Position destination = new Position(1, 5);
        Side pieceSide = Side.CHO;
        Pieces piecesOnPath = new Pieces(
            Map.of(destination, new Piece(Side.CHO, PieceType.PAWN, new PawnMoveBehavior(Side.CHO)))
        );

        // when & then
        assertThat(piecesOnPath.isAllyOnDestination(destination, pieceSide)).isTrue();
    }

    @Test
    void 해당_위치를_제외하고_기물이_존재하는지_확인한다() {
        // given
        Position destination = new Position(1, 5);
        Side pieceSide = Side.CHO;
        Pieces piecesOnPath = new Pieces(
            Map.of(destination, new Piece(Side.CHO, PieceType.PAWN, new PawnMoveBehavior(Side.CHO)))
        );

        // when & then
        assertThat(piecesOnPath.hasPieceExceptAt(destination)).isFalse();
    }
}