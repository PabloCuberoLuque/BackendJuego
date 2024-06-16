package com.example.BackendJuego.repository;

import com.example.BackendJuego.model.Jugador;
import com.example.BackendJuego.model.Objeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjetoRepository extends JpaRepository<Objeto, Integer> {
    Objeto findByNombre(String nombre);
    Objeto findById(int id);
}
