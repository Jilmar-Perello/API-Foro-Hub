package com.forohub.api.controller;

import com.forohub.api.dto.TopicRequestDTO;
import com.forohub.api.dto.TopicResponseDTO;
import com.forohub.api.service.TopicService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

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
}
