package nl.kolkos.botmigrationhelper.services;

import nl.kolkos.botmigrationhelper.entities.Wallet;
import nl.kolkos.botmigrationhelper.repositories.WalletRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class WalletService {

    private WalletRepository walletRepository;
    private RestClient restClient;

    private final static Logger LOGGER = LoggerFactory.getLogger(WalletService.class);

    @Autowired
    public WalletService(WalletRepository walletRepository, RestClient restClient) {
        this.walletRepository = walletRepository;
        this.restClient = restClient;
    }

    public void findAllWallets() {
        List<Wallet> wallets = walletRepository.findAll();

        LOGGER.info("Number of wallets found: {}", wallets.size());

        for (Wallet wallet : wallets) {
            this.registerWallet(wallet);
        }
    }

    public void registerWallet(Wallet wallet) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String response = restClient.doRestRequest(headers, HttpMethod.GET, createRegisterWallerUrl(wallet));
        LOGGER.info(response);
    }

    private String createRegisterWallerUrl(Wallet wallet) {
        return String.format("http://localhost:8081/wallets/register?coinSymbol=%s&address=%s", wallet.getCoin().getName(), wallet.getAddress());
    }

}
