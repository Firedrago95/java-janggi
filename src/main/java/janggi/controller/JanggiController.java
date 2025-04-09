package janggi.controller;

import janggi.domain.board.Board;
import janggi.domain.board.initiator.BoardInitiator;
import janggi.domain.path.Position;
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
            Position start = InputView.readStart();
            Position destination = InputView.readDestination();
            board.move(start, destination);
            OutputView.printBoard(board);
        }
    }
}
