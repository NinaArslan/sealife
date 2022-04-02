package south.islands.nc.sealife.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Animal {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private Specie specie;
}
