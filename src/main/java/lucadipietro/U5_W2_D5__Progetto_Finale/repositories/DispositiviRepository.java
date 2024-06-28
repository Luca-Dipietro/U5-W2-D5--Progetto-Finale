package lucadipietro.U5_W2_D5__Progetto_Finale.repositories;

import lucadipietro.U5_W2_D5__Progetto_Finale.entities.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DispositiviRepository extends JpaRepository<Dispositivo, UUID> {
}
