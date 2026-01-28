package com.forohub.api.controller;

import com.forohub.api.dto.TopicRequestDTO;
import com.forohub.api.dto.TopicResponseDTO;
import com.forohub.api.service.TopicService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {
    private final TopicService topicService;
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @PostMapping
    public ResponseEntity<TopicResponseDTO> crear(@RequestBody @Valid TopicRequestDTO topicRequestDTO){
        TopicResponseDTO response = topicService.crear(topicRequestDTO);

        URI location = URI.create("/topics/" + response.id());
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping
    public ResponseEntity<List<TopicResponseDTO>> listarTodos() {
        return ResponseEntity.ok(topicService.listarTodos());
    }


    // READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<TopicResponseDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(topicService.obtenerPorId(id));
    }


    // DELETE (opcional, pero útil)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        topicService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
