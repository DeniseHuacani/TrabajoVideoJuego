/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajofinal;
import javax.swing.*;
import java.awt.*;

public class SegundaVentana extends JFrame {
        
    
    
    public SegundaVentana() {
        setTitle("Información de Jugadores");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        setLayout(new GridLayout(2, 2));

        agregarJugador("Jugador 1", "img.jpg");
        agregarJugador("Jugador 2", "imagen2.jpg");

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void agregarJugador(String nombre, String imagen) {
        JPanel panelJugador = new JPanel();
        panelJugador.setLayout(new BorderLayout());

        JLabel labelNombre = new JLabel(nombre);
        JLabel labelImagen = new JLabel(new ImageIcon(imagen));

        panelJugador.add(labelNombre, BorderLayout.NORTH);
        panelJugador.add(labelImagen, BorderLayout.CENTER);

        add(panelJugador);
    }
}