package trabajofinal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
public class Menu extends JFrame{
    private static final int ANCHO = 700;
    private static final int ALTO = 760;
    private static final int ANCHO_BOTON = 240;
    private static final int LARGO_BOTON = 70;
    private Image logoJuego;
    private JButton jugarButton; //opcion1, menu principal
    private JButton comoJugarButton; //opcion2, menu principal
    private JButton historiaButton;//opcion3, menu principal
    private Image fondo;
    
    public Menu(){
        setTitle("THE LAST SHINE VIDEOGAME: MENU");
        setSize(ANCHO,ALTO);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //para que aparezca en el centro
        
        createContents();
        setVisible(true);
    }
    private void createContents() {
        cargarImagenDeFondo();
        cargarImagenLogo(); //Titulo logo del juego
        //cargando opciones: botones en el menu
        jugarButton = new JButton(cargarIcon("https://github.com/DeniseHuacani/TrabajoVideoJuego/blob/main/VideoJuego/imagenes/opcionMenu.png?raw=true"));
        
        add(jugarButton);
        jugarButton.addActionListener(new Listener());
        comoJugarButton = new JButton(cargarIcon("https://github.com/DeniseHuacani/TrabajoVideoJuego/blob/main/VideoJuego/imagenes/opcionMenu%20(2).png?raw=true"));
        
        add(comoJugarButton);
        comoJugarButton.addActionListener(new Listener());
        historiaButton = new JButton(cargarIcon("https://github.com/DeniseHuacani/TrabajoVideoJuego/blob/main/VideoJuego/imagenes/opcionMenu%20(3).png?raw=true"));
        
        add(historiaButton);
        historiaButton.addActionListener(new Listener());
        
        
    }
    private ImageIcon cargarIcon(String url) {
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
    private class Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==jugarButton){
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
