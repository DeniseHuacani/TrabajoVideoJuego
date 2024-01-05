/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajofinal;

import java.io.Serializable;
import java.util.Random;

public class Espadachin extends Piratas implements Serializable{
    private String tipoEspada; 
    
    public Espadachin(String na , double o,  boolean es){
        super(na,o, es);
        setVida(aleatorioVidas());
        setNivelAtaque(aleatorioNAtaque());
        tipoEspada = escogerTipoEspada();
    }
    public String escogerTipoEspada() {
        String[] tiposEspada = {"corta", "larga", "katana", "espada mágica"};
        Random rand = new Random();
        int indice = rand.nextInt(tiposEspada.length);

        switch (tiposEspada[indice]) {
            case "corta":
                
                setVida(getVida()-1);
                break;
            case "larga":
                setVida(getVida()+1);
                break;
            case "katana":
                setVida(getVida() + 2);
                break;
            case "espada mágica":
                setVida(getVida() + 3);
                break;
        }
        return tiposEspada[indice];
    }
    
    public int aleatorioNAtaque(){
        Random rand = new Random();
        return rand.nextInt(3)+5;
    }
    public int aleatorioVidas(){
        Random rand = new Random();
        return rand.nextInt(3)+5;
    }
}
