/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doslang.server;

import Analisis.Ambito;
import Analisis.Instruccion;
import Parser.Lexico;
import Parser.Sintactico;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.LinkedList;

/**
 *
 * @author Carlos
 */
public class DoslangServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        interpretar("/Test.txt");
    }
    
    /**
     * METODO QUE LEERA EL ARCHIVO TEST PARA SUS RESPECTIVA TEST
     * @param direccion direccion del archivo de texto
     */
    
    private static void interpretar(String direccion){
        Sintactico sintactico;
        String path = new File("").getAbsolutePath() + "/src/Test";
        try{
            Reader reader = new BufferedReader(new FileReader(path + direccion));
            sintactico = new Sintactico(new Lexico(reader));
            sintactico.parse();
            LinkedList<Instruccion> lista = sintactico.getLista();
            Ambito global = new Ambito("global",null,direccion);
            for(Instruccion ins : lista){
                ins.ejecutar(global);
            }
            System.out.println(global.getCodigo());
        }catch(Exception e){
            System.err.println("Error de compilacion: " + e.getMessage());
        }
    }
    
}