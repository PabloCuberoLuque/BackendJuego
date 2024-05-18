package com.example.BackendJuego.service;

import com.example.BackendJuego.model.Jugador;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JugadorService {
    void guardarUsuario(Jugador jugador);
    Jugador obtenerUsuarioPorId(int id);
    Jugador obtenerJugadorPorNombre(String nombreJugador);
    List<Jugador> obtenerTodosLosJugadores();
    void actualizarJugador(Jugador jugador);
    //void borrarJugador(int id);
}
