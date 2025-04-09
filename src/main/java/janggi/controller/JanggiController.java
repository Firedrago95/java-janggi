package janggi.controller;

import janggi.domain.board.Board;
import janggi.domain.board.initiator.BoardInitiator;
import janggi.domain.piece.Side;
import janggi.view.InputView;
import janggi.view.OutputView;

public class JanggiController {

    private Board board;

    public void run() {
        BoardInitiator boardInitiator = new BoardInitiator(InputView.readHanSetup(), InputView.readChoSetup());
        this.board = new Board(boardInitiator.generateInitialPieces(), Side.CHO);
        OutputView.printBoard(board);

        while(!board.isGameOver()) {
            computeException(() -> board.move(InputView.readStart(), InputView.readDestination()));
            OutputView.printBoard(board);
        }
    }

    private void computeException(Runnable runnable) {
        boolean isException = true;
        while (isException) {
            try {
                runnable.run();
                isException = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
