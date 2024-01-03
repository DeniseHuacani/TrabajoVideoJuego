package trabajofinal;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

public class HistoriaVentana extends JFrame{
    private static final int ANCHO = 700;
    private static final int ALTO = 730;
    private Image fondo = cargarImagen("https://github.com/DeniseHuacani/TrabajoVideoJuego/blob/main/VideoJuego/imagenes/backgroung.png?raw=true");
    private Image historia = cargarImagen("https://github.com/DeniseHuacani/TrabajoVideoJuego/blob/main/VideoJuego/imagenes/hsitoria.png?raw=true");
    private JButton regresarButton;
    private final Image imgRegresar = cargarImagen("https://github.com/DeniseHuacani/TrabajoVideoJuego/blob/main/VideoJuego/imagenes/boton%20regresar.png?raw=true");

    public HistoriaVentana(){
        setTitle("THE LAST SHINE CHANCE: Historia");
        setSize(ANCHO,ALTO);
        createContents();
        setVisible(true);
    }
    private void createContents(){
        regresarButton = new JButton();
        configurarBoton(regresarButton,imgRegresar);
        add(regresarButton, BorderLayout.SOUTH);
        regresarButton.setHorizontalAlignment(SwingConstants.LEFT);
        regresarButton.addActionListener(new Listener());
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
    private void configurarBoton(JButton unBoton,Image img){
        unBoton.setOpaque(false); //Lo vuelve transparente antes de agregar la imgen
        unBoton.setContentAreaFilled(false); // Establece el fondo del botón como transparente
        unBoton.setBorderPainted(false); // Elimina el borde del botón
        unBoton.setFocusPainted(false); // Elimina el efecto de enfoque
        unBoton.setBackground(new Color(0, 0, 0, 0));
        unBoton.add(new JLabel(new ImageIcon(img)));
    }
    private class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == regresarButton) {
                dispose(); 
                new Menu(); // Crea una nueva instancia de Menu y la hace visible
            }
        }
    }
        public void paint (Graphics grafico){
        super.paint(grafico);
        grafico.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        grafico.drawImage(historia,81,40,530,530,this);
    }
    public static void main (String[] args){
        new HistoriaVentana();
    }
}
