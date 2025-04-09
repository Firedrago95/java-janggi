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

        playGame();
    }

    private void playGame() {
        while(!board.isGameOver()) {
            Side turn = board.getTurn();
            computeException(() -> board.move(InputView.readStart(turn), InputView.readDestination(turn)));
            OutputView.printBoard(board);
        }
        OutputView.printWinner(board.getTurn());
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
