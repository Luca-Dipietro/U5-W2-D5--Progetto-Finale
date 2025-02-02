package lucadipietro.U5_W2_D5__Progetto_Finale.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record DipendentiDTO(
        @NotEmpty(message = "L'username è un dato obbligatorio!")
        @Size(min = 4, max = 20, message = "L'username deve essere compreso tra i 4 e 20 caratteri!") String username,
        @NotEmpty(message = "Il nome è un dato obbligatorio!")
        @Size(min = 3, max = 20, message = "Il nome deve essere compreso tra i 3 e 20 caratteri!") String nome,
        @NotEmpty(message = "Il cognome è un dato obbligatorio!")
        @Size(min = 3, max = 20, message = "Il cognome deve essere compreso tra i 3 e 20 caratteri!") String cognome,
        @NotEmpty(message = "L'email è un dato obbligatorio!")
        @Email(message = "Il formato dell'email non è corretto!") String email)
{}
