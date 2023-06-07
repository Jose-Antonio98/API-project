package edu.joseph.sed.repository;

import edu.joseph.sed.model.Adm;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdmRepository extends JpaRepository<Adm, Long> {

    public Adm findByCpf(String cpf);

    boolean existsByCpf(@CPF String cpf);

    Adm getReferenceByCpf(String cpf);
}
