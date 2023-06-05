package edu.joseph.sed.testmodel;

import edu.joseph.sed.model.Adm;
import edu.joseph.sed.repository.AdmRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;

@Configuration
@Profile("test")
@AllArgsConstructor
public class test implements CommandLineRunner {

    private final AdmRepository admRepository;

    @Override
    public void run(String... args) throws Exception {
        var a1 = Adm.builder().id(null).name("josé").rg("12.345.678-9").cpf("485.136.948-43")
                .birthDate(LocalDate.parse("1998-02-04")).nationality("Brasileiro")
                .userName("Joseph").password("123456").build();

        admRepository.save(a1);
    }
}
