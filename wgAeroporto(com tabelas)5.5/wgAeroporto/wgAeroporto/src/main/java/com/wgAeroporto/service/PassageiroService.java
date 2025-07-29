package com.wgAeroporto.service;

import com.wgAeroporto.model.entity.PassageiroEntity;
import com.wgAeroporto.model.dao.PassageiroRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassageiroService {
    private final PassageiroRepository repository;

    @Autowired
    public PassageiroService(PassageiroRepository repository) {
        this.repository = repository;
    }

    public Optional<PassageiroEntity> buscarPassageiroPorId(Long id) {
        return repository.findById(id);
    }

    public List<PassageiroEntity> listarTodosPassageiros() {
        return repository.findAll();
    }

    public PassageiroEntity salvarPassageiro(PassageiroEntity passageiro) {
        return repository.save(passageiro);
    }

    public void deletarPassageiro(Long id) {
        repository.deleteById(id);
    }
}