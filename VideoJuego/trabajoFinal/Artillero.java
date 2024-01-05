package trabajofinal;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author Toshiba
 */
public class Artillero extends Piratas implements Serializable{
    private int cantidadBalas;
    
    public Artillero(String na , double o,  boolean es){
        super(na,o,es);
        setVida(aleatorioVidas());
        setNivelAtaque(aleatorioNAtaque());
        
    }
    public int aleatorioNAtaque(){
        Random rand = new Random();
        return rand.nextInt(2)+7;
    }
    public int aleatorioVidas(){
        Random rand = new Random();
        return rand.nextInt(4)+5;
    }
}
