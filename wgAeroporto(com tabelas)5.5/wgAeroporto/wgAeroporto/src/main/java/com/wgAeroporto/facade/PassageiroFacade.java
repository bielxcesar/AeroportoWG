package com.wgAeroporto.facade;

import com.wgAeroporto.model.entity.PassageiroEntity;
import com.wgAeroporto.service.PassageiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PassageiroFacade {
    private final PassageiroService passageiroService;

    @Autowired
    public PassageiroFacade(PassageiroService passageiroService){
        this.passageiroService = passageiroService;
    }

    public Optional<PassageiroEntity> buscarPassageiroPorId (long id){
        return passageiroService.buscarPassageiroPorId(id);
    }

    public List<PassageiroEntity> listarTodosPassageiros(){
        return passageiroService.listarTodosPassageiros();
    }

    public PassageiroEntity salvarPassageiro(PassageiroEntity passageiro){
        return passageiroService.salvarPassageiro(passageiro);
    }
    public void deletarPassageiro(long id){
        passageiroService.deletarPassageiro(id);
    }
}
