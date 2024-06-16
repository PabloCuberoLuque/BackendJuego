package com.example.BackendJuego.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "partida")
@Entity
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "jugador_id", nullable = false)
    private Jugador jugador;

    @ManyToOne
    @JoinColumn(name = "inventario_id", nullable = false)
    @JsonManagedReference
    private Inventario inventario;

    @Column(name = "enemigosAsesinados",nullable = false)
    private int enemigosAsesinados;
}
