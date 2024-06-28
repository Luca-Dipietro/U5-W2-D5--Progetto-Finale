package lucadipietro.U5_W2_D5__Progetto_Finale.entities;

import jakarta.persistence.*;
import lombok.*;
import lucadipietro.U5_W2_D5__Progetto_Finale.enums.StatoDispositivo;

import java.util.UUID;

@Entity
@Table(name = "dispositivi")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Dispositivo {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;
    @Column(name = "tipo_dispositivo")
    private String tipoDispositivo;
    @Enumerated(EnumType.STRING)
    private StatoDispositivo stato;
    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;

    public Dispositivo(String tipoDispositivo, StatoDispositivo stato) {
        this.tipoDispositivo = tipoDispositivo;
        this.stato = stato;
        this.dipendente = null;
    }
}
