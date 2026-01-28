package com.forohub.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "topics")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaDeCreacion;

    public Topic(String titulo, String mensaje) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechaDeCreacion = LocalDateTime.now();
    }
}
