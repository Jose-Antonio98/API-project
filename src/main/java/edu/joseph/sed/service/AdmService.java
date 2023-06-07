package edu.joseph.sed.service;

import edu.joseph.sed.dto.DtoAdm;
import edu.joseph.sed.dto.DtoUser;
import edu.joseph.sed.model.Adm;
import edu.joseph.sed.model.User;
import edu.joseph.sed.repository.AdmRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;

@Service
@AllArgsConstructor
public class AdmService {

    AdmRepository admRepository;

    //Exibir
    @Transactional(readOnly = true)
    public DtoAdm showPersonaldata(String cpf) {
        if (admRepository.existsByCpf(cpf)) {
            var obj = admRepository.findByCpf(cpf);
            return obj.toDto();
        }
        return null;
    }

    @Transactional(readOnly = true)
    public DtoUser showUserdata(String cpf) {
        if (admRepository.existsByCpf(cpf)) {
            var obj = admRepository.findByCpf(cpf);
            return obj.toUserDto();
        }
        return null;
    }

    //criar adm
    @Transactional
    public DtoUser createAdm(Adm person, User user) {
        var dbObj = Adm.builder().name(person.getName()).rg(person.getRg())
                .cpf(person.getCpf()).birthDate(person.getBirthDate())
                .nationality(person.getNationality()).email(person.getEmail())
                .user(User.builder().userName(user.getUserName()).password(user.getPassword())
                        .build()).build();
        dbObj.getUser().permissionsUser();
        admRepository.save(dbObj);
        return dbObj.toUserDto();
    }

    //TODO excluir
    @Transactional
    public DtoUser deactivateAdm(String cpf) {
        if (admRepository.existsByCpf(cpf)) {
            var obj = admRepository.findByCpf(cpf);
            obj.getUser().removepermissions();
            updateAdm(obj.getCpf(), obj);
            return obj.toUserDto();
        }
        return null;
    }

    public void excludeAdm(String cpf) {
        if (admRepository.existsByCpf(cpf)) {
            var obj = admRepository.findByCpf(cpf);
            admRepository.delete(obj);
        }
    }

    //atualizar
    @Transactional
    public Adm updateAdm(String cpf, Adm obj) {
        var updateEntity = admRepository.getReferenceByCpf(cpf);
        updateData(updateEntity, obj);
        return admRepository.save(updateEntity);
    }

    //Auxiliares
    private void updateData(Adm entity, Adm newEntity) {
        Field[] fields = newEntity.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(newEntity);
                if (value != null) {
                    field.set(entity, value);
                }
            } catch (IllegalAccessException e) {
                e.getMessage();
            }
        }
    }
}