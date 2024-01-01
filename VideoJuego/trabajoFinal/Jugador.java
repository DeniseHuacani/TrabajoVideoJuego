package trabajofinal;
import java.awt.Image;
public class Jugador {
    private Image icono;
    private boolean turno = true;
    private String nombre;
    private boolean gano = false;

    public Jugador (Image icon, String nom){
        icono = icon;
        nombre = nom;
    }
    public Image getIcono(){
        return icono;
    }
}
