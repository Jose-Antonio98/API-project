package edu.joseph.sed.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.joseph.sed.dto.AdmDto;
import edu.joseph.sed.model.Enums.Roles;
import edu.joseph.sed.model.Enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "tb_adm")
public class Adm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    Long id;

    @NotBlank
    @Column(length = 100)
    String name;

    @Size(max = 12, message = "Invalid size for RG")
    @Pattern(regexp = "\\d{2}\\.\\d{3}\\.\\d{3}-\\d")
    @Column(unique = true)
    private String rg;

    @CPF
    @Column(unique = true)
    private String cpf;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate birthDate;

    @NotBlank
    @Size(max = 40, message = "Invalid size")
    private String nationality;

    @NotBlank
    @Size(max = 25, message = "Invalid size")
    private String userName;

    @NotBlank
    @Size(max = 25, message = "Invalid size")
    private String password;

    private Status status;

    private Roles role;

    public AdmDto toDto(){
        return new AdmDto(name, rg, cpf, birthDate, nationality);
    }

}
