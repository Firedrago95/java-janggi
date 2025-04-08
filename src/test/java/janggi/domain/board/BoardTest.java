package janggi.domain.board;

import janggi.JanggiTestFixture;
import janggi.ReplaceUnderBar;
import janggi.domain.moveStrategy.PawnMoveBehavior;
import janggi.domain.path.Position;
import janggi.domain.piece.Piece;
import janggi.domain.piece.PieceType;
import janggi.domain.piece.Side;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@ReplaceUnderBar
class BoardTest {

    @Test
    void 경로상의_기물들을_찾는다() {
        // given
        Map<Position, Piece> fixedPieces = JanggiTestFixture.getFixedPieces();
        Board board = new Board(fixedPieces);
        List<Position> path = List.of(
            new Position(1, 2), new Position(1, 3), new Position(1, 4)
        );

        // when
        Map<Position, Piece> piecesOnPath = board.getPiecesOnPath(path);

        // then
        Map<Position, Piece> expected = Map.of(
            new Position(1, 4), new Piece(Side.HAN, PieceType.PAWN, new PawnMoveBehavior())
        );
        assertThat(piecesOnPath).isEqualTo(expected);
    }
}