package nl.kolkos.botmigrationhelper.jobs;

import nl.kolkos.botmigrationhelper.services.CoinService;
import nl.kolkos.botmigrationhelper.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledJobs {

    private CoinService coinService;
    private WalletService walletService;


    @Autowired
    public ScheduledJobs(CoinService coinService, WalletService walletService) {
        this.coinService = coinService;
        this.walletService = walletService;
    }

    @Scheduled(fixedDelay = 1000 * 60 * 60)
    public void migrateCoins() {
        coinService.migrateCoins();
    }

    @Scheduled(fixedDelay = 1000 * 60 * 60)
    public void migrateWallets() {
        walletService.findAllWallets();
    }


}
