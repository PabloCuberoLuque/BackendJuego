package com.example.BackendJuego.impl;

import com.example.BackendJuego.model.Inventario;
import com.example.BackendJuego.repository.InventarioRepository;
import com.example.BackendJuego.repository.JugadorRepository;
import com.example.BackendJuego.repository.PartidaRepository;
import com.example.BackendJuego.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventarioServiceImpl implements InventarioService {
    @Autowired
    private InventarioRepository ir;

    @Override
    public Inventario obtenerInventarioPorId(int id) {
        return ir.findById(id);
    }

    @Override
    public void guardarInventario(Inventario inventario) {
        ir.save(inventario);
    }

    @Override
    public Inventario obtenerInventarioPorPartidaId(int partidaId) {
        return ir.findByPartidaId(partidaId);
    }

    @Override
    public Inventario borrarObjetoDelInventario(int inventarioid) {
        Inventario inventario = ir.findById(inventarioid);
        inventario.setObjeto(null);
        ir.save(inventario);
        return inventario;
    }
}
