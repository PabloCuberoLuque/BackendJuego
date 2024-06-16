package com.example.BackendJuego.service;

import com.example.BackendJuego.model.Inventario;
import com.example.BackendJuego.model.Objeto;
import com.example.BackendJuego.model.Partida;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InventarioService {
    Inventario obtenerInventarioPorId(int id);
    void guardarInventario(Inventario inventario);
    Inventario obtenerInventarioPorPartidaId(int partidaId);
    Inventario borrarObjetoDelInventario(int inventarioId);
}
