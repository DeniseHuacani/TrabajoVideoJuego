package trabajofinal;
import java.awt.*;
import java.io.*;
import javax.swing.*;
public class Juego extends JFrame implements Serializable{
    
    private Tripulacion barco1;
    private Tripulacion barco2;
    private int numeroDado=0;
    private int numeroDado2=0;
    
    
    public Juego(Tripulacion barc1, Tripulacion barc2) {
        barco1 = barc1;
        barco2= barc2;
        setLocation(300, 200);
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PanelFondo tablero = new PanelFondo(8000, 240, barco1, barco2, this);
        System.out.println("Información de los piratas en barco1:");
        for (Piratas pirata : barco1.getTripulacion()) {
            System.out.println(pirata.toString());
        }

        add(tablero);

        setVisible(true);
    }
    public void guardarJuego(String archivo) {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(archivo))) {
            salida.writeObject(this);
            System.out.println("Juego guardado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Juego cargarJuego(String archivo) {
        Juego juego = null;
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivo))) {
            juego = (Juego) entrada.readObject();
            System.out.println("Juego cargado correctamente.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return juego;
    }
    private void cargarJuegoGuardado() {
        String archivo = "nombre_archivo.dat";  // Ajusta el nombre del archivo donde guardaste el juego
        Juego juegoGuardado = cargarJuego(archivo);

        if (juegoGuardado != null) {
            // Cierra el juego actual
            dispose();

            // Abre un nuevo menú para empezar desde allí
            new Menu();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo cargar el juego guardado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public Tripulacion getBarco1() {
        return barco1;
    }

    public Tripulacion getBarco2() {
        return barco2;
    }
    public int getNumeroDado(){
        return numeroDado;
    }
    public int getNumeroDado2(){
        return numeroDado2;
    }

    public void setNumeroDado(int numeroDado) {
        this.numeroDado = numeroDado;
    }

    public void setNumeroDado2(int numeroDado2) {
        this.numeroDado2 = numeroDado2;
    }
    
}
