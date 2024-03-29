/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pascal.Analisis;

/**
 *
 * @author Carlos
 */
public class MessageError {
    String tipo;
    int l;
    int c;
    String detalle;
    String archivo;

    /**
     * CONSTRUCTOR DE LA CLASE PARA EL MANEJO DE ERRORES
     * @param tipo
     * @param l
     * @param c
     * @param detalle 
     */
    public MessageError(String tipo, int l, int c, String detalle) {
        this.tipo = tipo;
        this.l = l;
        this.c = c;
        this.detalle = detalle;
    }
    
    public String getError(){
        return tipo + ": " + detalle + " , Linea: " + l + ", Columna: " +  c;
    }

    public String getTipo() {
        return tipo;
    }

    public int getL() {
        return l;
    }

    public int getC() {
        return c;
    }

    public String getDetalle() {
        return detalle;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }
    
    
    
    
}
