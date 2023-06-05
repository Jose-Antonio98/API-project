package edu.joseph.sed.controller;

import edu.joseph.sed.dto.AdmDto;
import edu.joseph.sed.model.Adm;
import edu.joseph.sed.service.AdmService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/adm")
@AllArgsConstructor
public class AdmController {

    AdmService admService;

    @GetMapping
    public ResponseEntity<AdmDto> showAdm(@RequestParam @Valid String cpf){
        var obj = admService.showAdm(cpf);
        var objDto = obj.toDto();
        return ResponseEntity.ok(objDto);
    }
}
