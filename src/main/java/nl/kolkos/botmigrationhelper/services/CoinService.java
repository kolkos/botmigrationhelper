package nl.kolkos.botmigrationhelper.services;

import nl.kolkos.botmigrationhelper.entities.Coin;
import nl.kolkos.botmigrationhelper.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CoinService {

    private CoinRepository coinRepository;
    private RestClient restClient;

    @Autowired
    public CoinService(CoinRepository coinRepository, RestClient restClient) {
        this.coinRepository = coinRepository;
        this.restClient = restClient;
    }

    public void migrateCoins(){
        List<Coin> coins = coinRepository.findAll();

        System.out.println(coins.size());

        for(Coin coin : coins){
            this.registerCoin(coin);
        }
    }


    public void registerCoin(Coin coin) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String response = restClient.doRestRequest(headers, HttpMethod.GET, formRegisterCoinUrl(coin));
        System.out.println(response);
    }

    private String formRegisterCoinUrl(Coin coin) {
        return String.format("http://localhost:8081/coins/register?coinName=%s&symbol=%s", coin.getDescription(), coin.getName());
    }


}
