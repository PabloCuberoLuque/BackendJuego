package com.example.BackendJuego.controller;


import com.example.BackendJuego.model.Jugador;
import com.example.BackendJuego.model.LoginRequest;
import com.example.BackendJuego.model.RegisterRequest;
import com.example.BackendJuego.repository.JugadorRepository;
import com.example.BackendJuego.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        // Verificar si el nombre de usuario y la contraseña no son nulos o vacíos
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

        return ResponseEntity.ok("Login exitoso");
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
        if (jr.findByUsuario(registerRequest.getUsuario()) != null) {
            return ResponseEntity.status(400).body("El usuario ya existe");
        }
        Jugador nuevoJugador = new Jugador();
        nuevoJugador.setId(0);
        nuevoJugador.setUsuario(registerRequest.getUsuario());
        nuevoJugador.setContrasena(registerRequest.getContrasena());
        nuevoJugador.setCorreo(registerRequest.getCorreo());

        js.guardarUsuario(nuevoJugador);

        return ResponseEntity.ok("Usuario registrado correctamente");
    }
    }

