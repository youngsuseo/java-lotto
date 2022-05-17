package lotto.domain;

public class WinningData {
    private WinningNumbers winningNumbers;
    private int bonusNumber;

    public WinningData(WinningNumbers winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
}
