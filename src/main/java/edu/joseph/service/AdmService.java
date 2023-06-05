package edu.joseph.service;

import edu.joseph.model.ADM;
import edu.joseph.model.Enums.Roles;
import edu.joseph.model.Enums.Status;
import edu.joseph.repository.AdmRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdmService {

    AdmRepository admRepository;

    //Exibir
    @Transactional(readOnly = true)
    public ADM showAdm(String cpf){
        if (admRepository.existsCPF(cpf)){
            var obj = admRepository.findByCpf(cpf);
            return obj;
        }
        return null;
    }

    //criar adm
    @Transactional
    public ADM creatAdm(ADM obj){
        if(admRepository.existsCPF(obj.getCpf())) {
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
        if (admRepository.existsCPF(cpf)){
            var obj = admRepository.findByCpf(cpf);
            obj.setRole(null);
            obj.setStatus(Status.INACTIVE);
        }
    }

    public void excludeAdm(String cpf){
        if (admRepository.existsCPF(cpf)){
            var obj = admRepository.findByCpf(cpf);
            admRepository.delete(obj);
        }
    }

    //atualizar
    @Transactional
    public ADM updateAdm(String cpf, ADM obj){
        var updateEntity = admRepository.findByCpf(cpf);
        if (updateEntity != null){
            updateData(updateEntity, obj);
            return admRepository.save(updateEntity);
        }
        return null;
    }

    //Auxiliares
    private void updateData(ADM entity, ADM newEntity) {
        entity.setName(newEntity.getName());
        entity.setUserName(newEntity.getUserName());
        entity.setPassword(newEntity.getPassword());
        entity.setStatus(newEntity.getStatus());
        entity.setRole(newEntity.getRole());
    }
}
