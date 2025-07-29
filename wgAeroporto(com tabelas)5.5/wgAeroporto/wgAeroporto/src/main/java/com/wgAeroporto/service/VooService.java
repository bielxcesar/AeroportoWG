package com.wgAeroporto.service;

import com.wgAeroporto.model.dao.VooRepository;
import com.wgAeroporto.model.entity.VooEntity;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VooService {
    private final VooRepository repository;

    @Autowired
    public VooService(VooRepository repository) {
        this.repository = repository;
    }

    public Optional<VooEntity> buscarVooPorId(Long id) {
        return repository.findById(id);
    }

    public List<VooEntity> listarTodosVoos() {
        return repository.findAll();
    }

    public VooEntity salvarVoo(VooEntity voo) {
        return repository.save(voo);
    }

    public void deletarVoo(long id) {
        repository.deleteById(id);
    }
}
