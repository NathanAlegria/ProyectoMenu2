/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Nathan
 */
public class juego {
    
    private String resultado; 
    private int puntuacionObtenida;
    private LocalDateTime fechaHora;

    public juego(String resultado, int puntuacionObtenida) {
        this.resultado = resultado;
        this.puntuacionObtenida = puntuacionObtenida;
        this.fechaHora = LocalDateTime.now();
    }

    public String getResultado() {
        return resultado;
    }

    public int getPuntuacionObtenida() {
        return puntuacionObtenida;
    }
    
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
    
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return String.format("[%s] %s - Puntos: %d", 
                fechaHora.format(formatter), resultado, puntuacionObtenida);
    }
}

