package edu.joseph.sed.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Data
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank
    @Column(length = 100)
    String name;

    @Max(12)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "##.###.###-#")
    @Column(unique = true)
    private String rg;

    @CPF
    @Column(unique = true)
    private String cpf;

    @NotBlank
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate birthDate;

    @NotBlank
    @Size(max = 40, message = "Invalid size")
    private String nationality;

}
