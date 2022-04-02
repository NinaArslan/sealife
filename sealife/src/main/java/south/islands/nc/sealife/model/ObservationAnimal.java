package south.islands.nc.sealife.model;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ObservationAnimal {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private ObservationSheet observationSheet;

    @OneToOne
    private Animal animal;

    private int size;

    private boolean isBank;

    private int apneaTime;

}
