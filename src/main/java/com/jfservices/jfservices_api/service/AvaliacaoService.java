package com.jfservices.jfservices_api.service;

import com.jfservices.jfservices_api.model.Avaliacao;
import com.jfservices.jfservices_api.repository.AvaliacaoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AvaliacaoService {

    private final AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public List<Avaliacao> buscarTodas() {
        return avaliacaoRepository.findAll();
    }

    public Avaliacao salvar(Avaliacao avaliacao) {
        if (avaliacao.getEstrelas() < 1 || avaliacao.getEstrelas() > 5) {
            throw new RuntimeException("A avaliação deve ser de 1 a 5 estrelas.");
        }
        return avaliacaoRepository.save(avaliacao);
    }
}
