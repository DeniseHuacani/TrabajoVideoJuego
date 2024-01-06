package trabajofinal;
import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.*;
import java.awt.event.*;

public class SegundaVentana extends JFrame {
    private JButton jugarButton;
    private JButton volverButton;
    private JPanel background;
    private final Image imgBackground;
    private JPanel estandarte;
    private final Image imgEstandarte;
    private final Image imgJug1 = cargarImagen("https://github.com/DeniseHuacani/TrabajoVideoJuego/blob/main/VideoJuego/imagenes/jug1.png?raw=true");
    private final Image imgJug2 = cargarImagen("https://github.com/DeniseHuacani/TrabajoVideoJuego/blob/main/VideoJuego/imagenes/jug2.png?raw=true");
    private final Image imgJLabel = cargarImagen("https://github.com/DeniseHuacani/TrabajoVideoJuego/blob/main/VideoJuego/imagenes/segundaVentana.png?raw=true");;
    private JComboBox<ImageIcon> iconsList1;
    private JComboBox<ImageIcon> iconsList2;
    private ArrayList<ImageIcon> iconsArr1;
    private ArrayList<ImageIcon> iconsArr2;

    public SegundaVentana() {
        setTitle("THE LAST SHINE CHANCE: Personalizacion de Jugadores");
        setSize(456, 396);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        createContents();
        
        setVisible(true);
    }
    public void createContents(){
        cargarImagenes();
        
        Image imgRedimension = imgJLabel.getScaledInstance(300, 210, Image.SCALE_SMOOTH);
        JLabel img = new JLabel(new ImageIcon(imgRedimension));
        JLabel img1 = new JLabel(new ImageIcon(imgJug1));
        JLabel img2 = new JLabel(new ImageIcon(imgJug2));
        img1.setBounds(150,40,100,40);
        
        iconsList1 = new JComboBox<>(iconsArr1.toArray(new ImageIcon[0]));
        iconsList1.setPreferredSize(new Dimension(110, 99));
        iconsList2 = new JComboBox<>(iconsArr2.toArray(new ImageIcon[0]));
        iconsList2.setPreferredSize(new Dimension(110, 99));
        jugarButton = new JButton("Jugar");
        volverButton = new JButton("Volver");
        add(img1);
        add(img2);
        add(iconsList1);
        iconsList1.addItemListener(new ListenerDespegable());
        
        
        add(iconsList2);
        iconsList2.addItemListener(new ListenerDespegable()); //de iconList1 a iconList2
        
               
        
        add(jugarButton);
        jugarButton.addActionListener(new Listener());
        
    }
    private void cargarImagenes(){
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
    private Image cargarImagen(String url) {
        try {
            Image img = new ImageIcon(new URL(url)).getImage();
            return img;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
            if(e.getSource() == jugarButton){
                dispose(); //para que se cierre la ventana
                
                
                ImageIcon avatarBarco1 =  (ImageIcon)iconsList1.getSelectedItem();
                ImageIcon avatarBarco2 =  (ImageIcon)iconsList2.getSelectedItem();
                
                Tripulacion barco1 = new Tripulacion("Barbosa");
                Tripulacion barco2 = new Tripulacion("Garfio");
                barco1.setAvatarTripulacion(avatarBarco1);
                barco2.setAvatarTripulacion(avatarBarco2);
                
                new Juego(barco1, barco2);
                
            }   
        }
    }
    private class ListenerDespegable implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {    //de while a if
                
            }
        }
    }

    public static void main (String[] args){
            new SegundaVentana();
    }
}
