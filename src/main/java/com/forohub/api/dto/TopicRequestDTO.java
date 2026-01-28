package com.forohub.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TopicRequestDTO(
        @NotBlank(message = "El título no puede estar vacío")
        @Size(min = 5, max = 150, message = "El título debe tener entre 5 y 150 caracteres")
        String titulo,
        @NotBlank(message = "El mensaje no puede estar vacío")
        @Size(min = 10, message = "El mensaje debe tener al menos 10 caracteres")
        String mensaje
) {
}

