package lucadipietro.U5_W2_D5__Progetto_Finale.entities;

import jakarta.persistence.*;
import lombok.*;
import lucadipietro.U5_W2_D5__Progetto_Finale.enums.StatoDispositivo;
import lucadipietro.U5_W2_D5__Progetto_Finale.enums.TipoDispositivo;

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
    @Enumerated(EnumType.STRING)
    private TipoDispositivo tipo;
    @Enumerated(EnumType.STRING)
    private StatoDispositivo stato;
    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;

    public Dispositivo(TipoDispositivo tipo, StatoDispositivo stato, Dipendente dipendente) {
        this.tipo = tipo;
        this.stato = stato;
        this.dipendente = dipendente;
    }
}
