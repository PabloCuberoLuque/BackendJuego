package com.example.BackendJuego.repository;

import com.example.BackendJuego.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventarioRepository  extends JpaRepository<Inventario, Integer> {
    Inventario findById(int id);
    Inventario findByPartidaId(int partidaId);
}
