package south.islands.nc.sealife.Entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
public class ObservationSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String islandId;

    private int distanceFromIsland;

    private LocalDateTime observationDate;

    @Enumerated(EnumType.STRING)
    private QualityObservation qualityObservation;

    @OneToOne
    @JoinTable(name = "ANIMAL")
    private Animal animal;

}

