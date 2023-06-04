package edu.joseph.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Builder
@Entity
@Table(name = "tb_student")
@NoArgsConstructor
public class Student extends Person{


    @Embedded
    @ManyToOne
    private Responsible responsible;


    //classes um aluno pode ter varias classes desde que os anos
    //sejam diferentes

    //responsavel um aluno pode ter apenas um responsavel

    //Unidade escolar

    // role
}
