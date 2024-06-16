package com.example.BackendJuego.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "inventario")
@Entity
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "partida_id")
    @JsonBackReference
    private Partida partida;

    @ManyToOne
    @JoinColumn(name = "objeto_id")
    private Objeto objeto;
}
