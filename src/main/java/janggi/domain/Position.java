package janggi.domain;

import java.util.function.Predicate;

public class Position {

    private static final Predicate<Integer> IS_VALID_X = x -> 1 <= x && x <= 9;
    private static final Predicate<Integer> IS_VALID_Y = y -> 1 <= y && y <= 10;

    private int x;
    private int y;

    public Position(int x, int y) {
        validatePositionRange(x, y);
        this.x = x;
        this.y = y;
    }

    private void validatePositionRange(int x, int y) {
        boolean isValidatePosition = IS_VALID_X.test(x) && IS_VALID_Y.test(y);

        if (!isValidatePosition) {
            throw new IllegalArgumentException("[ERROR] 장기판을 벗어난 좌표입니다.");
        }
    }
}
