package janggi.domain.path;

import janggi.ReplaceUnderBar;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

@ReplaceUnderBar
class PositionTest {

    @ParameterizedTest
    @CsvSource(value = {"0, 5", "10, 5", "5, 0", "5, 11"})
    void 장기판_9x10을_벗어난_좌표는_예외를_발생시킨다(int x, int y) {
        // when & then
        assertThatThrownBy(() -> new Position(x, y))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 장기판을 벗어난 좌표입니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 5", "9, 5", "5, 1", "5, 10"})
    void 장기판_9x10내의_좌표는_예외를_발생하지_않는다(int x, int y) {
        // when & then
        assertThatCode(() -> new Position(x, y)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @CsvSource(value = {"4,5,3,6,false", "4,5,5,3,false", "4,5,4,7, true", "4,5,2,5,true"})
    void 직선_움직임을_검증한다(int startX, int startY, int destinationX, int destinationY, boolean isLinear) {
        // given
        Position start = new Position(startX, startY);
        Position destination = new Position(destinationX, destinationY);

        // when & then
        assertThat(start.isLinearMove(destination)).isEqualTo(isLinear);
    }

    @ParameterizedTest
    @CsvSource(value = {"4,5,3,6,false", "4,5,5,3,false", "4,5,4,7, true", "4,5,4,2,true"})
    void 수직_움직임을_검증한다(int startX, int startY, int destinationX, int destinationY, boolean isLinear) {
        // given
        Position start = new Position(startX, startY);
        Position destination = new Position(destinationX, destinationY);

        // when & then
        assertThat(start.isVerticalMove(destination)).isEqualTo(isLinear);
    }

    @ParameterizedTest
    @CsvSource(value = {"4,5,3,6,false", "4,5,5,3,false", "4,5,2,5, true", "4,5,7,5,true"})
    void 수평_움직임을_검증한다(int startX, int startY, int destinationX, int destinationY, boolean isLinear) {
        // given
        Position start = new Position(startX, startY);
        Position destination = new Position(destinationX, destinationY);

        // when & then
        assertThat(start.isHorizontalMove(destination)).isEqualTo(isLinear);
    }

    @ParameterizedTest
    @CsvSource(value = {"4,5,3,6,false", "4,5,3,5, true", "4,5,5,5,true", "4,5,4,6,true", "4,5,4,4,true"})
    void 상하좌우_한칸_움직임을_검증한다(int startX, int startY, int destinationX, int destinationY, boolean isLinear) {
        // given
        Position start = new Position(startX, startY);
        Position destination = new Position(destinationX, destinationY);

        // when & then
        assertThat(start.isOneStepMove(destination)).isEqualTo(isLinear);
    }

    @ParameterizedTest
    @CsvSource(value = {})
    void 궁성_안_위치인지_검증한다(int x, int y, boolean expected) {
        // given
        Position position = new Position(x, y);

        // when
        boolean isInPalace = position.isInPalace();

        // then
        assertThat(isInPalace).isEqualTo(expected);
    }
}