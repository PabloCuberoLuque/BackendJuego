package com.example.BackendJuego.model;

public class PartidaDTO {
    private int jugador_id;
    private int inventario_id;
    private int enemigosAsesinados;

    // Getters y Setters
    public int getJugador_id() {
        return jugador_id;
    }

    public void setJugador_id(int jugador_id) {
        this.jugador_id = jugador_id;
    }

    public int getInventario_id() {
        return inventario_id;
    }

    public void setInventario_id(int inventario_id) {
        this.inventario_id = inventario_id;
    }

    public int getEnemigosAsesinados() {
        return enemigosAsesinados;
    }

    public void setEnemigosAsesinados(int enemigosAsesinados) {
        this.enemigosAsesinados = enemigosAsesinados;
    }
}