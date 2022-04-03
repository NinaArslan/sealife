package south.islands.nc.sealife.models;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    @NotBlank(message = "L'id de l'île doit être renseigné")
    private String islandId;

    private String islandName;

    @NotNull(message = "Distance de l'île doit être renseignée")
    private int distanceFromIsland;

    @NotNull(message = "Date et heure doivent être renseignée")
    private LocalDateTime observationDate;

    @NotNull(message = "Qualité d'observation doit être renseignée")
    @Enumerated(EnumType.STRING)
    private QualityObservation qualityObservation;

}

