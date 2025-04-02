package janggi.domain;

import janggi.ReplaceUnderBar;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ReplaceUnderBar
class PositionTest {

    @ParameterizedTest
    @CsvSource(value = {"0, 5", "10, 5", "5, 0", "5, 11"})
    void 장기판_9x10을_벗어난_좌표는_예외를_발생시킨다(int x, int y) {
        assertThatThrownBy(() -> new Position(x, y))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 장기판을 벗어난 좌표입니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 5", "9, 5", "5, 1", "5, 10"})
    void 장기판_9x10내의_좌표는_예외를_발생하지_않는다(int x, int y) {
        assertThatCode(() -> new Position(x, y)).doesNotThrowAnyException();
    }
}