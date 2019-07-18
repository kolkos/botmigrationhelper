package nl.kolkos.botmigrationhelper.repositories;

import nl.kolkos.botmigrationhelper.entities.Coin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoinRepository extends JpaRepository<Coin, Long> {
    Optional<Coin> findById(Long id);
}
