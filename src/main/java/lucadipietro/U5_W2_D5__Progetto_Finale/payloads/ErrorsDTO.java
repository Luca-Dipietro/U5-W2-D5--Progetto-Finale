package lucadipietro.U5_W2_D5__Progetto_Finale.payloads;

import java.time.LocalDateTime;

public record ErrorsDTO(String message, LocalDateTime timeStamp) {
}
