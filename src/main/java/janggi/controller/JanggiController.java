package janggi.controller;

import janggi.domain.board.Board;
import janggi.domain.board.initiator.BoardInitiator;
import janggi.view.InputView;
import janggi.view.OutputView;

public class JanggiController {

    private Board board;

    public void run() {
        BoardInitiator boardInitiator = new BoardInitiator(InputView.readHanSetup(), InputView.readChoSetup());
        this.board = new Board(boardInitiator.generateInitialPieces());
        OutputView.printBoard(board);
    }
}
