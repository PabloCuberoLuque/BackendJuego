package com.example.BackendJuego.model;

public class ActualizarEnemigosRequest {
    private int partida_Id;
    private int enemigosAsesinados;

    // Getters y Setters
    public int getPartidaId() {
        return partida_Id;
    }

    public void setPartidaId(int partidaId) {
        this.partida_Id = partidaId;
    }

    public int getEnemigosAsesinados() {
        return enemigosAsesinados;
    }

    public void setEnemigosAsesinados(int enemigosAsesinados) {
        this.enemigosAsesinados = enemigosAsesinados;
    }
}
