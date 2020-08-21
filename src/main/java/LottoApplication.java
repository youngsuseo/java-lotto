import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {
    private static InputView inputView = new InputView();
    private static ResultView resultView = new ResultView();

    public static void main(String[] args) {
        LottoNumberExtractor lottoNumberExtractor = new LottoNumberRandomExtractor();
        LottoMachine lottoMachine = new LottoMachine(lottoNumberExtractor);

        int purchasePrice = inputView.getPurchasePrice();
        List<Integer> winningNumbers = inputView.getWinningNumbers();
        LottoTickets lottoTickets = lottoMachine.makeLottoTickets(purchasePrice);
        LottoTicket winningTicket = LottoTicket.of(winningNumbers);

        resultView.printLottoTicketSize(lottoTickets.size());
        List<String> lottoTicketStrings = lottoTickets.getLottoTicketStrings();
        resultView.printLottoTickets(lottoTicketStrings);

        LottoStatistics lottoStatistics = new LottoStatistics(winningTicket);
        LottoResult lottoResult = lottoStatistics.getLottoResult(lottoTickets);

        resultView.printLottoStatistics(lottoResult.getWinningResult());
        resultView.printRate(lottoResult.calculateRate(lottoTickets.getPurchasePrice()));

    }
}