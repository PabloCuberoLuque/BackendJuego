package com.example.BackendJuego.service;

import com.example.BackendJuego.model.Jugador;
import com.example.BackendJuego.model.Partida;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PartidaService {
    void guardarPartida(Partida partida);
    Partida obtenerPartidaPorId(int id);
    List<Partida> obtenerTodasLosPartidas();
    List<Partida> obtenerTodasLosPartidasJugador(int idJugador);
}
