/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajofinal;
import java.awt.*;
import javax.swing.*;
public class Juego extends JFrame{
    
    public static void main(String[] args){
        Juego videoJuego = new Juego();
        videoJuego.setLocation(300, 200);
        videoJuego.setSize(1000, 700);
        videoJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PanelFondo tablero = new PanelFondo(8000, 240);
        videoJuego.add(tablero);

        videoJuego.setVisible(true);
    }
}
