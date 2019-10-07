/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pascal.Analisis;

import java.util.LinkedList;

/**
 *
 * @author Carlos
 */
public class Nodo extends TipoDato {
    String resultado;
    Tipo tipo;
    LinkedList<String> etiquetaV;
    LinkedList<String> etiquetaF;
    String codigo3D;

    /**
     * CONSTRUCTOR DE LA CLASE
     */
    public Nodo() {
        etiquetaV = new LinkedList<>();
        etiquetaF = new LinkedList<>();
    }

   
    /**
     * TIPO DE RESULTADO
     * @param tipo 
     */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public Tipo getTipo() {
        return tipo;
    }
    
    
    /**
     * ETIQUETA,ID,VALOR PRIMITIVO
     * @param tipo 
     */
    public String getResultado() {
        return resultado;
    }
    
    /**
     * ETIQUETA,ID,VALOR PRIMITIVO
     * @param tipo 
     */
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    /**
     * SE OBTIENEN LAS ETIQUETAS VERDADERAS
     * @return 
     */
    public LinkedList<String> getEtiquetaV() {
        return etiquetaV;
    }

    /**
     * SE AGREGAN ETIQUETAS VERDADERAS
     * @param etiquetaV 
     */
    public void addEtiquetaV(String etiquetaV) {
        this.etiquetaV.addLast(etiquetaV);
    }
    
    /**
     * SE AGREGAN ETIQUETAS VERDADERAS
     * @param etiquetaV 
     */
    public void addEtiquetaV(LinkedList<String> etiquetaV) {
        this.etiquetaV.addAll(etiquetaV);
    }
    /**
     * SE OBTIENEN LAS ETIQUETAS FALSAS
     * @return 
     */
    public LinkedList<String> getEtiquetaF() {
        return etiquetaF;
    }

   /**
     * SE AGREGAN ETIQUETAS FALSAS
     * @param etiquetaF 
     */
    public void addEtiquetaF(String etiquetaF) {
        this.etiquetaF.addLast(etiquetaF);
    }
    
    /**
     * SE AGREGAN ETIQUETAS FALSAS ( N ETIQUETAS FALSAS)
     * @param etiquetaF 
     */
    public void addEtiquetaF(LinkedList<String> etiquetaF) {
        this.etiquetaF.addAll(etiquetaF);
    }

    /**
     * SETEA LAS ETIQUETAS VERDADERAS
     * @param etiquetaV 
     */
    public void setEtiquetaV(LinkedList<String> etiquetaV) {
        this.etiquetaV = etiquetaV;
    }

    /**
     * SETEA LAS ETIQUETAS FALSAS
     * @param etiquetaF 
     */
    public void setEtiquetaF(LinkedList<String> etiquetaF) {
        this.etiquetaF = etiquetaF;
    }

    /**
     * SETEA EL CODIGO 3D
     * @return 
     */
    public String getCodigo3D() {
        return codigo3D;
    }

    /**
     * OBTENGO EL CODIGO 3D
     * @param codigo3D 
     */
    public void setCodigo3D(String codigo3D) {
        this.codigo3D = codigo3D;
    }
    
    
    
    
    
    
    
    
    
    
}