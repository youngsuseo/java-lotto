package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class WinningResult {
    private static final int INITIAL_VALUE = 0;
    private static final int WINNING_CRITERIA = 3;
    private static final int CORRECT = 1;
    private static final int NOT_CORRECT = 0;

    private static final Map<Rank, Integer> RESULT_MAP = new EnumMap<>(Rank.class) {
        {
            put(Rank.FIFTH, INITIAL_VALUE);
            put(Rank.FOURTH, INITIAL_VALUE);
            put(Rank.THIRD, INITIAL_VALUE);
            put(Rank.SECOND, INITIAL_VALUE);
            put(Rank.FIRST, INITIAL_VALUE);
        }
    };

    private WinningData winningData;
    private LotteryGames lotteryGames;

    public WinningResult(WinningNumbers winningNumbers, int bonusNumber, LotteryGames lotteryGames) {
        this(new WinningData(winningNumbers, bonusNumber), lotteryGames);
    }

    public WinningResult(WinningData winningData, LotteryGames lotteryGames) {
        this.winningData = winningData;
        this.lotteryGames = lotteryGames;
    }

    public Map<Rank, Integer> get() {
        for (LotteryGame lotteryGame : lotteryGames.getLotteryGames()) {
            int correctNumbers = matchNumbers(winningData.getWinningNumbers(), lotteryGame);

            if (isNotWin(correctNumbers) || isSecondRank(winningData.getBonusNumber(), lotteryGame, correctNumbers)) {
                continue;
            }

            Rank rank = Rank.valueOf(correctNumbers);
            RESULT_MAP.put(rank, RESULT_MAP.get(rank) + 1);
        }
        return RESULT_MAP;
    }

    private int matchNumbers(LotteryGame lotteryGame) {
        int matchedNumbers = 0;

        for (Integer winningNumber : winningData.getWinningNumbers().getWinningNumbers()) {
            matchedNumbers += countmatchedNumbers(lotteryGame, winningNumber);
        }

        boolean matchBonus = lotteryGame.isContain(matchedNumbers);

        return matchedNumbers;
    }







    private boolean isNotWin(int correctNumbers) {
        return correctNumbers < WINNING_CRITERIA;
    }

    private boolean isSecondRank(int bonusNumber, LotteryGame lotteryGame, int correctNumbers) {
        if (correctNumbers == 5) {
            return isContainedBonusNumber(bonusNumber, lotteryGame);
        }
        return false;
    }

    private boolean isContainedBonusNumber(int bonusNumber, LotteryGame lotteryGame) {
        if (lotteryGame.isContain(bonusNumber)) {
            RESULT_MAP.put(Rank.SECOND, RESULT_MAP.get(Rank.SECOND) + 1);
            return true;
        }
        return false;
    }

    private int matchNumbers(WinningNumbers winningNumbers, LotteryGame lotteryGame) {
        int matchedNumbers = 0;
        for (Integer winningNumber : winningNumbers.getWinningNumbers()) {
            matchedNumbers += countmatchedNumbers(lotteryGame, winningNumber);
        }
        return matchedNumbers;
    }

    private int countmatchedNumbers(LotteryGame lotteryGame, Integer winningNumber) {
        if (lotteryGame.isContain(winningNumber)) {
            return CORRECT;
        }
        return NOT_CORRECT;
    }

    public int profit(Map<Rank, Integer> results) {
        int profit = 0;
        for (Rank rank : results.keySet()) {
            profit += results.get(rank) * rank.getWinningMoney();
        }
        return profit;
    }

    public double profitRate(int profit, int spent) {
        return profit * 1.0 / spent;
    }
}
