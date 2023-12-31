/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajofinal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
public class Bienvenidos extends JFrame{
    private static final int ANCHO =600;
    private static final int ALTO=150;
   
    private JLabel saludo;
    private JButton botinicio;
    private Image fondo;
    
    public Bienvenidos(){
        setTitle("VIDEOJUEGO!!");
        setSize(540,150);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //para que aparezca en el centro
        
        createContents();
        //cargarImagenDeFondo();
        setVisible(true);
    }
    private void createContents() {
        saludo = new JLabel("¡Bienvenido a la aventura,\n jugador intrépido! ");
        JLabel intro = new JLabel(" ¿Estás listo para sumergirte en un mundo lleno de desafíos, emociones y misterios?");
        Font font = new Font("Times New Roman", Font.PLAIN, 30);
        saludo.setFont(font);
        botinicio= new JButton("INICIAR");
        
        
        add(saludo);
        add(intro);
        add(botinicio);
        botinicio.addActionListener(new Listener());
        
        
    }
    private void cargarImagenDeFondo() {
        try {
            String urlImagen = "https://github.com/DeniseHuacani/TrabajoVideoJuego/blob/main/VideoJuego/imagenes/fondo.png?raw=true";
            fondo = new ImageIcon(new URL(urlImagen)).getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private class Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==botinicio){
                dispose(); //para que se cierre la ventana
                
                new SegundaVentana();
            }
            
        }
    }
    public static void main (String[] args){
            new Bienvenidos();
    }
     public void paint (Graphics grafico){
        super.paint(grafico);
        grafico.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        
    }
}
