package edu.joseph.model;

import edu.joseph.model.Enums.Subjects;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_teacher")
@Builder
@NoArgsConstructor
public class Teacher extends Person{

    private List<Subjects> subjects;

    //Role
}
