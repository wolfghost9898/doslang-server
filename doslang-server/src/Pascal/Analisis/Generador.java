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
public class Generador {
    static int temporal = 0;
    static int etiqueta = 0;
    
    
    public static String generarTemporal(){
       String  temp = "t" + temporal;
        temporal++;
        return temp;
    }
    
    public static String generarEtiqueta(){
        String temp = "L" + etiqueta;
        etiqueta++;
        return temp;
    }
    
    
    public static String generarCuadruplo(String operador, String operando1, String operando2, String temporal){
        return operador +  "," + operando1 + "," + operando2 + "," + temporal;
    }
    
    public static String generarComentarioSimple(String texto){
        return "//" + texto ;
    }
    
    public static String guardarEnPosicion(String estructura, String pos, String valor){
        return "=," + pos + "," + valor + "," + estructura;
    }
    
    public static String guardarEtiqueta(String codigo){
        return codigo + ":";
    }
    
    public static String guardarAcceso(String temporal, String estructura, String pos){
        return "=," + estructura + "," + pos + "," + temporal;
    }
    
    public static String guardarCondicional(String etiquetaF,String operadorIzq,String operadorDer,String operador){
        String simbolo = "";
        if(operador == "=") simbolo = "Je";
        else if(operador == "<>") simbolo = "Jne";
        else if(operador == ">") simbolo = "Jg";
        else if(operador == "<") simbolo = "Jl";
        else if(operador == ">=") simbolo = "Jge";
        else simbolo = "Jle";
        return simbolo + "," + operadorIzq + "," + operadorDer + "," + etiquetaF;
    }
    
    public static String saltoIncondicional(String etiquetaF){
        return "Jmp,,," + etiquetaF;
    }
    
    public static String getAllEtiquetas(LinkedList<String> etiquetas){
        String codigo = "";
        for(String s : etiquetas){
            codigo += "\n" + s + ":" ;
        }
        return codigo;
    }
}
