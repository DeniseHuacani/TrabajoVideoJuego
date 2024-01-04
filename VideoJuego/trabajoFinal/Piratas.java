/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajofinal;


public abstract class Piratas {
    private String nombre;
    private int vida;
    private int nivelAtaque;
    private int nivelDefensa;
    private double oro; 
    private boolean estaVivo; 
    private boolean llevaEscudo;
    
    public Piratas(String no , double o, boolean es){
        nombre =no;
        vida = aleatorioVidas();
        nivelAtaque =aleatorioNAtaque();
        oro=o;
        estaVivo=true;
        llevaEscudo=es;
        
    }
    public abstract int  aleatorioVidas();
    public abstract int  aleatorioNAtaque();
    
    public void eliminarPirata() {
        estaVivo = false;
    }

    public void aumentarVidaPirata(int cantidad) {
        if (estaVivo) {
            vida += cantidad;
        }
    }
    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getNivelAtaque() {
        return nivelAtaque;
    }

    public void setNivelAtaque(int nivelAtaque) {
        this.nivelAtaque = nivelAtaque;
    }
    
    public double getOro() {
        return oro;
    }


    public boolean getEstaVivo() {
        return estaVivo;
    }

    public String toString() {
        return "Nombre: " + nombre +
                "\nVida: " + vida +
                "\nNivel de Ataque: " + nivelAtaque +
                "\nNivel de Defensa: " + nivelDefensa +
                "\nOro: " + oro +
                "\n¿Está Vivo?: " + estaVivo +
                "\n¿Lleva Escudo?: " + llevaEscudo;
    }
}
