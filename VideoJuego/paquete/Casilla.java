package paquete;
import java.awt.*;
public class Casilla {
    private boolean perteneceCamino;
    private String contenido;
    private Color color;
    Color colorArena = Color.YELLOW;
    Color colorCamino = Color.BLUE;
    
    public Casilla(){
        
    }
    public void setCamino(Boolean booleano){
        this.perteneceCamino = booleano;
        if (booleano)
            color = colorCamino;
        else 
            color = colorArena;
    }
    public boolean getPerteneceCamino(){
        return perteneceCamino;
    }
    public Color getColor(){
        return color;
    }
    
}
