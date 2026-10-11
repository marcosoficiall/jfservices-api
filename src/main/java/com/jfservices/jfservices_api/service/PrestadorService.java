package com.jfservices.jfservices_api.service;

import com.jfservices.jfservices_api.model.Prestador;
import com.jfservices.jfservices_api.repository.PrestadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestadorService {

    private final PrestadorRepository prestadorRepository;

    public PrestadorService(PrestadorRepository prestadorRepository) {
        this.prestadorRepository = prestadorRepository;
    }

    public List<Prestador> buscarTodos() {
        return prestadorRepository.findAll();
    }

    public Optional<Prestador> buscarPorId(Long id) {
        return prestadorRepository.findById(id);
    }

    public Prestador salvar(Prestador prestador) {
        Optional<Prestador> prestadorExistente = prestadorRepository.findByEmail(prestador.getEmail());
        if (prestadorExistente.isPresent()) {
            throw new RuntimeException("Este e-mail já está cadastrado para um prestador.");
        }
        return prestadorRepository.save(prestador);
    }

    public void deletar(Long id) {
        prestadorRepository.deleteById(id);
    }
}
