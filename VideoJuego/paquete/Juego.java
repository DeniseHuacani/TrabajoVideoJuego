package paquete;
import java.awt.*;
import javax.swing.*;
public class Juego extends JFrame{
    public static void main(String[] args){
        Juego videoJuego = new Juego();
        videoJuego.setLocation(300, 200);
        videoJuego.setSize(800, 700);
        videoJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PanelFondo tablero = new PanelFondo(800, 30);
        videoJuego.add(tablero);

        videoJuego.setVisible(true);
    }
}
