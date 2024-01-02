package trabajofinal;

import java.awt.*;
import java.net.URL;

import javax.swing.*;

public class HistoriaVentana extends JFrame{
    private static final int ANCHO = 700;
    private static final int ALTO = 760;
    private Image logoJuego;
    private Image fondo;
    private Image historia;
    private JButton regresarButton;

    public HistoriaVentana(){
        setTitle("THE LAST SHINE CHANCE: Historia");
        setSize(ANCHO,ALTO);
        createContents();
        setLayout(new FlowLayout());
        setVisible(true);
    }
    private void createContents(){
        cargarImagenes();

    }
    private void cargarImagenes(){
        cargarImagenDeFondo();
        cargarImagenLogo();
        cargarImagenDeHistoria();
    }
    private void cargarImagenDeHistoria() {
        try {
            String urlImagen = "https://github.com/DeniseHuacani/TrabajoVideoJuego/blob/main/VideoJuego/imagenes/historia.png?raw=true";
            historia = new ImageIcon(new URL(urlImagen)).getImage();
        } catch (Exception e) {
            e.printStackTrace();
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
    public void paint (Graphics grafico){
        super.paint(grafico);
        grafico.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        grafico.drawImage(logoJuego,100,0,this);
    }
}
