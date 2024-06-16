package com.example.BackendJuego.controller;

import com.example.BackendJuego.model.*;
import com.example.BackendJuego.repository.InventarioRepository;
import com.example.BackendJuego.repository.JugadorRepository;
import com.example.BackendJuego.repository.PartidaRepository;
import com.example.BackendJuego.service.JugadorService;
import com.example.BackendJuego.service.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/partida")
public class PartidaController {
    @Autowired
    private PartidaService ps;
    @Autowired
    private JugadorRepository jugadorRepository;
    @Autowired
    private InventarioRepository inventarioRepository;


    @PostMapping("/create")
    public ResponseEntity<Partida> createPartida(@RequestBody PartidaDTO partidaDTO) {
        Partida partida = new Partida();
        partida.setEnemigosAsesinados(partidaDTO.getEnemigosAsesinados());

        Jugador jugador = jugadorRepository.findById(partidaDTO.getJugador_id());
        if (jugador!=null) {
            partida.setJugador(jugador);
        } else {
            return ResponseEntity.badRequest().build();
        }

        Inventario inventario = inventarioRepository.findById(partidaDTO.getInventario_id());
        if (inventario!=null) {
            partida.setInventario(inventario);
        } else {
            return ResponseEntity.badRequest().build();
        }

        ps.guardarPartida(partida);
        return ResponseEntity.ok(partida);
    }

    @GetMapping
    public List<Partida> obtenerTodasLasPartidas() {
        return ps.obtenerTodasLosPartidas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partida> obtenerPartidaPorId(@PathVariable int id) {
        Partida partida = ps.obtenerPartidaPorId(id);
        if (partida != null) {
            return ResponseEntity.ok(partida);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/jugador/{jugador_id}")
    public ResponseEntity<List<Partida>> obtenerTodasPartidasPorJugadorId(@PathVariable int jugador_id) {
        List<Partida> partidas = ps.obtenerTodasLosPartidasJugador(jugador_id);
        if (partidas != null) {
            return ResponseEntity.ok(partidas);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/actualizarEnemigos")
    public ResponseEntity<Partida> actualizarEnemigos(@RequestBody ActualizarEnemigosRequest request) {
        Partida partida = ps.obtenerPartidaPorId(request.getPartidaId());
        if (partida == null) {
            return ResponseEntity.notFound().build();
        }

        partida.setEnemigosAsesinados(request.getEnemigosAsesinados());
        ps.guardarPartida(partida);

        return ResponseEntity.ok(partida);
    }
}
