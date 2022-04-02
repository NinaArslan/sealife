package south.islands.nc.sealife.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Specie {

    @Id
    @GeneratedValue
    private Long id;

    private String specieName;

}
