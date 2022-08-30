package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class NameTest {

    @DisplayName("이름이 5자 이상이면 예외가 발생한다")
    @Test
    void overLength() {
        final ThrowingCallable actual = () -> new Name("123456");

        assertThatThrownBy(actual)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차의 이름은 5자를 초과할 수 없습니다");
    }

    @DisplayName("자동차의 이름은 비어있을 수 없다")
    @ParameterizedTest
    @NullAndEmptySource
    void notEmpty(String name) {
        final ThrowingCallable actual = () -> new Name(name);

        assertThatThrownBy(actual)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차의 이름은 null 이거나 빈 문자열일 수 없습니다");

    }
}
