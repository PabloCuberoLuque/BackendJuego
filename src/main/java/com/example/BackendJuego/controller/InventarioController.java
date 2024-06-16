package com.example.BackendJuego.controller;


import com.example.BackendJuego.model.*;
import com.example.BackendJuego.repository.InventarioRepository;
import com.example.BackendJuego.repository.ObjetoRepository;
import com.example.BackendJuego.repository.PartidaRepository;
import com.example.BackendJuego.service.InventarioService;
import com.example.BackendJuego.service.JugadorService;
import com.example.BackendJuego.service.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventario")
public class InventarioController {
    @Autowired
    private InventarioService is;
    @Autowired
    private InventarioRepository ir;

    @Autowired
    private ObjetoRepository or;

    @Autowired
    private PartidaRepository pr;


    @PostMapping("/create")
    public ResponseEntity<Inventario> crearInventario(@RequestBody Inventario inventario) {
        inventario.setId(0);
        is.guardarInventario(inventario);
        return ResponseEntity.ok(inventario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventario> obtenerInventarioPorId(@PathVariable int id) {
        Inventario inventario = is.obtenerInventarioPorId(id);
        if (inventario != null) {
            return ResponseEntity.ok(inventario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/partida/{id}")
    public ResponseEntity<Inventario> obtenerInventarioPorPartidaId(@PathVariable int partidaId) {
        Inventario inventario = is.obtenerInventarioPorPartidaId(partidaId);
        if (inventario != null) {
            return ResponseEntity.ok(inventario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/update")
    public ResponseEntity<Inventario> actualizarInventario(@RequestBody ActualizarInventarioDTO actualizarInventarioDTO) {
        Inventario inventario= ir.findById(actualizarInventarioDTO.getInventarioId());
        if (inventario!=null) {
            Objeto objeto = or.findById(actualizarInventarioDTO.getObjetoId());
            Partida partida = pr.findById(actualizarInventarioDTO.getPartida_id());
            if (objeto!=null) {
                inventario.setObjeto(objeto);
                inventario.setPartida(partida);
                is.guardarInventario(inventario);
                return ResponseEntity.ok(inventario);
            } else {
                return ResponseEntity.badRequest().body(null);
            }
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/borrarObjeto/{inventario_Id}")
    public ResponseEntity<Inventario> actualizarObjeto(@PathVariable int inventario_Id) {
        Inventario inventario= ir.findById(inventario_Id);
        if (inventario == null) {
            return ResponseEntity.notFound().build();
        }
        inventario.setObjeto(null);
        is.guardarInventario(inventario);

        return ResponseEntity.ok(inventario);
    }

}
