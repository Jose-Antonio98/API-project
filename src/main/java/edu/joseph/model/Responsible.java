package edu.joseph.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Embeddable
@Entity
@Table(name = "tb_responsible")
@Builder
@NoArgsConstructor
public class Responsible extends Person{

    @ManyToOne
    @JoinColumn(name = "children_id")
    private Student children;

    //Role

}
