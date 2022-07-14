package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LotteryGamesTest {

    @DisplayName("자동 방식으로 로또 게임 구매")
    @Test
    void construct_auto() {
        LotteryGames lotteryGames = new LotteryGames(10000);
        assertThat(lotteryGames.getLotteryGameList()).hasSize(10);
    }

    @DisplayName("구매금액을 1000원보다 적게 입력하였을 때")
    @Test
    void construct_lowerThan1000() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LotteryGames(800))
                .withMessageContaining("로또 구매를 위해서는 천원 이상 입력해야 합니다.");
    }

    @DisplayName("구매금액을 1000원 단위가 아닌 값을 입력하였을 때 (예, 1999원)")
    @Test
    void construct_invalidPrice() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LotteryGames(1999))
                .withMessageContaining("천원 단위로 입력해주세요.");
    }


}
