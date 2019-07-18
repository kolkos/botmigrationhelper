package nl.kolkos.botmigrationhelper.repositories;

import nl.kolkos.botmigrationhelper.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {


}
