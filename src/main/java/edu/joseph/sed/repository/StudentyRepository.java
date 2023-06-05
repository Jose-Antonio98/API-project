package edu.joseph.sed.repository;

import edu.joseph.sed.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentyRepository extends JpaRepository<Student, Long> {
}
