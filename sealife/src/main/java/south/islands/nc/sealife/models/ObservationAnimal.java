package south.islands.nc.sealife.models;

import lombok.*;
import org.springframework.lang.Nullable;

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

    @OneToOne(targetEntity = ObservationSheet.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "OBSERVATION_SHEET_ID")
    private ObservationSheet observationSheet;

    @OneToOne(targetEntity = Animal.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ANIMAL_ID")
    private Animal animal;

    private int size;

    private Boolean isBank;

    @Nullable
    private int apneaTime;

}
