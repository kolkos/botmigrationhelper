package nl.kolkos.botmigrationhelper.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "wallets")
public class Wallet {

    @Id
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coin_id")
    private Coin coin;

    private String address;

}
