/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pascal.Componentes;

import Pascal.Analisis.Ambito;
import Pascal.Analisis.Generador;
import Pascal.Analisis.Instruccion;
import Pascal.Analisis.MessageError;
import Pascal.Analisis.Nodo;
import Pascal.Analisis.TipoDato.Tipo;
import java.util.LinkedList;

/**
 *
 * @author Carlos
 */
public class Writeln implements Instruccion {
    
    Expresion expresion;
    Boolean salto;

    /**
     * CONSTRUCTOR DE LA CLASE 
     * @param expresion
     * @param salto 
     */
    public Writeln(Expresion expresion, Boolean salto) {
        this.expresion = expresion;
        this.salto = salto;
    }
    
    
    
    
    /**
     * METODO DE LA CLASE PADRE
     * @param ambito
     * @return 
     */
    @Override
    public Object ejecutar(Ambito ambito) {
        Object resultado = (expresion == null) ? null : expresion.ejecutar(ambito);
        if(resultado == null) return -1;
        else if(resultado instanceof MessageError) return -1;
        
        Nodo nodo = (Nodo) resultado;
        ambito.addCodigo(nodo.getCodigo3D());
        if(nodo.getTipo() == Tipo.INT) ambito.addCodigo("Print(%e," + nodo.getResultado() + ")");
        else if(nodo.getTipo() == Tipo.DOUBLE) ambito.addCodigo("Print(%d," + nodo.getResultado() + ")");
        else if(nodo.getTipo() == Tipo.CHAR) ambito.addCodigo("Print(%c," + nodo.getResultado() + ")");
        else if(nodo.getTipo() == Tipo.BOOLEAN){
           String codigo = Generador.getAllEtiquetas(nodo.getEtiquetaV());
           String etiquetaSalto = Generador.generarEtiqueta();
           codigo += "\n Print(%c," + "84" + ")"; // -------------------- T
           codigo += "\n Print(%c," + "114" + ")"; // -------------------- r
           codigo += "\n Print(%c," + "117" + ")"; // -------------------- u
           codigo += "\n Print(%c," + "101" + ")"; // -------------------- e
           codigo += "\n" + Generador.saltoIncondicional(etiquetaSalto);
           codigo += "\n" + Generador.getAllEtiquetas(nodo.getEtiquetaF());
           codigo += "\n Print(%c," + "70" + ")"; // -------------------- F
           codigo += "\n Print(%c," + "97" + ")"; // -------------------- a
           codigo += "\n Print(%c," + "108" + ")"; // -------------------- l
           codigo += "\n Print(%c," + "115" + ")"; // -------------------- s
           codigo += "\n Print(%c," + "101" + ")"; // -------------------- e
           codigo += "\n" + Generador.guardarEtiqueta(etiquetaSalto);
           ambito.addCodigo(codigo);
        }
        else if(nodo.getTipo() == Tipo.STRING || nodo.getTipo() == Tipo.WORD){
            String codigo = "";
            String etiquetaRecursiva = Generador.generarEtiqueta();
            //------------------------------------------------------- POSICION ACTUAL EN EL HEAP Y SU VALOR
            String pos = Generador.generarTemporal();
            codigo = "\n" + Generador.generarCuadruplo("+", nodo.getResultado(), "0", pos);
            //------------------------------------------------------- La etiqueta encargada de crear un loop

            codigo += "\n" + Generador.guardarEtiqueta(etiquetaRecursiva);

            String valor = Generador.generarTemporal();
            codigo += "\n" + Generador.guardarAcceso(valor, "Heap", pos);
            //------------------------------------------------------ CONDICIONES DE FIN DE CADENA -----------------------------------------------------------
            String finVerdadera = Generador.generarEtiqueta();
            String numeroVerdadera = Generador.generarEtiqueta();
            String saltoFalsa = Generador.generarEtiqueta();
            
            codigo += "\n" + Generador.guardarCondicional(finVerdadera, valor, "0", "=");
            //----------------------------------------------------- CONDICION SI ES UN NUMERO (ENTERO) -----------------------------------------------------
            codigo += "\n" + Generador.guardarCondicional(numeroVerdadera, valor, "-777.777", "=");
            //----------------------------------------------------- TIENE QUE SER UN CARACTER -------------------------------------------------------------
            codigo += "\n Print(%c," + valor + ")";
            codigo += "\n" + Generador.saltoIncondicional(saltoFalsa);
            //------------------------------------------------------ ES UN NUMERO ---------------------------------------------------------------------------------
            codigo += "\n" + Generador.guardarEtiqueta(numeroVerdadera);
            codigo += "\n" + Generador.generarCuadruplo("+", pos, "1", pos);
            codigo += "\n" + Generador.guardarAcceso(valor, "Heap", pos);
            codigo += "\n Print(%d," + valor + ")";
            //------------------------------------------------- SALTO QUE SE GENERA DESPUES DE IMPRIMIR ----------------------------------------------
            codigo += "\n" + Generador.guardarEtiqueta(saltoFalsa);
            codigo += "\n" + Generador.generarCuadruplo("+", pos, "1", pos);
            codigo += "\n" + Generador.saltoIncondicional(etiquetaRecursiva);
            //---------------------------------------------------- SALIDA -----------------------------------------------------------------------------
            codigo += "\n" + Generador.guardarEtiqueta(finVerdadera);
            ambito.addCodigo(codigo);
        }
        
        if(salto) ambito.addCodigo("Print(%c,10)");
        
        return -1;
    }
    
}