package com.example.BackendJuego.repository;

import com.example.BackendJuego.model.Jugador;
import com.example.BackendJuego.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Integer> {
    Partida findById(int id);
    Partida findByJugadorId(int jugadorId);
    List<Partida> findAllByJugadorId(int idJugador);

}
