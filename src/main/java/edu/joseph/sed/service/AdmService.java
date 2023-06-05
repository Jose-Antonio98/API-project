package edu.joseph.sed.service;

import edu.joseph.sed.model.Adm;
import edu.joseph.sed.model.Enums.Roles;
import edu.joseph.sed.model.Enums.Status;
import edu.joseph.sed.repository.AdmRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class AdmService {

    AdmRepository admRepository;

    //Exibir
    @Transactional(readOnly = true)
    public Adm showAdm(String cpf){
        if (admRepository.existsByCpf(cpf)){
            var obj = admRepository.findByCpf(cpf);
            return obj;
        }
        return null;
    }

    //criar adm
    @Transactional
    public Adm creatAdm(Adm obj){
        if(admRepository.existsByCpf(obj.getCpf())) {
            updateAdm(obj.getCpf(), obj);
            obj.setStatus(Status.ACTIVE);
            return admRepository.save(obj);
        }else{
            obj.setRole(Roles.ADM);
            obj.setStatus(Status.ACTIVE);
            return admRepository.save(obj);
        }
    }

    //TODO excluir
    @Transactional
    public void deactivateAdm(String cpf){
        if (admRepository.existsByCpf(cpf)){
            var obj = admRepository.findByCpf(cpf);
            obj.setRole(null);
            obj.setStatus(Status.INACTIVE);
        }
    }

    public void excludeAdm(String cpf){
        if (admRepository.existsByCpf(cpf)){
            var obj = admRepository.findByCpf(cpf);
            admRepository.delete(obj);
        }
    }

    //atualizar
    @Transactional
    public Adm updateAdm(String cpf, Adm obj){
        var updateEntity = admRepository.findByCpf(cpf);
        if (updateEntity != null){
            updateData(updateEntity, obj);
            return admRepository.save(updateEntity);
        }
        return null;
    }

    //Auxiliares
    private void updateData(Adm entity, Adm newEntity) {
        entity.setName(newEntity.getName());
        entity.setUserName(newEntity.getUserName());
        entity.setPassword(newEntity.getPassword());
        entity.setStatus(newEntity.getStatus());
        entity.setRole(newEntity.getRole());
    }
}
