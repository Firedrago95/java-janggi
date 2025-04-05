package janggi.domain;

import java.util.Arrays;

public enum PieceSetup {
    LEFT_SETUP,
    RIGHT_SETUP,
    INNER_SETUP,
    OUTER_SETUP;

    public static PieceSetup findSetup(String input) {
        try {
            int num = Integer.parseInt(input);
            return Arrays.stream(values())
                .filter(setup -> setup.ordinal() + 1 == num)
                .findFirst()
                .get();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("1부터 4까지의 숫자를 입력해주세요");
        }
    }
}
