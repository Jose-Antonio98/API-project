package edu.joseph.sed.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.joseph.sed.dto.DtoAdm;
import edu.joseph.sed.dto.DtoUser;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

@Embeddable
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
    @Pattern(regexp = "^(0[1-9]|1\\d|2\\d|3[01])-(0[1-9]|1[0-2])-\\d{4}$")
    private String birthDate;

    @NotBlank
    @Size(max = 40, message = "Invalid size")
    private String nationality;

    @NotBlank
    @Email
    private String email;

    @Embedded
    private User user;


    public DtoAdm toDto(){
        return DtoAdm.builder()
                .name(name)
                .rg(rg)
                .cpf(cpf)
                .nationality(nationality)
                .birthDate(birthDate)
                .email(email)
                .build();
    }

    public DtoUser toUserDto(){
        return DtoUser.builder()
                .userName(user.getUserName())
                .status(user.getStatus())
                .role(user.getRole()).build();
    }
}
