/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajofinal;

import java.io.Serializable;
import java.util.*;
public class Capitan extends Piratas implements Serializable{
    
    public Capitan(String na , double o, boolean es){
        super(na,o,es);
        setVida(aleatorioVidas());
        setNivelAtaque(aleatorioNAtaque());
        
    }
    public int aleatorioNAtaque(){
        Random rand = new Random();
        return rand.nextInt(10)+1;
    }
    public int aleatorioVidas(){
        Random rand = new Random();
        return rand.nextInt(10)+1;
    }
    
    
}
