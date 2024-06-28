package lucadipietro.U5_W2_D5__Progetto_Finale.services;

import lucadipietro.U5_W2_D5__Progetto_Finale.entities.Dipendente;
import lucadipietro.U5_W2_D5__Progetto_Finale.exceptions.BadRequestException;
import lucadipietro.U5_W2_D5__Progetto_Finale.exceptions.NotFoundException;
import lucadipietro.U5_W2_D5__Progetto_Finale.payloads.DipendentiDTO;
import lucadipietro.U5_W2_D5__Progetto_Finale.repositories.DipendentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DipendentiService {
    @Autowired
    private DipendentiRepository dipendentiRepository;

    public Page<Dipendente> getDipendenti(int pageNumber, int pageSize, String sortBy){
        if(pageSize > 50) pageSize = 50;
        Pageable pageable = PageRequest.of(pageNumber,pageSize, Sort.by(sortBy));
        return dipendentiRepository.findAll(pageable);
    }

    public Dipendente save(DipendentiDTO body){
        this.dipendentiRepository.findByUsername(body.username()).ifPresent(
                dipendente -> {
                    throw new BadRequestException("Esiste già un dipendente con questo username " + body.username());
                }
        );
        this.dipendentiRepository.findByEmail(body.email()).ifPresent(
                dipendente -> {
                    throw new BadRequestException("Esiste già un dipendente con questa email " + body.email());
                }
        );
        Dipendente newDipendente = new Dipendente(body.username(), body.nome(), body.cognome(), body.email());
        newDipendente.setAvatar("https://ui-avatars.com/api/?name=" + body.nome() + "+" + body.cognome());
        return this.dipendentiRepository.save(newDipendente);
    }

    public Dipendente findById(UUID dipendenteId) {
        return this.dipendentiRepository.findById(dipendenteId).orElseThrow(() -> new NotFoundException(dipendenteId));
    }

    public Dipendente findByIdAndUpdate(UUID dipendenteId, Dipendente updateDipendente){
        Dipendente found = this.findById(dipendenteId);
        found.setUsername(updateDipendente.getUsername());
        found.setNome(updateDipendente.getNome());
        found.setCognome(updateDipendente.getCognome());
        found.setEmail(updateDipendente.getEmail());
        found.setAvatar("https://ui-avatars.com/api/?name=" + updateDipendente.getNome() + "+" + updateDipendente.getCognome());
        return this.dipendentiRepository.save(found);
    }

    public void findByIdAndDelete(UUID dipendenteId) {
        Dipendente found = this.findById(dipendenteId);
        this.dipendentiRepository.delete(found);
    }
}
