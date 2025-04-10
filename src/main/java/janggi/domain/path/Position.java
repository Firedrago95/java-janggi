package janggi.domain.path;

import java.util.Objects;
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

    public boolean isVerticalMove(Position destination) {
        return this.x == destination.x && this.y != destination.y;
    }

    public boolean isHorizontalMove(Position destination) {
        return this.x != destination.x && this.y == destination.y;
    }

    public boolean isLinearMove(Position destination) {
        return isHorizontalMove(destination) || isVerticalMove(destination);
    }

    public int calculateXDistance(Position destination) {
        return destination.x - this.x;
    }

    public int calculateYDistance(Position destination) {
        return destination.y - this.y;
    }

    public boolean isOneStepMove(Position destination) {
        int xDistance = Math.abs(calculateXDistance(destination));
        int yDistance = Math.abs(calculateYDistance(destination));
        return (xDistance == 1 && yDistance == 0)
            || (xDistance == 0 && yDistance == 1);
    }

    public boolean isInPalace() {
        return isInPalaceCenter() || isInPalaceCorner();
    }

    public boolean isInPalaceCorner() {
        return (this.x == 4 || this.x == 6)
            && (this.y == 1 || this.y == 3 || this.y == 8 || this.y == 10);
    }

    public boolean isInPalaceCenter() {
        return (this.x == 5) && (this.y == 2 || this.y == 9);
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    @Override
    public String toString() {
        return "Position{" +
            "x=" + x +
            ", y=" + y +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Position position)) return false;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
