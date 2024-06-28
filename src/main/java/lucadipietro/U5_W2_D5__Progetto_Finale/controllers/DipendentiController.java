package lucadipietro.U5_W2_D5__Progetto_Finale.controllers;

import lucadipietro.U5_W2_D5__Progetto_Finale.entities.Dipendente;
import lucadipietro.U5_W2_D5__Progetto_Finale.exceptions.BadRequestException;
import lucadipietro.U5_W2_D5__Progetto_Finale.payloads.DipendentiDTO;
import lucadipietro.U5_W2_D5__Progetto_Finale.services.DipendentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/dipendenti")
public class DipendentiController {
    @Autowired
    private DipendentiService dipendentiService;

    @GetMapping
    public Page<Dipendente> getAllBlogPosts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy){
        return this.dipendentiService.getDipendenti(page,size,sortBy);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Dipendente saveDipendente(@RequestBody @Validated DipendentiDTO body, BindingResult validationResult){
        if(validationResult.hasErrors()){
            throw new BadRequestException(validationResult.getAllErrors());
        } else {
            return this.dipendentiService.save(body);
        }
    }

    @GetMapping("/{dipendenteId}")
    private Dipendente findById(@PathVariable UUID dipendenteId){
        return this.dipendentiService.findById(dipendenteId);
    }

    @PutMapping("/{dipendenteId}")
    private Dipendente findByIdAndUpdate(@PathVariable UUID dipendenteId,@RequestBody @Validated DipendentiDTO body,BindingResult validationResult){
        if(validationResult.hasErrors()){
            throw new BadRequestException(validationResult.getAllErrors());
        }else {
            return this.dipendentiService.findByIdAndUpdate(dipendenteId,body);
        }
    }

    @DeleteMapping("/{dipendenteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable UUID dipendenteId){
        this.dipendentiService.findByIdAndDelete(dipendenteId);
    }

    @PatchMapping("/{dipendenteId}/avatar")
    public Dipendente uploadAvatar(@PathVariable UUID dipendenteId, @RequestParam("avatar") MultipartFile image) throws IOException {
        return this.dipendentiService.uploadImage(dipendenteId, image);
    }
}
