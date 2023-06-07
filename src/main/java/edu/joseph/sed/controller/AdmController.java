package edu.joseph.sed.controller;

import edu.joseph.sed.dto.DtoAdm;
import edu.joseph.sed.dto.DtoUser;
import edu.joseph.sed.dto.InputDtoPersonUser;
import edu.joseph.sed.model.Adm;
import edu.joseph.sed.service.AdmService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/adm")
@AllArgsConstructor
public class AdmController {

    private final AdmService admService;

    @GetMapping
    public ResponseEntity<DtoUser> showUserDataAdm(@RequestParam @Valid String cpf) {
        var obj = admService.showUserdata(cpf);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(value = "/personal")
    public ResponseEntity<DtoAdm> showPersonaldataAdm(@RequestParam @Valid String cpf) {
        var obj = admService.showPersonaldata(cpf);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<DtoUser> newAdm(@RequestBody InputDtoPersonUser input) {
        var dtoObj = admService.createAdm(input.getPerson(), input.getUser());
        return ResponseEntity.status(201).body(dtoObj);
    }

    @PutMapping
    public ResponseEntity<DtoUser> deactivateAdm(@RequestParam @Valid String cpf) {
        var obj = admService.deactivateAdm(cpf);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(value = "/{cpf}")
    public ResponseEntity<DtoAdm> updatepersonalAdm(@PathVariable String cpf,
                                                    @RequestBody Adm obj) {
        obj = admService.updateAdm(cpf, obj);
        return ResponseEntity.ok().body(obj.toDto());
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAdm(@RequestParam @Valid String cpf) {
        admService.excludeAdm(cpf);
        return ResponseEntity.noContent().build();
    }
}
