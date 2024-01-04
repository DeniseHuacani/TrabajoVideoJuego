package trabajofinal;
import java.awt.*;
import javax.swing.*;
public class Juego extends JFrame{
    
    
    public Juego(Tripulacion barco1, Tripulacion barco2) {
        setLocation(300, 200);
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PanelFondo tablero = new PanelFondo(8000, 240, barco1, barco2);
        System.out.println("Información de los piratas en barco1:");
        for (Piratas pirata : barco1.getTripulacion()) {
            System.out.println(pirata.toString());
        }

        add(tablero);

        setVisible(true);
    }

}
