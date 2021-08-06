package lotto.domain;

import java.util.Objects;

public final class LottoNumber {

    private int number;

    public LottoNumber(final int number) {
        this.number = number;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
