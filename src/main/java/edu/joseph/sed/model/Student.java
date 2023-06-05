package edu.joseph.sed.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.joseph.sed.model.Enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;


@Builder
@Entity
@Table(name = "tb_student")
@NoArgsConstructor
@AllArgsConstructor
public class Student extends Person{

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

    @Embedded
    @ManyToOne
    private Responsible responsible;

    private int age;

    private Status status;

    //classes um aluno pode ter varias classes desde que os anos
    //sejam diferentes

    //responsavel um aluno pode ter apenas um responsavel

    //Unidade escolar

    // role
}
