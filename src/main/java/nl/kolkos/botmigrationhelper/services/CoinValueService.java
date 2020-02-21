package nl.kolkos.botmigrationhelper.services;

import nl.kolkos.botmigrationhelper.entities.CoinValue;
import nl.kolkos.botmigrationhelper.repositories.CoinValueRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CoinValueService {

    private CoinValueRepository coinValueRepository;

    @Autowired
    public CoinValueService(CoinValueRepository coinValueRepository) {
        this.coinValueRepository = coinValueRepository;
    }


    public void migrateCoinValues() {

    }

    public void registerCoinValue(CoinValue coinValue) {

    }

    private String createRegisterCoinValue(CoinValue coinValue) {
        return String.format("http://localhost:8081/coins/register?coinName=%s&symbol=%s", coin.getDescription(), coin.getName());
//        return null;
    }

}
