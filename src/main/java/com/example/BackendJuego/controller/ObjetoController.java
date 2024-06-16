package com.example.BackendJuego.controller;


import com.example.BackendJuego.model.Objeto;
import com.example.BackendJuego.service.ObjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/objeto")
public class ObjetoController {
    @Autowired
    private ObjetoService os;

    // Obtener objeto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Objeto> obtenerObjetoPorId(@PathVariable int id) {
        Objeto objeto = os.obtenerObjetoPorId(id);
        if (objeto != null) {
            return ResponseEntity.ok(objeto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Obtener objeto por nombre
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Objeto> obtenerObjetoPorNombre(@PathVariable String nombre) {
        Objeto objeto = os.obtenerObjetoPorNombre(nombre);
        if (objeto != null) {
            return ResponseEntity.ok(objeto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Obtener todos los objetos
    @GetMapping("/todos")
    public ResponseEntity<List<Objeto>> obtenerTodosLosObjetos() {
        List<Objeto> objetos = os.obtenerTodosLosObjetos();
        if (!objetos.isEmpty()) {
            return ResponseEntity.ok(objetos);
        } else {
            return ResponseEntity.noContent().build();
        }
    }


}
