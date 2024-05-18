package com.example.BackendJuego.impl;

import com.example.BackendJuego.model.Jugador;
import com.example.BackendJuego.repository.JugadorRepository;
import com.example.BackendJuego.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorServiceImpl  implements JugadorService {

    @Autowired
    private JugadorRepository jr;
    @Override
    public void guardarUsuario(Jugador jugador) {
        jr.save(jugador);
    }

    @Override
    public Jugador obtenerUsuarioPorId(int id) {
        return jr.findById(id);
    }

    @Override
    public Jugador obtenerJugadorPorNombre(String nombreJugador) {
        return jr.findByUsuario(nombreJugador);
    }

    @Override
    public List<Jugador> obtenerTodosLosJugadores() {
        return jr.findAll();
    }

    @Override
    public void actualizarJugador(Jugador jugador) {

    }



   /* @Override
    public void borrarJugador(int id) {
        jr.deleteById(id);
    }*/


}
