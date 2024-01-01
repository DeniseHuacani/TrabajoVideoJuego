/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajofinal;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;
public class PanelFondo extends JPanel {
    protected int cantidadCasillas;
    protected int tamMax;
    protected int tamCasilla;
    protected Casilla[][] tablero;
    private Image fondo;
    private JButton btnActualizar;
    private int turno = 1;
    
    private int numerodado=0;
    private int numerodado2=0;
    
    public PanelFondo(int tamMax,int cantidadCasillas){
        this.tamMax = tamMax;
        this.cantidadCasillas = cantidadCasillas;
        tamCasilla = tamMax/cantidadCasillas;
        cargarImagenDeFondo();
        inicializarCamino();
        inicializarBotonActualizar();
    }
    private void cargarImagenDeFondo() {
        try {
            String urlImagen = "https://github.com/DeniseHuacani/TrabajoVideoJuego/blob/main/VideoJuego/imagenes/fondo.png?raw=true";
            fondo = new ImageIcon(new URL(urlImagen)).getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void inicializarBotonActualizar() {
        Random rand = new Random();
        btnActualizar = new JButton("TURNO : JUGADOR 1");
        
        btnActualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(turno%2==0){
                    btnActualizar.setText("TURNO : JUGADOR 1");
                    numerodado += rand.nextInt(5)+5;
                    pintarPosicion(numerodado,2);
                    repaint(); // Esto llamará al método paint nuevamente
                }
                else{
                    btnActualizar.setText("TURNO : JUGADOR 2");
                    numerodado2 += rand.nextInt(5)+5;
                    pintarPosicion(numerodado2,1);
                    repaint(); // Esto llamará al método paint nuevamente
                }
                if(numerodado==numerodado2){
                    
                }
                turno++;
                
            }
        });

        add(btnActualizar, BorderLayout.SOUTH);
    }
    public void pintarPosicion(int n,int numeroBarco) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                Casilla cActual = tablero[i][j];
                if (cActual.getPosicion() == n && cActual.getNumerobarco()==numeroBarco) {
                    if(numeroBarco==1){
                        cActual.setColor(Color.BLACK);
                    }
                    if(numeroBarco==2){
                        cActual.setColor(Color.BLUE);
                    }// Cambiar a Color.ORANGE o el color que desees
                }
            }
        }
        repaint(); // Llamada para repintar el panel y reflejar los cambios
    }
    private void inicializarCamino(){
        tablero = new Casilla [20][30];
        
        for (int i = 0; i <tablero.length; i++){ //¨Inicilizamos todas las casillas como noCamino
            for (int j = 0; j < tablero[i].length; j++){
                tablero[i][j] = new Casilla();
                Casilla cActual = tablero[i][j];
                cActual.setCamino(false);
            }
        } //Comenzamos definiendo camino, camino horizontal
        for (int i = 2; i <= 28; i++){
            tablero[1][i].setCamino(true);//horizontal
            tablero[2][i].setCamino(true);//horizontal
            tablero[1][i].setPosicion(i-1);//1,2,3...,27
            tablero[2][i].setPosicion(i-1);//1,2,3...,27
            tablero[1][i].setNumerobarco(1);
            tablero[2][i].setNumerobarco(2);
            if (i >= 7){
                tablero[17][i].setCamino(true); //horizontal
                tablero[18][i].setCamino(true);//horizontal
            }
            if (i >= 7 &&i<=24){
                tablero[15][i].setCamino(true); //horizontal
                tablero[14][i].setCamino(true); //horizontal
            }
            if (i >= 4 &&i<=24){ //Se hizo el camino un poco mas corto: fabiana 3 a 4
                tablero[10][i].setCamino(true); //horizontal
                tablero[11][i].setCamino(true); //horizontal
            }  
        }
        for (int i = 2; i <= 19; i++){
                if (i >= 3 && i <=18){
                tablero[i][28].setCamino(true); // vertical
                tablero[i][27].setCamino(true); // vertical
                tablero[i][28].setPosicion(25+i);//28,29,...41,42,43
                tablero[i][27].setCamino(true); //28,29,...41,42,43
                tablero[i][28].setNumerobarco(1);
                tablero[i][27].setNumerobarco(2);
            }
            if (i >= 10 && i <=13){
                tablero[i][23].setCamino(true); // vertical
                tablero[i][24].setCamino(true); // vertical
            }
            if (i >= 14 && i <= 18){
                tablero[i][7].setCamino(true); //vertical
                tablero[i][6].setCamino(true); //vertical
            }
        } 
    }
    
    public void paint (Graphics grafico){
        super.paint(grafico);
        grafico.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        for (int i = 0; i <tablero.length; i++){
            for (int j = 0; j < tablero[i].length; j++){
                Casilla cActual = tablero[i][j];
                Color colorCasilla = cActual.getColor();
                grafico.setColor(colorCasilla);
                grafico.fillRect(j*tamCasilla, i*tamCasilla,tamCasilla-1,tamCasilla-1);
            }
        }
    }

    
    
}
