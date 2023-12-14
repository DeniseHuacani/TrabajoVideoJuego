package paquete;
import java.awt.*;
import javax.swing.*;
public class Juego extends JFrame{
    public static void main(String[] args){
        PanelFondo ventana = new PanelFondo(800,30);
        Juego videoJuego = new Juego();
        ventana.add(videoJuego);
        ventana.setLocation(300,200);
        ventana.setVisible(true);
        PanelFondo tablero = new PanelFondo(800,30);
        tablero.setBounds(10,10,800,800);
    }
    
}
