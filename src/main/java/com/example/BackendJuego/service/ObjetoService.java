package com.example.BackendJuego.service;


import com.example.BackendJuego.model.Jugador;
import com.example.BackendJuego.model.Objeto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ObjetoService {
    Objeto obtenerObjetoPorId(int id);
    Objeto obtenerObjetoPorNombre(String nombreObjeto);
    List<Objeto> obtenerTodosLosObjetos();
}
