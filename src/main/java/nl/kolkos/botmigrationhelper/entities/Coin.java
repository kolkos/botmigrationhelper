package nl.kolkos.botmigrationhelper.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@Table(name = "coins")
public class Coin {
    @Id
    private long id;
    private String name;
    private String description;

    public Coin(String name, String description){
        this.name = name;
        this.description = description;
    }
}
