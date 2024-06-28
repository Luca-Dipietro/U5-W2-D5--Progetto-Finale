package lucadipietro.U5_W2_D5__Progetto_Finale.payloads;

import jakarta.validation.constraints.NotEmpty;

import java.util.UUID;

public record DispositiviDTO(
        @NotEmpty(message = "Il tipo del dispositivo è obbligatorio") String tipo,
        @NotEmpty(message = "Lo stato del dispositivo è obbligatorio") String stato,
        UUID dipendenteId)
{}
