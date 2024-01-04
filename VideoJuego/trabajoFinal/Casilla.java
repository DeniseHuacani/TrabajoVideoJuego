package trabajofinal;

import java.awt.*;
import javax.swing.ImageIcon;
public class Casilla {
    private boolean perteneceCamino;
    private Color color;
    
    private int numerobarco;
    private int posicion;
    
    Color colorMar = new Color(0, 0, 255, 0); 
    Color colorCamino = new Color(229, 231, 233,200); 
    Color colorCamNoValido = new Color(185, 185, 185,200); 
    
    private ImageIcon avatar;
    public Casilla(){
        
    }
    public void setCamino(Boolean booleano){
        this.perteneceCamino = booleano;
        
        if (booleano)
            color = colorCamino;
        else{
            color = colorMar;
        } 
            
    }
    public void setCaminoNoValido(){
        color = colorCamNoValido;
    }
    public boolean getPerteneceCamino(){
        return perteneceCamino;
    }
    public Color getColor(){
        return color;
    }
    public void setColor(Color nuevoColor) {
        color = nuevoColor;
    }
    
    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getNumerobarco() {
        return numerobarco;
    }

    public void setNumerobarco(int numerobarco) {
        this.numerobarco = numerobarco;
    }
    public void setAvatar(ImageIcon img) {
        if(img==null){
            avatar=null;
        }else{
            Image maspequeñoImage = img.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            if (maspequeñoImage == null) {
                System.out.println("La imagen escalada es nula");
            } else {
                // Crear un nuevo ImageIcon con la imagen escalada
                this.avatar = new ImageIcon(maspequeñoImage);

                // Además de establecer el avatar, establecer el fondo de la casilla con el color transparente
                this.color = new Color(0, 0, 0, 0);
            }
        }
        
    }
    public ImageIcon getAvatar(){
        return avatar;
    }
    
    public void paint(Graphics g, int x, int y, int width, int height) {
        g.setColor(color);
        g.fillRect(x, y, width, height);

        if (avatar != null) {
            // Dibujar el avatar en el centro de la casilla
            int avatarX = x + (width - avatar.getIconWidth()) / 2;
            int avatarY = y + (height - avatar.getIconHeight()) / 2;
            avatar.paintIcon(null, g, avatarX, avatarY);
        }
    }
}
