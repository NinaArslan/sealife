package south.islands.nc.sealife.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
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

}

