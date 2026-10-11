package com.jfservices.jfservices_api.controller;

import com.jfservices.jfservices_api.model.Prestador;
import com.jfservices.jfservices_api.service.PrestadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestadores")
public class ControllerPrestador {

    private final PrestadorService prestadorService;

    public ControllerPrestador(PrestadorService prestadorService) {
        this.prestadorService = prestadorService;
    }

    @GetMapping
    public ResponseEntity<List<Prestador>> listarTodos() {
        List<Prestador> prestadores = prestadorService.buscarTodos();
        return ResponseEntity.ok(prestadores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prestador> buscarPorId(@PathVariable Long id) {
        return prestadorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Prestador> criar(@RequestBody Prestador prestador) {
        Prestador novoPrestador = prestadorService.salvar(prestador);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPrestador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        prestadorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
