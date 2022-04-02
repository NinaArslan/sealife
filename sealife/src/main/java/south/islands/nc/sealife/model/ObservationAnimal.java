package south.islands.nc.sealife.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ObservationAnimal {


    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private ObservationSheet observationSheet;

    @OneToOne
    private Animal animal;

    private int size;

    private boolean isBank;

    private int apneaTime;

}
