package paquete;
import java.awt.*;
public class Casilla {
    private boolean perteneceCamino;
    private String contenido;
    private Color color;
    Color colorArena = new Color(240, 230, 140);
    Color colorCamino = new Color(65, 105, 225);
    
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
