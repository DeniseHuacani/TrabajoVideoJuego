/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajofinal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.Random;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
public class VentanaPelea extends JFrame{
    private static final int ANCHO =570;
    private static final int ALTO=500;
    
    
    private Tripulacion barco1 = new Tripulacion("Barbosa");
    private Tripulacion barco2 = new Tripulacion("Garfio");
    private int pirataElegido1 = -1;
    private int pirataElegido2 = -1;
    
    private Image logoJuego;
    
    private Image fondo;
    
    public VentanaPelea(){
        setTitle("Batalla");
        setSize(ANCHO,ALTO);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //para que aparezca en el centro
        createContents();
        setVisible(true);
    }
    public int[] opcionesPiratas(Tripulacion barco) {
        int cant1 = barco.getCantidadPiratas();
        Random rand = new Random();
        int n1 = rand.nextInt(cant1);
        int n2;
        int n3;
        do {
            n2 = rand.nextInt(cant1);
            n3 = rand.nextInt(cant1);
        } while (n1 == n2 || n1 == n3);

        return new int[]{n1, n2, n3};
    }
    private void createContents() {
        //cargarImagenDeFondo();
        
        int[] piratasEquipo1 = opcionesPiratas(barco1);
        crearEquipo(piratasEquipo1,barco1);
        crearPanelBotones(piratasEquipo1,1,barco1);

        int[] piratasEquipo2 = opcionesPiratas(barco2);
        crearEquipo( piratasEquipo2, barco2);
        crearPanelBotones(piratasEquipo2,2,barco2);
        
        JButton botonPelea = new JButton("Iniciar Pelea");
        botonPelea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pirataElegido1 != -1  && pirataElegido2 !=-1) {
                    String resultado = batallaSoldado(pirataElegido1, pirataElegido2);
                    JOptionPane.showMessageDialog(null, resultado, "Resultado de la Batalla", JOptionPane.INFORMATION_MESSAGE);
                    dispose(); //cerrar ventanaPelea 
                } else {
                    JOptionPane.showMessageDialog(null, "Debes seleccionar una opción antes de iniciar la pelea.", "Resultado de la Batalla", JOptionPane.INFORMATION_MESSAGE);
                    
                }
            }
        });
        add(botonPelea);
    }
    public void crearEquipo( int[] piratas, Tripulacion barco){
        JLabel labelEquipo = new JLabel(barco.getCapitan());
        labelEquipo.setFont(new Font("Arial", Font.BOLD, 20));
        JPanel panelEquipo = new JPanel ( new BorderLayout());
        panelEquipo.add(labelEquipo, BorderLayout.NORTH);
        
        JTextArea pirata1 = new JTextArea();
        JTextArea pirata2 = new JTextArea();
        JTextArea pirata3 = new JTextArea();
        pirata1.setColumns(15); // Ajusta el ancho
        pirata1.setRows(5);    // Ajusta el alto
        pirata2.setColumns(15);
        pirata2.setRows(5);
        pirata3.setColumns(15);
        pirata3.setRows(5);
        
        pirata1.append(barco.getTripulacion().get(piratas[0]).toString() + "\n");
        pirata2.append(barco.getTripulacion().get(piratas[1]).toString() + "\n");
        pirata3.append(barco.getTripulacion().get(piratas[2]).toString() + "\n");
        
        JPanel equipo = new JPanel(new GridLayout(1,0,2,2));
        pirata1.setEditable(false);
        pirata1.setLineWrap(true);
        pirata2.setEditable(false);
        pirata2.setLineWrap(true);
        pirata3.setEditable(false);
        pirata3.setLineWrap(true);
        equipo.add(pirata1 );
        equipo.add(pirata2);
        equipo.add(pirata3);
        
        
        
        panelEquipo.add(equipo, BorderLayout.CENTER);
        add(panelEquipo);
    }
    private void crearPanelBotones(int[] piratas, int n, Tripulacion barco) {
        JPanel botones = new JPanel(new GridLayout(1, 0, 2, 2));

        JRadioButton radioButton1 = new JRadioButton("Pirata 1");
        JRadioButton radioButton2 = new JRadioButton("Pirata 2");
        JRadioButton radioButton3 = new JRadioButton("Pirata 3");

        Dimension dimensionRadioButton = new Dimension(150, 20);
        radioButton1.setPreferredSize(dimensionRadioButton);
        radioButton2.setPreferredSize(dimensionRadioButton);
        radioButton3.setPreferredSize(dimensionRadioButton);

    
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);

        radioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(n==1){
                    pirataElegido1=piratas[0];
                }else{
                    pirataElegido2= piratas[0];
                }
                
            }
        });

        radioButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(n==1){
                    pirataElegido1=piratas[1];
                }else{
                    pirataElegido2=piratas[1];
                }

            }
        });

        radioButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(n==1){
                    pirataElegido1=piratas[2];
                }else{
                    pirataElegido2=piratas[2];
                }

            }
        });

        botones.add(radioButton1);
        botones.add(radioButton2);
        botones.add(radioButton3);

        add(botones);
    }
    
    public  String batallaSoldado( int equipo1, int equipo2){
        
        StringBuilder resultadoBatalla = new StringBuilder();
        
        Random rand = new Random();
        int num = rand.nextInt(100)+1;
        
        int vida1 = barco1.getTripulacion().get(equipo1).getVida();
        int vida2 = barco2.getTripulacion().get(equipo2).getVida();
        
        double cantidad = vida1+vida2;
        double probabilidad= vida1*100/cantidad;
        double factor = Math.pow(10, 1);//1 es el numero de decimales
        probabilidad = Math.round(probabilidad * factor) / factor;
        //double probabilidad_segundo = 100- probabilidad;
        
        resultadoBatalla.append("Equipo : ").append(barco1.getCapitan()).append("\n");
        resultadoBatalla.append("Vida:\t").append(vida1).append("\n");
        resultadoBatalla.append("Probabilidad:  ").append(probabilidad).append("\n");
        
        resultadoBatalla.append("Equipo : ").append(barco2.getCapitan()).append("\n");
        resultadoBatalla.append("Vida : \t").append(vida2).append("\n");
        resultadoBatalla.append("Probabilidad :  ").append(100 - probabilidad).append("%\n");
        
        if(num<=probabilidad){
            resultadoBatalla.append("Gano: ").append(barco1.getCapitan()).append("\n");
            resultadoBatalla.append("Muere: ").append(barco2.getCapitan()).append("\n");
            barco2.getTripulacion().remove(equipo2);
            barco1.getTripulacion().get(equipo1).aumentarVidaPirata(3);
            resultadoBatalla.append("Vida +3").append("\n");
        }else{
            resultadoBatalla.append("Gano: ").append(barco2.getCapitan()).append("\n");
            resultadoBatalla.append("Muere: ").append(barco1.getCapitan()).append("\n");
            barco1.getTripulacion().remove(equipo1);
            barco2.getTripulacion().get(equipo2).aumentarVidaPirata(3);
            resultadoBatalla.append("Vida +3").append("\n");
        }
        return resultadoBatalla.toString();
    }
    private void cargarImagenDeFondo() {
        try {
            String urlImagen = "https://raw.githubusercontent.com/DeniseHuacani/TrabajoVideoJuego/main/imagenes/fondoBatalla.jpg";
            fondo = new ImageIcon(new URL(urlImagen)).getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private class Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            
            
        }
    }
    public static void main (String[] args){
            new VentanaPelea();
    }
    
    public void paint (Graphics grafico){
        super.paint(grafico);
        grafico.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        grafico.drawImage(logoJuego,100,0,this);
    }
}
