package com.forohub.api.dto;

import com.forohub.api.entity.Topic;

import java.time.LocalDateTime;

public record TopicResponseDTO(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion
) {
    public TopicResponseDTO (Topic topico){
        this(
            topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion()
        );
    }

}
