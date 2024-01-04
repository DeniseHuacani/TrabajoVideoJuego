/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajofinal;

import java.util.*;
public class Tripulacion {
    private ArrayList<Piratas> tripulacion;
    public int CANTIDAD_MAXIMA=10;
    private int cantidadPiratas;
    private String capitan;
    
    public Tripulacion(String capi) {
        tripulacion = new ArrayList<Piratas>();
        tripulacion.add(new Capitan(capitan,100,true)); //añadimos a ti, capitan
        reclutarPiratas();
        capitan = capi;
    }
    private void reclutarPiratas() {
        Random rand = new Random();
        cantidadPiratas = rand.nextInt(CANTIDAD_MAXIMA - 6) + 6; // De 6 a 9 

        int espadachines = 0, barbaros = 0, marinos = 0, artilleros = 0;

        while (tripulacion.size() < cantidadPiratas) {
            int tipoPirata = rand.nextInt(4); // 0: Espadachin, 1: Barbaro, 2: Marino, 3: Artillero
            switch (tipoPirata) {
                case 0:
                    tripulacion.add(crearPirataAleatorio(espadachines, "Espadachin"));
                    espadachines++;
                    break;
                case 1:
                    tripulacion.add(crearPirataAleatorio(barbaros, "Barbaro"));
                    barbaros++;
                    break;
                case 2:
                    tripulacion.add(crearPirataAleatorio(marinos, "Marino"));
                    marinos++;
                    break;
                case 3:
                    tripulacion.add(crearPirataAleatorio(artilleros, "Artillero"));
                    artilleros++;
                    break;
            }
        }
        
    } 
    private Piratas crearPirataAleatorio(int n, String tipo) {
        Random rand = new Random();

        switch (tipo) {
            case "Espadachin":
                return new Espadachin(
                        "Espadachin-"+n,
                        rand.nextInt(1001),       // Oro entre 0 y 1000
                        true );
            case "Barbaro":
                return new Barbaro(
                        "Barbaro-"+n,
                        rand.nextInt(31) + 90,
                        true);
            case "Marino":
                return new Marino(
                        "Marino-"+n,
                        rand.nextInt(31) + 90,
                        true);
                
            case "Artillero":
                return new Artillero(
                        "Marino-"+n,
                        rand.nextInt(31) + 90,
                        true);
                
            default:
                System.out.println("Error : no creando pirata");
                return null;
                
        }
    }
    public void mostrarTodos() {
        for (Piratas pirata : tripulacion) {
            System.out.println("-------------------------\n"+pirata.toString()+"\n");
        }
    }

    public int getCantidadPiratas() {
        return cantidadPiratas;
    }
    public ArrayList<Piratas> getTripulacion() {
        return tripulacion;
    }

    public String getCapitan() {
        return capitan;
    }
    
    

}
