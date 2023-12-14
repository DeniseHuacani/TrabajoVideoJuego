package paquete;
import javax.swing.*;
import java.awt.*;
public class PanelFondo extends JPanel {
    protected int cantidadCasillas;
    protected int tamMax;
    protected int tamCasilla;
    protected Casilla[][] tablero;
    Color colorArena = Color.YELLOW;
    Color colorCamino = Color.BLUE;
    
    public PanelFondo(int tamMax,int cantidadCasillas){
        this.tamMax = tamMax;
        this.cantidadCasillas = cantidadCasillas;
        tamCasilla = tamMax/cantidadCasillas;
        inicializarCamino();
    }
    private void inicializarCamino(){
        tablero = new Casilla [12][20];
        for (int i = 0; i <tablero.length; i++){ //¨Inicilizamos todas las casillas como noCamino
            for (int j = 0; j < tablero[i].length; j++){
                tablero[i][j] = new Casilla();
                Casilla cActual = tablero[i][j];
                cActual.setCamino(false);
            }
        } //Comenzamos definiendo camino, camino horizontal
        for (int i = 2; i <= 18; i++){
            tablero[3][i].setCamino(true);//horizontal
            if (i >= 7)
                tablero[9][i].setCamino(true); //horizontal
            if( i >= 4)
                tablero[10][i].setCamino(true);//horizontal
        }
        for (int i = 2; i <= 15; i++){
            tablero[5][i].setCamino(true);     //horizontal
            if (i >= 7)
                tablero[7][i].setCamino(true); //horizontal
            if (i >= 3 && i <=9)
                tablero[i][18].setCamino(true); // vertical
            if (i >= 5 && i <= 7){
                tablero[i][15].setCamino(true);//vertical
                tablero[i][2].setCamino(true); //vertical
            }
        } 
        
    }
    public void paint (Graphics grafico){
        super.paint(grafico);
        for (int i = 0; i <tablero.length; i++){
            for (int j = 0; j < tablero[i].length; j++){
                Casilla cActual = tablero[i][j];
                Color colorCasilla = cActual.getColor();
                grafico.setColor(colorCasilla);
                grafico.fillRect(i*tamCasilla, j*tamCasilla,tamCasilla-1,tamCasilla-1);
            }
        }
    }
}
