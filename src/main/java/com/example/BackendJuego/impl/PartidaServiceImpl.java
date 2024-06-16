package com.example.BackendJuego.impl;

import com.example.BackendJuego.model.Partida;
import com.example.BackendJuego.repository.JugadorRepository;
import com.example.BackendJuego.repository.PartidaRepository;
import com.example.BackendJuego.service.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidaServiceImpl implements PartidaService {
    @Autowired
    private PartidaRepository pr;

    @Override
    public void guardarPartida(Partida partida) {
        pr.save(partida);
    }

    @Override
    public Partida obtenerPartidaPorId(int id) {
        return pr.findById(id);
    }

    @Override
    public List<Partida> obtenerTodasLosPartidas() {
        return pr.findAll();
    }

    @Override
    public List<Partida> obtenerTodasLosPartidasJugador(int idJugador) {
        return pr.findAllByJugadorId(idJugador);
    }
}
