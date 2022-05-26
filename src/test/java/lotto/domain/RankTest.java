package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @DisplayName("valueOf 테스트")
    @Test
    void valueOf() {
        Rank rank = Rank.valueOf(5, true);
        System.out.println("test");
    }
}