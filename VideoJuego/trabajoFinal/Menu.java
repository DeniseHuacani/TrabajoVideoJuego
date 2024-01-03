package trabajofinal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
public class Menu extends JFrame{
    private static final int ANCHO = 700;
    private static final int ALTO = 760;
    private Image logoJuego;
    private JButton jugarButton; //opcion1, menu principal
    private final Image imgJugar = (cargarIcon("https://github.com/DeniseHuacani/TrabajoVideoJuego/blob/main/VideoJuego/imagenes/opcion%20menu.png?raw=true").getImage());
    private JButton comoJugarButton; //opcion2, menu principal
    private  Image imgComoJugar = (cargarIcon("https://github.com/DeniseHuacani/TrabajoVideoJuego/blob/main/VideoJuego/imagenes/opcion%20menu%20(2).png?raw=true").getImage());
    private JButton historiaButton;//opcion3, menu principal
    private  Image imgHistoria = (cargarIcon("https://github.com/DeniseHuacani/TrabajoVideoJuego/blob/main/VideoJuego/imagenes/opcion%20menu%20(3).png?raw=true").getImage());
    private Image fondo;
    
    public Menu(){
        setTitle("THE LAST SHINE VIDEOGAME: MENU");
        setSize(ANCHO,ALTO);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //para que aparezca en el centro
        createContents();
        setVisible(true);
    }
    private void createContents() {
        cargarImagenDeFondo();
        cargarImagenLogo(); //Titulo logo del juego
        //cargando opciones: botones en el menu
        jugarButton = new JButton();
        configurarBoton(jugarButton,imgJugar);
        jugarButton.setBounds(245,355,210,80);
        add(jugarButton);
        jugarButton.addActionListener(new ListenerJugar());
        comoJugarButton = new JButton(); 
        configurarBoton(comoJugarButton,imgComoJugar);
        comoJugarButton.setBounds(245,440,209,80);
        add(comoJugarButton);
        comoJugarButton.addActionListener(new ListenerComoJugar());
        historiaButton = new JButton();
        configurarBoton(historiaButton,imgHistoria);
        historiaButton.setBounds(245,525,209,80);
        add(historiaButton);
        historiaButton.addActionListener(new ListenerHistoria()); 
    }
    private void configurarBoton(JButton unBoton,Image img){
        unBoton.setOpaque(false); //Lo vuelve transparente antes de agregar la imgen
        unBoton.setContentAreaFilled(false); // Establece el fondo del botón como transparente
        unBoton.setBorderPainted(false); // Elimina el borde del botón
        unBoton.setFocusPainted(false); // Elimina el efecto de enfoque
        unBoton.setBackground(new Color(0, 0, 0, 0));
        unBoton.add(new JLabel(new ImageIcon(img)));
    }
    private ImageIcon cargarIcon(String url) { //Metodo que carga las imagenes buttons
        try {
            Image imagen = new ImageIcon(new URL(url)).getImage();
            return new ImageIcon(imagen);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    private void cargarImagenDeFondo() {
        try {
            String urlImagen = "https://github.com/DeniseHuacani/TrabajoVideoJuego/blob/main/VideoJuego/imagenes/FondoMenu.png?raw=true";
            fondo = new ImageIcon(new URL(urlImagen)).getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void cargarImagenLogo() {
        try {
            String urlImagen = "https://github.com/DeniseHuacani/TrabajoVideoJuego/blob/main/VideoJuego/imagenes/logo.png?raw=true";
            logoJuego = new ImageIcon(new URL(urlImagen)).getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private class ListenerJugar implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == jugarButton){
                dispose(); //para que se cierre la ventana
                new SegundaVentana();
            }
        }
    }
    private class ListenerHistoria implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == historiaButton){
                dispose(); //para que se cierre la ventana
                new HistoriaVentana();
            } 
        }
    }
    private class ListenerComoJugar implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == comoJugarButton){
                dispose(); //para que se cierre la ventana
                new SegundaVentana();
            }
        }
    }
    public static void main (String[] args){
            new Menu();
    }
    public void paint (Graphics grafico){
        super.paint(grafico);
        grafico.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        grafico.drawImage(logoJuego,100,0,this);
    }
}
