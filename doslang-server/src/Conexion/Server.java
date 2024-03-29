/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Pascal.Analisis.Analizar;
import Pascal.Analisis.Estructuras;
import Pascal.Analisis.Generador;
import Pascal.Analisis.MessageError;
import Pascal.Analisis.Simbolo;
import io.socket.client.IO;

import io.socket.client.Socket;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 *
 * @author Carlos
 */
public class Server   {
    Socket socket = IO.socket("http://127.0.0.1:3000");

    /**
     *
     * @throws java.net.URISyntaxException
     */
    public Server() throws URISyntaxException   {
        
        socket.connect(); //-------------------------- Establecemos la conexion ------------------------
        //----------------------------------------- LISTENER PARA OBTENER MENSAJES DE REGRESO ----------------
        socket.on("sendCode", (Object... os) -> {
            String mensaje = (String)os[0];
            System.out.println("Recibiendo Codigo para su analisis");
            try {
                JSONArray array = new JSONArray(mensaje);
                Estructuras.archivos = new HashMap<>();
                Estructuras.stackGeneral = new LinkedList<>();
                
                //-------------------------- LLENAMOS EL HASHMAP CON TODOS LOS ARCHIVOS DEL PROGRAMA
                for(int i = 0; i < array.length(); i++){
                    JSONObject archivo = array.getJSONObject(i);
                    ;
                    Estructuras.archivos.put(archivo.getString("name").toLowerCase(), archivo.getString("body"));
                }
                Generador.temporal = 0;
                Generador.stack = 0;
                Generador.etiqueta = 0;
                String cuerpoPrincipal = Estructuras.archivos.get("principal"); //---------------Archivo Principal
                Analizar analizar = new Analizar(cuerpoPrincipal,"Principal",1);
                Object result = analizar.ejecutar();
                String resultado = "";
                if(result instanceof LinkedList){
                    LinkedList<MessageError> errores = (LinkedList<MessageError>)result;
                    resultado = "{\n\"data\":[\n";
                    int index = 1;
                    
                    for(MessageError m:errores){
                        
                        resultado += "{\n\"Tipo\":\"" + m.getTipo() + "\",\n" + "\"Detalle\":\"" + m.getDetalle() + " Archivo: " + m.getArchivo();
                        resultado += "\",\n\"Linea\":" + m.getL() + ",\n\"Columna\":" + m.getC();
                        resultado += (index == errores.size()) ? "\n}" : "\n},";
                        index++;
                    }
                    
                    resultado += "\n]\n}";
                }else resultado = (String)analizar.ejecutar();
                 socket.emit("result",resultado); //---------------- ENVIAMOS EL RESULTADO DEL ANALISIS YA SEA UN CODIGO TRADUCIO / ERRORES
                System.out.println("Retornando resultado de analisis");
            } catch (JSONException ex) {
                System.err.println("Error al convertir la entrada a JSONArray: " +  ex.getMessage());
            } catch (Exception ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        //-------------------------------------------------- LISTENER PARA REPORTES ------------------------------------------------------------
        socket.on("reporteStack",(Object... os) -> {
            String json = "[\n";
            int index = 1;
            for(Simbolo s: Estructuras.stackGeneral){
                json += "{\n\"id\":\"" + s.getId() + "\",";
                json += "\n\"constante\":\"" + s.getConstante() + "\",";
                json += "\n\"posicion\":" + s.getPosStack() + ",";
                json += "\n\"posicionrel\":" + s.getPosRelativa() + ",";
                json += "\n\"tipo\":\"" + s.getTipo() + "\",";
                json += "\n\"parametro\":\"" + s.getParametro() + "\",";
                json += "\n\"referencia\":\"" + s.getReferencia() + "\",";
                json += "\n\"ambito\":\"" + s.getAmbito() + "\",";
                json += "\n\"archivo\":\"" + s.getArchivo() + "\"\n}";
                json += ((index == Estructuras.stackGeneral.size()) ? "\n" : ",\n");
                index ++;
            }
            json += "\n]";
            socket.emit("reporte",json);
        });
        
        socket.open(); //-------------------------------------------------Abrimos la conexion ---------------------------
        
    }
    
    public void sendMessage(){
        //socket.send("new","hl");
        socket.emit("new","hahshdas");
        System.out.println("hhhsahs");
    }
    
    
    
    
    
}
