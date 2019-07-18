package nl.kolkos.botmigrationhelper.services;

import nl.kolkos.botmigrationhelper.entities.Wallet;
import nl.kolkos.botmigrationhelper.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletService {

    private WalletRepository walletRepository;

    @Autowired
    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }


    public void findAllWallets() {
        List<Wallet> wallets = walletRepository.findAll();
        for(Wallet wallet : wallets) {
            System.out.println(wallet.toString());
        }
    }

}
