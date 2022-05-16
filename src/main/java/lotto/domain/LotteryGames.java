package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LotteryGames {
    private static final int NOT_CREATE_AUTO_LOTTERY = 0;

    private List<LotteryGame> lotteryGames;

    public LotteryGames(int numberOfGames) {
        this(new ArrayList<>(), numberOfGames);
    }

    public LotteryGames(List<LotteryGame> lotteryGames) {
        this(lotteryGames, NOT_CREATE_AUTO_LOTTERY);
    }

    public LotteryGames(List<LotteryGame> lotteryGames, int numberOfGames) {
        this.lotteryGames = lotteryGames;
        create(numberOfGames);
    }

    public void create(int number) {
        for (int i = 0; i < number; i++) {
            LotteryGame lotteryGame = LotteryGame.create();
            lotteryGames.add(lotteryGame);
        }
    }

    public List<LotteryGame> getLotteryGames() {
        return lotteryGames;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (LotteryGame lotteryGame : lotteryGames) {
            stringBuilder.append(lotteryGame).append("\n");
        }
        return stringBuilder.toString();
    }
}
