package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LotteryGames {
    private static final int EACH_PRICE = 1000;
    private static final int ZERO_PRICE = 0;

    private List<LotteryGame> lotteryGameList;

    public LotteryGames(int purchasePrice) {
        this(new ArrayList<>());
        validate(purchasePrice);
        init(purchasePrice);
    }

    public LotteryGames(List<LotteryGame> lotteryGameList) {
        this.lotteryGameList = lotteryGameList;
    }

    private void validate(int purchasePrice) {
        if (purchasePrice < EACH_PRICE) {
            throw new IllegalArgumentException("로또 구매를 위해서는 천원 이상 입력해야 합니다.");
        }

        if (purchasePrice % EACH_PRICE != ZERO_PRICE) {
            throw new IllegalArgumentException("천원 단위로 입력해주세요.");
        }
    }

    private void init(int purchasePrice) {
        for (int i = 0; i < purchasePrice / EACH_PRICE; i++) {
            lotteryGameList.add(new LotteryGame());
        }
    }

    public List<LotteryGame> getLotteryGameList() {
        return lotteryGameList;
    }
}
