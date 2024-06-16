package com.example.BackendJuego.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Jugador")
@Entity
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "usuario",nullable = false, unique = true, length = 28)
    private String usuario;

    @Column(name = "contrasena",nullable = false)
    private String contrasena;

    @Column(name = "correo",nullable = false, length = 28)
    private String correo;

}
