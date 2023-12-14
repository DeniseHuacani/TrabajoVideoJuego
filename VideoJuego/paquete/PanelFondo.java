package paquete;
import javax.swing.*;
import java.util.*;
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
        add(new Juego());
    }
    private void inicilizarCamino(){
        tablero = new Casilla [20][12];
        for (int i = 0; i <tablero.length; i++){ //¨Inicilizamos todos las parte del tablero como no camino
            for (int j = 0; j < tablero[i].length; i++){
                Casilla cActual = tablero[i][j];
                cActual.setCamino(false);
            }
        }
        
    }
    public void paint (Graphics grafico){
        super.paint(grafico);
        for (int i = 0; i <tablero.length; i++){
            for (int j = 0; j < tablero[i].length; i++){
                Casilla cActual = tablero[i][j];
                Color colorCasilla = cActual.getColor();
                grafico.setColor(colorCasilla);
                grafico.fillRect(i*tamCasilla, j*tamCasilla,tamCasilla-1,tamCasilla-1);
            }
        }
        grafico.fillRect(1,1,1,1);
    }
}
