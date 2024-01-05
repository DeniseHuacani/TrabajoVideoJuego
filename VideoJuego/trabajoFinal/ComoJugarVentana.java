package trabajofinal;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;

public class ComoJugarVentana extends JFrame{
    private static final int ANCHO = 1821;
    private static final int ALTO = 1620;
    private Image img = cargarImagen("https://github.com/DeniseHuacani/TrabajoVideoJuego/blob/main/VideoJuego/imagenes/Instrucciones.png?raw=true");
    private JButton regresarButton;
    private final Image imgRegresar = cargarImagen("https://github.com/DeniseHuacani/TrabajoVideoJuego/blob/main/VideoJuego/imagenes/boton%20regresar%20(3).png?raw=true");

    public ComoJugarVentana(){
        setTitle("THE LAST SHINE CHANCE: Como jugar");
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
    private void configurarBoton(JButton unBoton,Image img){
        unBoton.setOpaque(false); //Lo vuelve transparente antes de agregar la imgen
        unBoton.setContentAreaFilled(false); // Establece el fondo del botón como transparente
        unBoton.setBorderPainted(false); // Elimina el borde del botón
        unBoton.setFocusPainted(false); // Elimina el efecto de enfoque
        unBoton.setBackground(new Color(0, 0, 0, 0));
        unBoton.add(new JLabel(new ImageIcon(img)));
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
        grafico.drawImage(img, 0, 0, getWidth(), getHeight()-40, this);
    }
}
