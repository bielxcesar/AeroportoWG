package com.wgAeroporto.controller;

import com.wgAeroporto.facade.VooFacade;
import com.wgAeroporto.model.entity.VooEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*") // Permite chamadas de qualquer origem
@RequestMapping("/Voos")
public class VooController {

    private final VooFacade vooFacade;

    @Autowired
    public VooController(VooFacade vooFacade) {
        this.vooFacade = vooFacade;
    }

    //---------------------------------Listar Tudo-------------------
    @GetMapping
    public ResponseEntity<List<VooEntity>> listarTodosVoos() {
        return ResponseEntity.ok(vooFacade.listarTodosVoos());
    }
    //---------------------------------Buscar Voo Por ID-------------------
    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<VooEntity>> buscarVooPorId(@PathVariable Long id){
        Optional<VooEntity> voo = vooFacade.buscarVooPorId(id);
        return voo.isPresent() ? ResponseEntity.ok(voo) : ResponseEntity.notFound().build();
    }

    //---------------------------------Adicionar Voo-------------------
    @PostMapping("/add")
    public ResponseEntity<VooEntity> salvarVoo(@RequestBody VooEntity voo) {
        vooFacade.salvarVoo(voo);
        return ResponseEntity.ok(voo);
    }
    //---------------------------------Adicionar Passageiro-------------------
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<VooEntity> atualizarVoo(@PathVariable Long id, @RequestBody VooEntity atualizarVoo) {
        return vooFacade.buscarVooPorId(id).map(VoooExistente-> {
            VoooExistente.setDiaIda(atualizarVoo.getDiaIda());
            VoooExistente.setHoraIda(atualizarVoo.getHoraIda());
            VoooExistente.setDiaVolta(atualizarVoo.getDiaVolta());
            VoooExistente.setHoraVolta(atualizarVoo.getHoraVolta());

            VooEntity vooSalvo = vooFacade.salvarVoo(VoooExistente);
            return ResponseEntity.ok(vooSalvo);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }


    //---------------------------------Deletar Passageiro-------------------
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletarVoo(@PathVariable Long id) {
        vooFacade.deletarVoo(id);
        return ResponseEntity.noContent().build();
    }

}
