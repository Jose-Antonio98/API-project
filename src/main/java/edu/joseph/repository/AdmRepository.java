package edu.joseph.repository;

import edu.joseph.model.ADM;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdmRepository extends JpaRepository<ADM, Long> {

    public ADM findByCpf(String cpf);

    boolean existsCPF(@CPF String cpf);
}
