package com.example.BackendJuego.model;

public class ActualizarInventarioDTO {
    private int inventario_id;
    private int objeto_id;
    private int partida_id;


    public int getInventarioId() {
        return inventario_id;
    }

    public int getObjetoId() {
        return objeto_id;
    }

    public void setInventario_id(int inventario_id) {
        this.inventario_id = inventario_id;
    }

    public void setObjeto_id(int objeto_id) {
        this.objeto_id = objeto_id;
    }

    public int getPartida_id() {
        return partida_id;
    }

    public void setPartida_id(int partida_id) {
        this.partida_id = partida_id;
    }
}