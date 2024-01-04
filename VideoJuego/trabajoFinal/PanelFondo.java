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
                    borrarCasillaPintada(numerodado,2);
                    numerodado += rand.nextInt(5)+5;
                    pintarPosicion(numerodado,2);
                    System.out.println("Jugador 2 : "+numerodado);
                    //repaint(); // Esto llamará al método paint nuevamente// no es necesario , ya lo probe y funciona igual
                }
                else{
                    btnActualizar.setText("TURNO : JUGADOR 2");
                    borrarCasillaPintada(numerodado2,1);
                    numerodado2 += rand.nextInt(5)+5;
                    pintarPosicion(numerodado2,1);
                    System.out.println("Jugador 1 : "+numerodado2);
                    //repaint(); // Esto llamará al método paint nuevamente
                }
                if(numerodado==4 || numerodado==5  || numerodado==6  || numerodado==15  || numerodado==16){
                    new VentanaPelea();
                }
                turno++;
                
            }
        });

        add(btnActualizar, BorderLayout.SOUTH);
    }
    public void borrarCasillaPintada(int posicion,int numero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                Casilla cActual = tablero[i][j];
                if (cActual.getPosicion() == posicion && cActual.getNumerobarco() == numero) {
                    // Restablecer el color a null para borrar la pintura
                    cActual.setColor(new Color(229, 231, 233,200));
                }
            }
        }
        repaint();
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
        
        int n =0;
        int p =0;
        int b =0;
        for (int i = 2; i <= 28; i++){
            if(i<28){
                tablero[1][i].setCamino(true);//horizontal
                tablero[1][i].setNumerobarco(1);
                tablero[1][i].setPosicion(i-1);//1,2,3...,26
                tablero[2][i].setCamino(true);//horizontal
                tablero[2][i].setPosicion(i-1);//1,2,3...,26
                tablero[2][i].setNumerobarco(2);
            }
            
            if (i >= 3 && i <=16){
                tablero[i][28].setCamino(true); // vertical
                tablero[i][28].setNumerobarco(1);
                tablero[i][28].setPosicion(24+i);//27,29,...40
                if (i <=17){
                    tablero[i][27].setCamino(true); // vertical
                    tablero[i][27].setPosicion(24+i);//27,29,...40
                    tablero[i][27].setNumerobarco(2);
                }

            }
            
            if (i >= 7 && i <=27){
                
                
                tablero[17][i].setCamino(true); //horizontal
                tablero[17][i].setNumerobarco(2);
                tablero[17][i].setPosicion(i+54-2*n);//61..42
                
                tablero[18][i].setCamino(true);//horizontal
                tablero[18][i].setNumerobarco(1);
                tablero[18][i].setPosicion(i+54-2*n);//61...42
                n++;
            }
            if (i >= 14 && i <= 18){
                if( i==16){
                    tablero[i][6].setCamino(true); //vertical
                    tablero[i][6].setNumerobarco(1);
                    tablero[i][6].setPosicion(62);//62
                
                    tablero[i][7].setCamino(true); //vertical
                    tablero[i][7].setNumerobarco(2);
                    tablero[i][7].setPosicion(62);//62
                   
                }
                else{
                    tablero[i][6].setCaminoNoValido(); //vertical
                }
            }
            
            
            
            if (i >= 7 &&i<=23){
                
                tablero[14][i].setCamino(true); //horizontal
                tablero[14][i].setNumerobarco(1);
                tablero[14][i].setPosicion(i+56);//63...79
                
                tablero[15][i].setCamino(true); //horizontal
                tablero[15][i].setNumerobarco(2);
                tablero[15][i].setPosicion(56+i);//63...79
                
            }
            if (i >= 5 &&i<=23){ //
                tablero[10][i].setCamino(true); //horizontal
                tablero[10][i].setNumerobarco(2);
                tablero[10][i].setPosicion(i+95-2*(b));//100..82
                tablero[11][i].setCamino(true); //horizontal
                tablero[11][i].setNumerobarco(1);
                tablero[11][i].setPosicion(i+95-2*(b));//100..82
                b++;
            }
            
            if (i >= 10 && i <=15){
                
                
                if (i >= 12 && i <=13){
                    tablero[i][24].setCamino(true); // vertical
                    tablero[i][24].setNumerobarco(2);
                    tablero[i][24].setPosicion(i+69-2*(p));//81 ..80
                
                    tablero[i][23].setCamino(true); // vertical
                    tablero[i][23].setNumerobarco(1);
                    tablero[i][23].setPosicion(i+69-2*(p));//81 ..80
                    p++;
                }else{
                    tablero[i][24].setCaminoNoValido(); // vertical
                }
                
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
