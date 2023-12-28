/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajofinal;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.awt.event.*;

public class SegundaVentana extends JFrame {
        
    private JButton btnEmpezar;
    
    public SegundaVentana() {
        setTitle("Información de Jugadores");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        setLayout(new FlowLayout());

        agregarJugador("Jugador 1", "https://raw.githubusercontent.com/DeniseHuacani/TrabajoVideoJuego/main/imagenes/fondo4.png");
        agregarJugador("Jugador 2", "https://raw.githubusercontent.com/DeniseHuacani/TrabajoVideoJuego/main/imagenes/fondo5.png");
        btnEmpezar = new JButton("Empezar");
        btnEmpezar.addActionListener(new Listener());
        add(btnEmpezar);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private class Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==btnEmpezar){
                dispose(); //para que se cierre la ventana
                
                Juego.main(new String[]{});
            }
            
        }
    }

    private void agregarJugador(String nombre, String urlImagen) {
        JPanel panelJugador = new JPanel();
        panelJugador.setLayout(new GridLayout(0,1,10,45));

        JLabel labelNombre = new JLabel(nombre);
        JLabel labelImagen = new JLabel();

        try {
            ImageIcon imageIcon = new ImageIcon(new URL(urlImagen));
            Image image = imageIcon.getImage();
            Image nuevaImagen = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Ajusta el tamaño según sea necesario
            labelImagen.setIcon(new ImageIcon(nuevaImagen));
        } catch (IOException e) {
            e.printStackTrace();
        }

        panelJugador.add(labelNombre);
        panelJugador.add(labelImagen);

        add(panelJugador);
    }
    public static void main (String[] args){
            new SegundaVentana();
    }
}
