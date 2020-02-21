package nl.kolkos.botmigrationhelper.services;

import nl.kolkos.botmigrationhelper.entities.Coin;
import nl.kolkos.botmigrationhelper.repositories.CoinRepository;
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
public class CoinService {

    private final static Logger LOGGER = LoggerFactory.getLogger(CoinService.class);

    private CoinRepository coinRepository;
    private RestClient restClient;

    @Autowired
    public CoinService(CoinRepository coinRepository, RestClient restClient) {
        this.coinRepository = coinRepository;
        this.restClient = restClient;
    }

    public void migrateCoins(){
        List<Coin> coins = coinRepository.findAll();

        LOGGER.info("Number of coins found: {}", coins.size());

        for(Coin coin : coins){
            this.registerCoin(coin);
        }
    }


    public void registerCoin(Coin coin) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String response = restClient.doRestRequest(headers, HttpMethod.GET, createRegisterCoinUrl(coin));
        LOGGER.info(response);
    }

    private String createRegisterCoinUrl(Coin coin) {
        return String.format("http://localhost:8081/coins/register?coinName=%s&symbol=%s", coin.getDescription(), coin.getName());
    }


}
