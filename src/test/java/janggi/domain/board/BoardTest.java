package janggi.domain.board;

import janggi.JanggiTestFixture;
import janggi.ReplaceUnderBar;
import janggi.domain.moveStrategy.KingMoveBehavior;
import janggi.domain.moveStrategy.PawnMoveBehavior;
import janggi.domain.path.Position;
import janggi.domain.piece.Piece;
import janggi.domain.piece.PieceType;
import janggi.domain.piece.Pieces;
import janggi.domain.piece.Side;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.assertj.core.api.Assertions.assertThat;

@ReplaceUnderBar
class BoardTest {

    @Test
    void 경로상의_기물들을_찾는다() {
        // given
        Map<Position, Piece> fixedPieces = JanggiTestFixture.getFixedPieces();
        Board board = new Board(fixedPieces, Side.CHO);
        List<Position> path = List.of(
            new Position(1, 2), new Position(1, 3), new Position(1, 4)
        );

        // when
        Pieces piecesOnPath = board.getPiecesOnPath(path);

        // then
        Pieces expected = new Pieces(Map.of(
            new Position(1, 4), new Piece(Side.HAN, PieceType.PAWN, new PawnMoveBehavior(Side.HAN))
        ));
        assertThat(piecesOnPath).isEqualTo(expected);
    }

    @Test
    void 왕이_2개가_아니면_경기_종료한다() {
        // given
        Board oneKingBoard = new Board(
            Map.of(
                new Position(4, 8), new Piece(Side.HAN, PieceType.KING, new KingMoveBehavior())
            ), Side.HAN
        );
        Board twoKingBoard = new Board(
            Map.of(
                new Position(4, 8), new Piece(Side.HAN, PieceType.KING, new KingMoveBehavior()),
                new Position(4, 1), new Piece(Side.CHO, PieceType.KING, new KingMoveBehavior())
            ), Side.HAN
        );

        // when & then
        assertAll(
            () -> assertThat(oneKingBoard.isGameOver()).isTrue(),
            () -> assertThat(twoKingBoard.isGameOver()).isFalse()
        );
    }
}