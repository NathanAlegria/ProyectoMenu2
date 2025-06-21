/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author Nathan
 */
public class Usuario {
    //Atributos

    private String usuario;
    private String contra;
    private int puntaje;
    private juego ingresos[];
    private int numingresos;
    private static final int maxIngresos = 20;

    //Constructor
    public Usuario(String usuario, String contra) {
        this.usuario = usuario;
        this.contra = contra;
        this.puntaje=0;
        this.ingresos = new juego[maxIngresos];
        this.numingresos = 0;
    }
 
    //Metodos
    public String getUsuario() {
        return usuario;
    }

    public String getContra() {
        return contra;
    }


    public void setPuntaje(int puntaje) {

        this.puntaje = puntaje;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setUsuario(String nuevoUsuario) {
        this.usuario = nuevoUsuario;
    }

    public void setContra(String nuevaContra) {
        this.contra = nuevaContra;
    }
    
    public boolean confirmarcontra(String inputcontra) {
        return this.contra.equals(inputcontra);
    }

    public juego[] getIngresos() {
        return ingresos;
    }

    public int getnumIngresos() {
        return numingresos;
    }

    public void registrojuegos(juego log) {
        if (numingresos < maxIngresos) {
            for (int i = numingresos; i > 0; i--) {
                ingresos[i] = ingresos[i - 1];
            }
            ingresos[0] = log;
            numingresos++;
        } else {
            for (int i = maxIngresos - 1; i > 0; i--) {
                ingresos[i] = ingresos[i - 1];
            }
            ingresos[0] = log;
        }
    }
}


