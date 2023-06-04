package edu.joseph.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Embeddable
@Entity
@Table(name = "tb_responsible")
public class Responsible extends Person{

    @ManyToOne
    @JoinColumn(name = "children_id")
    private Student children;

    //Role

}
