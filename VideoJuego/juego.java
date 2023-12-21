/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajofinal;

public class juego {
    public static void main(String[] args){
        Tripulacion barco1= new Tripulacion("Capitan Barbosa");
        System.out.println(barco1.getCantidadPiratas());
        Tripulacion barco2= new Tripulacion("Capitan Garfio");
        barco1.mostrarTodos();
        
    }
}
