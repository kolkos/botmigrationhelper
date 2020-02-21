package nl.kolkos.botmigrationhelper.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "results")
public class CoinValue {

    @Id
    private Long id;

    private Date timestamp;
    private long requestId; // won't use it

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    private long balanceSatoshi;
    private double balanceCoin;

    private String currency;





}
