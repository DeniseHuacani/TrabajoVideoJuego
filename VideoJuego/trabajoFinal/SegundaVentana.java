package trabajofinal;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.awt.event.*;

public class SegundaVentana extends JFrame {
    private JButton empezarButton;
    
    public SegundaVentana() {
        setTitle("Información de Jugadores");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        createContents();
        setVisible(true);
    
        agregarJugador("Jugador 1", "https://raw.githubusercontent.com/DeniseHuacani/TrabajoVideoJuego/main/imagenes/fondo4.png");
        agregarJugador("Jugador 2", "https://raw.githubusercontent.com/DeniseHuacani/TrabajoVideoJuego/main/imagenes/fondo5.png");
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void createContents(){
        
        JComboBox iconsList = new JComboBox<>();
        empezarButton = new JButton("Empezar");
        add(empezarButton);
        empezarButton.addActionListener(new Listener());
        

    }
    private void añadirImagen(){
        
    }

    private class Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == empezarButton){
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
