/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajofinal;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
public class Bienvenidos extends JFrame{
    private static final int ANCHO =600;
    private static final int ALTO=150;
   
    private JLabel saludo;
    private JButton botinicio;
    
    public Bienvenidos(){
        setTitle("VIDEOJUEGO!!");
        setSize(540,150);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //para que aparezca en el centro
        createContents();
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
}