package trabajofinal;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.awt.event.*;

public class SegundaVentana extends JFrame {
    private JButton empezarButton;
    private Image fondo;
    private JComboBox<ImageIcon> iconsList;
    private ArrayList<ImageIcon> iconosDisponibles;

    public SegundaVentana() {
        setTitle("THE LAST SHINE CHANCE: Personalizacion de Jugadores");
        setSize(700, 760);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        createContents();
        setVisible(true);
    }
    public void createContents(){
        cargarImagenDeFondo();
        iconosDisponibles = cargarIconos();
        JComboBox iconsList = new JComboBox<>();
        empezarButton = new JButton("Empezar");
        add(empezarButton);
        empezarButton.addActionListener(new Listener());
    }
    private void cargarImagenDeFondo() {
        try {
            String urlImagen = "https://github.com/DeniseHuacani/TrabajoVideoJuego/blob/main/VideoJuego/imagenes/FondoMenu.png?raw=true";
            fondo = new ImageIcon(new URL(urlImagen)).getImage();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    private ArrayList<ImageIcon> cargarIconos(){
        ArrayList<ImageIcon> iconos = new ArrayList<ImageIcon>();
        iconos.add();
        return 
    }

    private class Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == empezarButton){
                dispose(); //para que se cierre la ventana
                Juego.main(new String[]{});
            }
            
        }
    }

    public void paint (Graphics grafico){
        super.paint(grafico);
        grafico.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
    }
    public static void main (String[] args){
            new SegundaVentana();
    }
}
