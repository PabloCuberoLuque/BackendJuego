package com.example.BackendJuego.controller;


import com.example.BackendJuego.model.*;
import com.example.BackendJuego.repository.JugadorRepository;
import com.example.BackendJuego.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jugador")
public class JugadorController {

    @Autowired
    private JugadorService js;
    @Autowired
    private JugadorRepository jr;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        String usuario = loginRequest.getUsuario();
        String contrasena = loginRequest.getContrasena();

        if (usuario == null || usuario.isEmpty() || contrasena == null || contrasena.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nombre de usuario y contraseña son requeridos");
        }

        Jugador jugador = js.obtenerJugadorPorNombre(usuario);
        if (jugador == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Nombre de usuario incorrecto");
        }

        if (!jugador.getContrasena().equals(contrasena)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Contraseña incorrecta");
        }

        return ResponseEntity.ok(String.valueOf(jugador.getId()));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
        Jugador existingJugador = jr.findByUsuario(registerRequest.getUsuario());
        if (existingJugador != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El usuario ya existe");
        }

        Jugador nuevoJugador = new Jugador();
        nuevoJugador.setId(0);
        nuevoJugador.setUsuario(registerRequest.getUsuario());
        nuevoJugador.setContrasena(registerRequest.getContrasena());
        nuevoJugador.setCorreo(registerRequest.getCorreo());

        js.guardarUsuario(nuevoJugador);

        return ResponseEntity.ok("Usuario registrado correctamente");
    }

    @GetMapping("/{nombreUsuario}")
    public ResponseEntity<Jugador> obtenerJugadorPorUsuario(@PathVariable String nombreUsuario) {
        Jugador jugador = js.obtenerJugadorPorNombre(nombreUsuario);
        if (jugador != null) {
            return ResponseEntity.ok(jugador);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/actualizar/{jugador_id}")
    public ResponseEntity<String> editarJugador(@PathVariable int jugador_id, @RequestBody EditarJugadorRequest editarJugadorRequest){
        try {
            Jugador jugador = js.obtenerUsuarioPorId(jugador_id);

            if (jugador == null) {
                return ResponseEntity.notFound().build();
            }

            // Actualizar los datos del jugador
            jugador.setUsuario(editarJugadorRequest.getUsuario());
            jugador.setContrasena(editarJugadorRequest.getContrasena());
            jugador.setCorreo(editarJugadorRequest.getCorreo());

            // Guardar el jugador actualizado
            js.guardarUsuario(jugador);

            return ResponseEntity.ok("Jugador actualizado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el jugador: " + e.getMessage());
        }
    }

    @GetMapping("/verificarUsuario/{usuario}")
    public ResponseEntity<Boolean> verificarUsuarioExistente(@PathVariable String usuario) {
        Jugador jugador = js.obtenerJugadorPorNombre(usuario);
        if (jugador != null) {
            return ResponseEntity.ok(true); // Usuario existe
        } else {
            return ResponseEntity.ok(false); // Usuario no existe
        }
    }

    @GetMapping("/all")
    public List<Jugador> obtenerTodosLasJugadores() {
        return js.obtenerTodosLosJugadores();
    }

    @DeleteMapping("/borrar/{jugador_id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable("jugador_id") int id) {
        js.borrarJugador(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    }

