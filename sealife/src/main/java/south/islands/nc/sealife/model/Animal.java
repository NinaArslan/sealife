package south.islands.nc.sealife.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(targetEntity = Specie.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "SPECIE_ID")
    private Specie specie;
}
