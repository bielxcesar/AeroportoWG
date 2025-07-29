package com.wgAeroporto.controller;

import com.wgAeroporto.facade.PassageiroFacade;
import com.wgAeroporto.model.entity.PassageiroEntity;
import com.wgAeroporto.service.PassageiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*") // Permitir requisições de qualquer origem
@RequestMapping("/passageiros")
public class PassageiroController {

    private final PassageiroFacade passageiroFacade;

    @Autowired
    public PassageiroController(PassageiroFacade passageiroFacade) {
        this.passageiroFacade = passageiroFacade;
    }

    //---------------------------------Listar Tudo-------------------
    @GetMapping
    public ResponseEntity<List<PassageiroEntity>> listarTodosPassageiros() {
        return ResponseEntity.ok(passageiroFacade.listarTodosPassageiros());
    }

    //---------------------------------Buscar Passageiro Por ID-------------------
    @GetMapping("/id/{id}")
    public ResponseEntity<PassageiroEntity> buscarPassageiroPorId(@PathVariable Long id) {
        PassageiroEntity passageiro = passageiroFacade.buscarPassageiroPorId(id).orElse(null);

        if (passageiro == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(passageiro);
    }

    //---------------------------------Adicionar Passageiro-------------------
    @PostMapping("/add")
    public ResponseEntity<PassageiroEntity> salvarPassageiro(@RequestBody PassageiroEntity passageiro) {
        passageiroFacade.salvarPassageiro(passageiro);
        return ResponseEntity.ok(passageiro);
    }

    //---------------------------------Deletar Passageiro-------------------
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletarPassageiro(@PathVariable Long id) {
        passageiroFacade.deletarPassageiro(id);
        return ResponseEntity.noContent().build();
    }

    //---------------------------------Atualizar Passageiro-------------------
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<PassageiroEntity> atualizarPassageiro(@PathVariable Long id, @RequestBody PassageiroEntity passageiroAtualizado) {
        return passageiroFacade.buscarPassageiroPorId(id).map(passageiroExistente -> {
            passageiroExistente.setNome(passageiroAtualizado.getNome());
            passageiroExistente.setSobrenome(passageiroAtualizado.getSobrenome());
            passageiroExistente.setDataNascimento(passageiroAtualizado.getDataNascimento());
            passageiroExistente.setGenero(passageiroAtualizado.getGenero());
            passageiroExistente.setEmail(passageiroAtualizado.getEmail());
            passageiroExistente.setCelular(passageiroAtualizado.getCelular());
            passageiroExistente.setCpf(passageiroAtualizado.getCpf());

            PassageiroEntity passageiroSalvo = passageiroFacade.salvarPassageiro(passageiroExistente);
            return ResponseEntity.ok(passageiroSalvo);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
