package com.example.BackendJuego.impl;

import com.example.BackendJuego.model.Objeto;
import com.example.BackendJuego.repository.ObjetoRepository;
import com.example.BackendJuego.service.ObjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjetoServiceImpl implements ObjetoService {

    @Autowired
    private ObjetoRepository or;

    @Override
    public Objeto obtenerObjetoPorId(int id) {
        return or.findById(id);
    }

    @Override
    public Objeto obtenerObjetoPorNombre(String nombreObjeto) {
        return or.findByNombre(nombreObjeto);
    }

    @Override
    public List<Objeto> obtenerTodosLosObjetos() {
        return or.findAll();
    }
}
