package trabajofinal;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.awt.event.*;

public class SegundaVentana extends JFrame {
    private JButton empezarButton;
    private Image fondo;
    private JComboBox<ImageIcon> iconsList1;
    private JComboBox<ImageIcon> iconsList2;
    private ArrayList<ImageIcon> iconsArr1;
    private ArrayList<ImageIcon> iconsArr2;

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
        cargarImagenes();
        iconsList1 = new JComboBox<>(iconsArr1.toArray(new ImageIcon[0]));
        iconsList1.setPreferredSize(new Dimension(110, 100));
        add(iconsList1);
        iconsList1.addItemListener(new ListenerDespegable());
        iconsList2 = new JComboBox<>(iconsArr2.toArray(new ImageIcon[0]));
        iconsList2.setPreferredSize(new Dimension(110, 100));
        add(iconsList2);
        iconsList1.addItemListener(new ListenerDespegable());
        empezarButton = new JButton("Empezar");
        empezarButton.setBounds(100,100,100,100);
        add(empezarButton);
        empezarButton.addActionListener(new Listener());
    }
    private void cargarImagenes(){
        cargarImagenDeFondo();
        ImageIcon icon11 = cargarIcon("https://github.com/DeniseHuacani/TrabajoVideoJuego/blob/main/VideoJuego/imagenes/Iconos/IconoJugador1/Icono1.1.png?raw=true");
        ImageIcon icon12 = cargarIcon("https://github.com/DeniseHuacani/TrabajoVideoJuego/blob/main/VideoJuego/imagenes/Iconos/IconoJugador1/icono1.2.png?raw=true");
        ImageIcon icon13 = cargarIcon("https://github.com/DeniseHuacani/TrabajoVideoJuego/blob/main/VideoJuego/imagenes/Iconos/IconoJugador1/icono1.3.png?raw=true");
        ImageIcon icon14 = cargarIcon("https://github.com/DeniseHuacani/TrabajoVideoJuego/blob/main/VideoJuego/imagenes/Iconos/IconoJugador1/icono1.4.png?raw=true");
        iconsArr1 = cargarIconsArr(icon11,icon12,icon13,icon14);
        ImageIcon icon21 = cargarIcon("https://github.com/DeniseHuacani/TrabajoVideoJuego/blob/main/VideoJuego/imagenes/Iconos/IconoJugador2/icono2.1.png?raw=true");
        ImageIcon icon22 = cargarIcon("https://github.com/DeniseHuacani/TrabajoVideoJuego/blob/main/VideoJuego/imagenes/Iconos/IconoJugador2/icono2.2.png?raw=true");
        ImageIcon icon23 = cargarIcon("https://github.com/DeniseHuacani/TrabajoVideoJuego/blob/main/VideoJuego/imagenes/Iconos/IconoJugador2/icono2.3.png?raw=true");
        ImageIcon icon24 = cargarIcon("https://github.com/DeniseHuacani/TrabajoVideoJuego/blob/main/VideoJuego/imagenes/Iconos/IconoJugador2/icono2.4.png?raw=true");
        iconsArr2 = cargarIconsArr(icon21,icon22,icon23,icon24);
    }
    private void cargarImagenDeFondo() {
        try {
            String urlImagen = "https://github.com/DeniseHuacani/TrabajoVideoJuego/blob/main/VideoJuego/imagenes/backgroung.png?raw=true";
            fondo = new ImageIcon(new URL(urlImagen)).getImage();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    private ImageIcon cargarIcon(String urlImagen) {
        try {
            Image imagen = new ImageIcon(new URL(urlImagen)).getImage();
            return new ImageIcon(imagen);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private ArrayList<ImageIcon> cargarIconsArr(ImageIcon im1,ImageIcon im2,ImageIcon im3,ImageIcon im4){
        ArrayList<ImageIcon> iconos = new ArrayList<ImageIcon>();
        iconos.add(im1);
        iconos.add(im2);
        iconos.add(im3);
        iconos.add(im4);
        return iconos;
    }
    //Listeners
    private class Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == empezarButton){
                dispose(); //para que se cierre la ventana
                Juego.main(new String[]{});
            }   
        }
    }
    private class ListenerDespegable implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            while (e.getStateChange() == ItemEvent.SELECTED) {
                repaint();
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
