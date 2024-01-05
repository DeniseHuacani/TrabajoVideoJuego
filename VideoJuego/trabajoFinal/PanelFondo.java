package trabajofinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.Random;
public class PanelFondo extends JPanel implements Serializable{
    protected int cantidadCasillas;
    protected int tamMax;
    protected int tamCasilla;
    protected Casilla[][] tablero;
    private transient Image fondo;
    private transient JButton btnActualizar;
    private int turno = 1;
    
    private int numerodado;
    private int numerodado2;
    
    private Tripulacion barco1 ;
    private Tripulacion barco2 ;
    
    private transient JButton btnGuardar;
    private Juego juego;
    
    public PanelFondo(int tamMax,int cantidadCasillas, Tripulacion bar1, Tripulacion bar2 , Juego jueg){
        this.tamMax = tamMax;
        this.cantidadCasillas = cantidadCasillas;
        barco1= bar1;
        barco2= bar2;
        numerodado= jueg.getNumeroDado();
        numerodado2=jueg.getNumeroDado2();
        juego = jueg;
        tamCasilla = tamMax/cantidadCasillas;
        cargarImagenDeFondo();
        inicializarCamino();
        definirEspeciales();
        inicializarBotonActualizar();
        inicializarBotonGuardar();
        
    }
    private void cargarImagenDeFondo() {
        try {
            String urlImagen = "https://github.com/DeniseHuacani/TrabajoVideoJuego/blob/main/VideoJuego/imagenes/fondoT.png?raw=true";
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
                int[] numpelea ={18,19,27,28,68,69,96,97};
                int[] numSumaVida={9,10,14,15,36,37,50,51,57,58};
                int[] numMenosVida={24,25,77,78};
                int[] numAdelante={3,4,31,32,42,43,83,84};
                int[] numRetrocede={20,21,33,34,59,60,70,71,75,76,87,88,94,95};
                if(turno%2==0){
                    
                    btnActualizar.setText("TURNO : JUGADOR 1");
                    borrarCasillaPintada(numerodado,2);
                    numerodado += rand.nextInt(5)+5;
                    juego.setNumeroDado(numerodado);
                    
                    pintarPosicion(juego.getNumeroDado(),2);
                    System.out.println("Jugador 2 : "+juego.getNumeroDado());
                    repaint();
                    if(existeEnArray(numpelea, numerodado2) ||existeEnArray(numpelea, numerodado)){
                        new VentanaPelea(barco1, barco2);
                        System.out.println("pelea ");
                    }

                    else if(existeEnArray(numSumaVida, numerodado2) ){
                        barco1.aumentarVidaEquipo(2);
                        System.out.println("suma" +numerodado2);
                        JOptionPane.showMessageDialog(null, "Te encontraste con alimentos, Sube de vida +2 a todo el equipo", "Resultado ", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if(existeEnArray(numMenosVida, numerodado2) ){
                        barco1.bajarVidaEquipo(2);
                        System.out.println("menos " +numerodado2);
                        JOptionPane.showMessageDialog(null, "Te encontraste con un calamar Baja la vida -2 a todo el equipo", "Resultado ", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if(existeEnArray(numAdelante, numerodado2) ){
                        borrarCasillaPintada(numerodado2,1);
                        numerodado2+=3;
                        System.out.println("adelantar" +numerodado2);
                        pintarPosicion(numerodado2,1);
                        repaint();
                        JOptionPane.showMessageDialog(null, "Corriente : Impulsa a tu barco ,avanzas tres casillas", "Resultado ", JOptionPane.INFORMATION_MESSAGE);
                    }else if(existeEnArray(numRetrocede, numerodado2) ){
                        borrarCasillaPintada(numerodado2,1);
                        numerodado2-=4;
                        System.out.println("retroceder" +numerodado2);
                        pintarPosicion(numerodado2,1);
                        repaint();
                        JOptionPane.showMessageDialog(null, "El otroequipo lanza un cañon, retrocedes 4 casillas", "Resultado ", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else{
                    
                    btnActualizar.setText("TURNO : JUGADOR 2");
                    borrarCasillaPintada(numerodado2,1);
                    numerodado2 += rand.nextInt(5)+5;
                    juego.setNumeroDado2(numerodado2);
                    
                    pintarPosicion(juego.getNumeroDado2(),1);
                    System.out.println("Jugador 1 : "+juego.getNumeroDado2());
                    repaint();
                    if(existeEnArray(numpelea, numerodado2) ||existeEnArray(numpelea, numerodado)){
                        new VentanaPelea(barco1, barco2);
                        System.out.println("pelea ");
                    }
                    else if(existeEnArray(numSumaVida, numerodado)){
                        barco2.aumentarVidaEquipo(2);
                        System.out.println("suma " +numerodado);
                        JOptionPane.showMessageDialog(null, "Te encontraste con alimentos, Sube de vida +2 a todo el equipo", "Resultado ", JOptionPane.INFORMATION_MESSAGE);
                    }


                    else if(existeEnArray(numMenosVida, numerodado)){
                        barco2.bajarVidaEquipo(2);
                        System.out.println("menos " +numerodado);
                        JOptionPane.showMessageDialog(null, "Te encontraste con un calamar Baja la vida -2 a todo el equipo", "Resultado ", JOptionPane.INFORMATION_MESSAGE);
                    }

                    else if(existeEnArray(numAdelante, numerodado)){
                        borrarCasillaPintada(numerodado,2);
                        numerodado+=3;
                        System.out.println("adelantar" +numerodado);
                        pintarPosicion(numerodado,2);
                        repaint();
                        JOptionPane.showMessageDialog(null, "Corriente : Impulsa a tu barco ,avanzas tres casillas", "Resultado ", JOptionPane.INFORMATION_MESSAGE);
                    }

                    else if(existeEnArray(numRetrocede, numerodado)){borrarCasillaPintada(numerodado,2);
                        borrarCasillaPintada(numerodado,2);
                        numerodado-=4;
                        System.out.println("retroceder" +numerodado);
                        pintarPosicion(numerodado,2);
                        repaint();
                        JOptionPane.showMessageDialog(null, "El otroequipo lanza un cañon, retrocedes 4 casillas", "Resultado ", JOptionPane.INFORMATION_MESSAGE);
                    }
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
                    
                    System.out.println("Antes de borrar - Avatar: " + cActual.getAvatar());
                    cActual.setAvatar(null);
                    System.out.println("Después de borrar - Avatar: " + cActual.getAvatar());
                    repaint();
                    cActual.setColor(new Color(229, 231, 233,200));
                }
            }
        }
        
    }
    public void pintarPosicion(int n, int numeroBarco) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                Casilla cActual = tablero[i][j];
                if (cActual.getPosicion() == n && cActual.getNumerobarco() == numeroBarco) {
                    // Obtener el avatar de la tripulación
                    if(numeroBarco ==1){
                        ImageIcon avatar1=barco1.getAvatarTripulacion();
                        System.out.println("Avatar: " + avatar1);
                        // Establecer el fondo de la casilla con el avatar
                        cActual.setAvatar(avatar1);
                    }else{
                        ImageIcon avatar1=barco2.getAvatarTripulacion();
                        System.out.println("Avatar: " + avatar1);
                        // Establecer el fondo de la casilla con el avatar
                        cActual.setAvatar(avatar1);
                    }
                    
                }
            }
        }
        repaint(); // Llamada para repintar el panel y reflejar los cambios
    }

    // Método para obtener el avatar de la tripulación según el número del barco
    private ImageIcon obtenerAvatar(int numeroBarco) {
        if (numeroBarco == 1) {
            return barco1.getAvatarTripulacion(); // Reemplaza barco1 con tu objeto Tripulacion
        } else if (numeroBarco == 2) {
            return barco2.getAvatarTripulacion(); // Reemplaza barco2 con tu objeto Tripulacion
        }
        // Puedes manejar otros casos según sea necesario
        return null; // o un avatar predeterminado si es necesario
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
    public void definirEspeciales(){
        int[] numEspeciales= {3,4,9,10,14,15,18,19,20,21,24,25,27,28,31,32,33,34,36,37,42,43,50,51,57,58,59,60,68,69,70,71,75,76,77,78,80,81,83,84,87,88,94,95,96,97};
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                Casilla cActual = tablero[i][j];
                if (existeEnArray(numEspeciales, cActual.getPosicion())) {
                    cActual.setCasillaEspecial(true);
                }
            }
        }
        repaint(); 
    }
    public boolean existeEnArray(int[] array, int numero) {
        for (int elemento : array) {
            if (elemento == numero) {
                return true;
            }
        }
        return false;
    }
    public void paint (Graphics grafico){
        super.paint(grafico);
        grafico.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        for (int i = 0; i <tablero.length; i++){
            for (int j = 0; j < tablero[i].length; j++){
                Casilla cActual = tablero[i][j];
                Color colorCasilla = cActual.getColor();
                //grafico.setColor(colorCasilla);
                //grafico.fillRect(j*tamCasilla, i*tamCasilla,tamCasilla-1,tamCasilla-1);
                cActual.paint(grafico, j * tamCasilla, i * tamCasilla, tamCasilla - 1, tamCasilla - 1);
            }
        }
    }
    private void inicializarBotonGuardar() {
        btnGuardar = new JButton("Guardar Juego");
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                juego.guardarJuego("avance.txt");  
                System.out.println("Juego guardado correctamente.");
            }
        });

        add(btnGuardar, BorderLayout.NORTH);
    }

    public int getNumerodado() {
        return numerodado;
    }

    public void setNumerodado(int numerodado) {
        this.numerodado = numerodado;
    }

    public int getNumerodado2() {
        return numerodado2;
    }

    public void setNumerodado2(int numerodado2) {
        this.numerodado2 = numerodado2;
    }
    
    
    
}
