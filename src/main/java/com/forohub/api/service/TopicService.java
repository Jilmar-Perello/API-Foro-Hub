package com.forohub.api.service;

import com.forohub.api.dto.TopicRequestDTO;
import com.forohub.api.dto.TopicResponseDTO;
import com.forohub.api.entity.Topic;
import com.forohub.api.repository.TopicRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TopicService {

    private final TopicRepository repository;

    public TopicService(TopicRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public TopicResponseDTO crear(TopicRequestDTO dto) {
        Topic topic = new Topic();
        topic.setTitulo(dto.titulo());
        topic.setMensaje(dto.mensaje());
        topic.setFechaCreacion(LocalDateTime.now());

        Topic saved = repository.save(topic);

        return new TopicResponseDTO(saved);
    }

    // READ ALL
    public List<TopicResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(TopicResponseDTO::new)
                .toList();
    }

    // READ ONE
    public TopicResponseDTO obtenerPorId(Long id) {
        Topic topic = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico no encontrado"));

        return new TopicResponseDTO(topic);
    }

    // DELETE (opcional ya)
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Tópico no encontrado");
        }
        repository.deleteById(id);
    }
}