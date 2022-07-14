package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LotteryGameTest {

    @DisplayName("랜덤하게 로또 게임 생성")
    @Test
    void construct_auto() {
        LotteryGame lotteryGame = new LotteryGame();
        assertThat(lotteryGame.getLotteries()).hasSize(6);
    }

    @DisplayName("수동 번호를 통해 로또 게임 생성")
    @Test
    void construct_manual() {
        LotteryGame lotteryGame = new LotteryGame("1,2,3,4,5,6");
        assertAll(
                () -> assertThat(lotteryGame.getLotteries().get(0)).isEqualTo(1),
                () -> assertThat(lotteryGame.getLotteries().get(1)).isEqualTo(2),
                () -> assertThat(lotteryGame.getLotteries().get(2)).isEqualTo(3),
                () -> assertThat(lotteryGame.getLotteries().get(3)).isEqualTo(4),
                () -> assertThat(lotteryGame.getLotteries().get(4)).isEqualTo(5),
                () -> assertThat(lotteryGame.getLotteries().get(5)).isEqualTo(6)
        );
    }

    @DisplayName("수동 번호는 6개의 숫자로 이루어져 있기 때문에 6개의 숫자 이외의 값을 입력하면 예외발생")
    @Test
    void construct_manual_notInput6Numbers() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LotteryGame("1,2,3,4,5"))
                .withMessageContaining("로또 번호는 6개의 숫자를 입력해야 합니다.");
    }
}
