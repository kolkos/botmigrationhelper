package nl.kolkos.botmigrationhelper.repositories;

import nl.kolkos.botmigrationhelper.entities.CoinValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinValueRepository extends JpaRepository<CoinValue, Long> {


}
