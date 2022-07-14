package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LotteryGame {
    private static final int COUNT_OF_LOTTO_NUMBERS = 6;

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final List<Integer> LOTTO_LIST = new ArrayList<>() {{
        for (int i = START_NUMBER; i < END_NUMBER; i++) {
            add(i);
        }
    }};

    private List<Integer> lotteries;

    public LotteryGame() {
        create();
    }

    public LotteryGame(String lottoNumbers) {
        this(new ArrayList<>());
        createManual(lottoNumbers);
    }

    public LotteryGame(List<Integer> lotteries) {
        this.lotteries = lotteries;
    }

    private void create() {
        Collections.shuffle(LOTTO_LIST);
        List<Integer> subList = new ArrayList<>(LOTTO_LIST.subList(0, 6));
        Collections.sort(subList);
        this.lotteries = Collections.unmodifiableList(subList);
    }

    private void createManual(String lottoNumbers) { // FIXME 수동으로 입력하는 건에 대해서는 따로 클래스 분리해서 입력 받는걸로 진행
        String[] numberArray = lottoNumbers.split(",");
        if (numberArray.length != COUNT_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException("로또 번호는 6개의 숫자를 입력해야 합니다.");
        }

        for (String number : numberArray) {
            lotteries.add(Integer.valueOf(number));
        }
        Collections.sort(lotteries);
    }

    public List<Integer> getLotteries() {
        return lotteries;
    }
}
