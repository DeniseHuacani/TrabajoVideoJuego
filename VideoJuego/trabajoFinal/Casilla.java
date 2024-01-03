package trabajofinal;

import java.awt.*;
public class Casilla {
    private boolean perteneceCamino;
    private Color color;
    
    private int numerobarco;
    private int posicion;
    
    Color colorMar = new Color(0, 0, 255, 0); 
    Color colorCamino = new Color(229, 231, 233,200); 
    Color colorCamNoValido = new Color(185, 185, 185,200); 
    
    public void setCamino(Boolean booleano){
        this.perteneceCamino = booleano;
        
        if (booleano)
            color = colorCamino;
        else{
            color = colorMar;
        } 
            
    }
    public void setCaminoNoValido(){
        color = colorCamNoValido;
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
