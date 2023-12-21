package paquete;
import java.awt.*;
public class Casilla {
    private boolean perteneceCamino;
    private String contenido;
    private Color color;
    Color colorMar = Color.BLUE;
    Color colorCamino = new Color(65, 105, 225); //mar
    
    public void setCamino(Boolean booleano){
        this.perteneceCamino = booleano;
        if (booleano)
            color = colorCamino;
        else 
            color = colorMar;
    }
    public boolean getPerteneceCamino(){
        return perteneceCamino;
    }
    public Color getColor(){
        return color;
    }
    
}
