package lotto.domain;

public class WinningData {
    private WinningNumbers winningNumbers;
    private int bonusNumber;

    public WinningData(WinningNumbers winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
