package janggi.domain.piece;

public enum Side {
    HAN, CHO;

    public Side opposite() {
        if (this == HAN) return CHO;
        return HAN;
    }
}
