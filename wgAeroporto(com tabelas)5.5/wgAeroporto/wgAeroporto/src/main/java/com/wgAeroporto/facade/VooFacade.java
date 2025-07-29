package com.wgAeroporto.facade;

import com.wgAeroporto.model.entity.VooEntity;
import com.wgAeroporto.service.VooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VooFacade {
    private final VooService vooService;

    @Autowired
    public VooFacade(VooService vooService) {
        this.vooService = vooService;
    }

    public Optional<VooEntity> buscarVooPorId(Long id) {
        return vooService.buscarVooPorId(id);
    }

    public List<VooEntity> listarTodosVoos() {
        return vooService.listarTodosVoos();
    }

    public VooEntity salvarVoo(VooEntity voo) {
        return vooService.salvarVoo(voo);
    }

    public void deletarVoo(long id) {
        vooService.deletarVoo(id);
    }
}