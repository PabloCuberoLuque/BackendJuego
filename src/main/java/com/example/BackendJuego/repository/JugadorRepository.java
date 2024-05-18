package com.example.BackendJuego.repository;

import com.example.BackendJuego.model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Integer> {

    Jugador findByUsuario(String usuario);
    Jugador findById(int id);

}