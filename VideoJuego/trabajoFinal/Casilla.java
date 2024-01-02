package trabajofinal;
import java.awt.*;
import javax.swing.*;
public class Casilla {
    private boolean perteneceCamino;
    private ImageIcon iconJugador;
    private Color color; //Temporal, se borrara luego cuando termine con icon
    private int numerobarco;
    private int posicion;
    
    public void setCamino(Boolean booleano){
        this.perteneceCamino = booleano;         
    }
    public boolean getPerteneceCamino(){
        return perteneceCamino;
    }
    public Color getColor(){
        return color;
    }
    
    public void setColor(Color nuevoColor) {
        color = nuevoColor;
    }
    
    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getNumerobarco() {
        return numerobarco;
    }

    public void setNumerobarco(int numerobarco) {
        this.numerobarco = numerobarco;
    }
    
}