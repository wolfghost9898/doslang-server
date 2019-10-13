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
import Pascal.Analisis.Simbolo;
import Pascal.Analisis.TipoDato;

/**
 *
 * @author Carlos
 */
public class Expresion extends TipoDato implements Instruccion {

    Expresion izq;
    Expresion der;
    Tipo tipo;
    Operacion operacion;
    int l;
    int c;
    Object valor;

    /**
     * CONSTRUCTOR PARA OPERACIONES TERNARIAS NUM + NUM
     *
     * @param izq
     * @param der
     * @param operacion
     * @param l
     * @param c
     */
    public Expresion(Expresion izq, Expresion der, Operacion operacion, int l, int c) {
        this.izq = izq;
        this.der = der;
        this.operacion = operacion;
        this.l = l;
        this.c = c;
    }

    /**
     * CONSTRUCTOR PARA VALORES PRIMITIVOS
     *
     * @param izq
     * @param tipo
     * @param l
     * @param c
     */
    public Expresion(Object valor, Tipo tipo, int l, int c) {
        this.valor = valor;
        this.tipo = tipo;
        this.l = l;
        this.c = c;
        this.operacion = null;
    }

    /**
     * CONSTRUCTOR DEL METODO PADRE
     *
     * @param ambito
     * @return
     */
    @Override
    public Object ejecutar(Ambito ambito) {
        MessageError error = new MessageError("", l, c, "");
        Object op1 = (izq == null) ? null : izq.ejecutar(ambito);
        Object op2 = (der == null) ? null : der.ejecutar(ambito);
        String codigo = "";
        if (operacion != null) {
            if (op1 instanceof MessageError || op2 instanceof MessageError) {
                if (op1 instanceof MessageError) {
                    error = (MessageError) op1;
                } else if (op2 instanceof MessageError) {
                    error = (MessageError) op2;
                }
                return error;
            }
            Nodo nodoIzq = (Nodo) op1;
            Nodo nodoDer = (op2 == null) ? null :(Nodo) op2;
            codigo = "";
            switch (operacion) {
                //<editor-fold defaultstate="collapsed" desc="SUMA">
                case SUMA:
                    //-------------------------------- INT + INT || CHAR + INT || INT + CHAR || CHAR + CHAR --------------------------------------------------------
                    if (nodoIzq.getTipo() == Tipo.INT && nodoDer.getTipo() == Tipo.INT
                            || nodoIzq.getTipo() == Tipo.CHAR && nodoDer.getTipo() == Tipo.INT
                            || nodoIzq.getTipo() == Tipo.INT && nodoDer.getTipo() == Tipo.CHAR
                            || nodoIzq.getTipo() == Tipo.CHAR && nodoDer.getTipo() == Tipo.CHAR) {
                        String temp = Generador.generarTemporal();
                        codigo = nodoIzq.getCodigo3D();
                        codigo += nodoDer.getCodigo3D();
                        codigo += "\n" + Generador.generarCuadruplo("+", nodoIzq.getResultado(), nodoDer.getResultado(), temp);
                        
                        Nodo resultado = new Nodo();
                        resultado.setTipo(Tipo.INT);
                        resultado.setResultado(temp);
                        resultado.setCodigo3D(codigo);
                        return resultado;
                    } //------------------------------- INT DOUBLE | DOUBLE INT | DOUBLE DOUBLE || CHAR DOUBLE || DOUBLE CHAR-----------------------------------
                    else if (nodoIzq.getTipo() == Tipo.INT && nodoDer.getTipo() == Tipo.DOUBLE || nodoIzq.getTipo() == Tipo.DOUBLE && nodoDer.getTipo() == Tipo.INT
                            || nodoIzq.getTipo() == Tipo.DOUBLE && nodoDer.getTipo() == Tipo.DOUBLE
                            || nodoIzq.getTipo() == Tipo.CHAR && nodoDer.getTipo() == Tipo.DOUBLE
                            || nodoIzq.getTipo() == Tipo.DOUBLE && nodoDer.getTipo() == Tipo.CHAR) {
                        String temp = Generador.generarTemporal();
                        codigo = nodoIzq.getCodigo3D();
                        codigo += nodoDer.getCodigo3D();
                        codigo += "\n" + Generador.generarCuadruplo("+", nodoIzq.getResultado(), nodoDer.getResultado(), temp);
                        Nodo resultado = new Nodo();
                        resultado.setTipo(Tipo.DOUBLE);
                        resultado.setResultado(temp);
                        resultado.setCodigo3D(codigo);
                        return resultado;
                    } //-------------------------- WORD X | X WORD | X STRING | STRING X -------------------------------------------------------------------------
                    else if (nodoIzq.getTipo() == Tipo.WORD || nodoDer.getTipo() == Tipo.WORD || nodoIzq.getTipo() == Tipo.STRING || nodoDer.getTipo() == Tipo.STRING) {
                        Tipo sendTipo = (nodoIzq.getTipo() == Tipo.STRING && nodoDer.getTipo() == Tipo.STRING) ? Tipo.STRING : Tipo.WORD;
                        Nodo resultado = new Nodo();
                        resultado.setTipo(sendTipo);
                        String temp = Generador.generarTemporal();
                        resultado.setResultado(temp);
                        codigo = nodoIzq.getCodigo3D();
                        codigo += nodoDer.getCodigo3D();
                        codigo += "\n" + Generador.generarComentarioSimple("INICIO Concatenacion: ");
                        codigo += "\n" + Generador.generarCuadruplo("+", "H", "0", temp);
                        codigo += "\n" + Generador.generarComentarioSimple("Reservando nuevo espacio: ");
                        
                        if (nodoIzq.getTipo() == Tipo.BOOLEAN) {
                            Nodo nodoTemp = guardarCadena3D((nodoIzq.getResultado().toLowerCase().equals("true") ? "True" : "False"), Tipo.WORD, ambito);
                            codigo += "\n" + concatenar(nodoTemp.getResultado(), Tipo.WORD);
                        } else {
                             codigo += "\n" + concatenar(nodoIzq.getResultado(), nodoIzq.getTipo());
                        }
                        if (nodoDer.getTipo() == Tipo.BOOLEAN) {
                            Nodo nodoTemp = guardarCadena3D((nodoDer.getResultado().toLowerCase().equals("true") ? "True" : "False"), Tipo.WORD, ambito);
                             codigo += "\n" +  concatenar(nodoTemp.getResultado(), Tipo.WORD);
                        } else {
                             codigo += "\n" + concatenar(nodoDer.getResultado(), nodoDer.getTipo());
                        }
                        codigo += "\n" + Generador.generarComentarioSimple("FIN Concatenacion: ");
                        codigo += "\n" + Generador.guardarEnPosicion("Heap", "H", "0");
                        codigo += "\n" + Generador.generarCuadruplo("+", "H", "1", "H");
                        resultado.setCodigo3D(codigo);
                        return resultado;

                    }
                    else{
                        MessageError mensajeError = new MessageError("Semantico",l,c,"No se pueden sumar : " + nodoIzq.getTipo() + " con: " + nodoDer.getTipo());
                        ambito.addSalida(mensajeError);
                        return mensajeError;
                    }
//</editor-fold>

                    

                //<editor-fold defaultstate="collapsed" desc="RESTA,MULTIPLICACION,DIVISION,MODULO">
                case RESTA:
                case MULTIPLICACION:
                case DIVISION:
                case MODULO:
                    //------------------------------------ INT DOUBLE | DOUBLE INT | DOUBLE DOUBLE || CHAR DOUBLE || DOUBLE CHAR------------
                    if (nodoIzq.getTipo() == Tipo.INT && nodoDer.getTipo() == Tipo.DOUBLE || nodoIzq.getTipo() == Tipo.DOUBLE && nodoDer.getTipo() == Tipo.INT
                            || nodoIzq.getTipo() == Tipo.DOUBLE && nodoDer.getTipo() == Tipo.DOUBLE
                            || nodoIzq.getTipo() == Tipo.CHAR && nodoDer.getTipo() == Tipo.DOUBLE
                            || nodoIzq.getTipo() == Tipo.DOUBLE && nodoDer.getTipo() == Tipo.CHAR) {
                        String temp = Generador.generarTemporal();
                        String simbolo = "";
                        if (operacion == Operacion.RESTA) simbolo = "-";
                        else if (operacion == Operacion.MULTIPLICACION)simbolo = "*";
                        else if(operacion == Operacion.MODULO) simbolo = "%";
                        else simbolo = "/";
                        codigo = nodoIzq.getCodigo3D();
                        codigo +=  nodoDer.getCodigo3D();
                        codigo += "\n" + Generador.generarCuadruplo(simbolo, nodoIzq.getResultado(), nodoDer.getResultado(), temp);
                        Nodo resultado = new Nodo();
                        resultado.setTipo(Tipo.DOUBLE);
                        resultado.setResultado(temp);
                        resultado.setCodigo3D(codigo);
                        return resultado;
                    }
                    // --------------------------------------- INT  INT || INT CHAR || CHAR INT || CHAR CHAR-------------------------------
                    else if (nodoIzq.getTipo() == Tipo.INT && nodoDer.getTipo() == Tipo.INT 
                            || nodoIzq.getTipo() == Tipo.INT && nodoDer.getTipo() == Tipo.CHAR
                            || nodoIzq.getTipo() == Tipo.CHAR && nodoDer.getTipo() == Tipo.INT
                            || nodoIzq.getTipo() == Tipo.INT && nodoDer.getTipo() == Tipo.CHAR) {
                        String temp = Generador.generarTemporal();
                        String simbolo = "";
                        if (operacion == Operacion.RESTA) simbolo = "-";
                        else if (operacion == Operacion.MULTIPLICACION)simbolo = "*";
                        else if(operacion == Operacion.MODULO) simbolo = "%";
                        else simbolo = "/";
                        codigo = nodoIzq.getCodigo3D();
                        codigo +=  nodoDer.getCodigo3D();
                        codigo += "\n" + Generador.generarCuadruplo(simbolo, nodoIzq.getResultado(), nodoDer.getResultado(), temp);
                        ambito.addCodigo(codigo);
                        Nodo resultado = new Nodo();
                        resultado.setTipo(Tipo.INT);
                        resultado.setResultado(temp);
                        resultado.setCodigo3D("");
                        return resultado;
                    }
                    else{
                        MessageError mensajeError = new MessageError("Semantico",l,c,"No se pueden operar : " + nodoIzq.getTipo() + " con: " + nodoDer.getTipo());
                        ambito.addSalida(mensajeError);
                        return mensajeError;
                    }
//</editor-fold>
                    
                //<editor-fold defaultstate="collapsed" desc="POTENCIA">
                case POTENCIA:
                    //----------------------------------------- INT INT || CHAR INT || INT CHAR || CHAR CHAR-----------------------------------------------------------------------------
                    if (nodoIzq.getTipo() == Tipo.INT && nodoDer.getTipo() == Tipo.INT
                            || nodoIzq.getTipo() == Tipo.CHAR && nodoDer.getTipo() == Tipo.INT
                            || nodoIzq.getTipo() == Tipo.INT && nodoDer.getTipo() == Tipo.CHAR
                            || nodoIzq.getTipo() == Tipo.CHAR && nodoDer.getTipo() == Tipo.CHAR) {
                        String temp = Generador.generarTemporal();
                        codigo = nodoIzq.getCodigo3D();
                        codigo += nodoDer.getCodigo3D();
                        codigo +=  "\n" +  Generador.generarCuadruplo("^", nodoIzq.getResultado(), nodoDer.getResultado(), temp);
                        Nodo resultado = new Nodo();
                        resultado.setTipo(Tipo.INT);
                        resultado.setCodigo3D(codigo);
                        resultado.setResultado(temp);
                        return resultado;
                    } else {
                        MessageError mensajeError = new MessageError("Semantico", l, c, "No se pueden obtener la potencia de : " + nodoIzq.getTipo() + " con: " + nodoDer.getTipo());
                        ambito.addSalida(mensajeError);
                        return mensajeError;
                    }
                //</editor-fold>
                
                    
                //<editor-fold defaultstate="collapsed" desc="RELACIONALES">
                case MAYOR:
                    return generarRelacional(">","mayor",nodoIzq,nodoDer,ambito);
                case MENOR:
                    return generarRelacional("<","menor",nodoIzq,nodoDer,ambito);
                case MAYORIGUAL:
                    return generarRelacional(">=","mayorigual",nodoIzq,nodoDer,ambito);
                case MENORIGUAL:
                    return generarRelacional("<=","menorigual",nodoIzq,nodoDer,ambito);
                case IGUAL:
                    return generarRelacionalEspecial("=","igual",nodoIzq,nodoDer,ambito);
                case DIFERENTE:
                    return generarRelacionalEspecial("<>","diferente",nodoIzq,nodoDer,ambito);
                //</editor-fold>
                    
            
                
                //<editor-fold defaultstate="collapsed" desc="AND">
                case AND:
                    if(nodoIzq.getTipo() == Tipo.BOOLEAN && nodoDer.getTipo() == Tipo.BOOLEAN){
                        
                        //------------------------------------------- CORTO CIRCUITO ---------------------------------------------
                        //---------------------------------- SI ES FALSE SE SALE DE UNA VEZ --------------------------------------
                        //---------------------------------- SI ES VERDADERO SE VA A LA SEGUNDA CONDICION ------------------------
                        Nodo nodo = new Nodo();
                        nodo.addEtiquetaF(nodoIzq.getEtiquetaF());
                        nodo.addEtiquetaF(nodoDer.getEtiquetaF());
                        nodo.setEtiquetaV(nodoDer.getEtiquetaV());
                        
                        
                        String code = "";
                        if(nodoIzq.getCodigo3D() != null ) code = nodoIzq.getCodigo3D();
                        code += "\n" + Generador.getAllEtiquetas(nodoIzq.getEtiquetaV());
                        code += nodoDer.getCodigo3D();
                        
                        nodo.setCodigo3D(code);
                        nodo.setTipo(Tipo.BOOLEAN);
                        
                        return nodo;
                    }
                    else {
                        MessageError mensajeError = new MessageError("Semantico", l, c, "No se puede aplicar AND en los tipos : " + nodoIzq.getTipo() + " con: " + nodoDer.getTipo());
                        ambito.addSalida(mensajeError);
                        return mensajeError;
                    }
                //</editor-fold>
                    
                    
                    
                //<editor-fold defaultstate="collapsed" desc="OR">
                case OR:
                    if(nodoIzq.getTipo() == Tipo.BOOLEAN && nodoDer.getTipo() == Tipo.BOOLEAN){
                        
                        //------------------------------------------- CORTO CIRCUITO ---------------------------------------------
                        //---------------------------------- SI ES FALSE SE VA A LA SEGUNDA CODNICON --------------------------------------
                        //---------------------------------- SI ES VERDADERO SE SALE ------------------------
                        Nodo nodo = new Nodo();
                        nodo.addEtiquetaF(nodoDer.getEtiquetaF());
                        nodo.setEtiquetaV(nodoIzq.getEtiquetaV());
                        nodo.setEtiquetaV(nodoDer.getEtiquetaV());
                        
                        
                        String code = "";
                        if(nodoIzq.getCodigo3D() != null ) code = nodoIzq.getCodigo3D();
                        code += "\n" + Generador.getAllEtiquetas(nodoIzq.getEtiquetaF());
                        code += nodoDer.getCodigo3D();
                        
                        nodo.setCodigo3D(code);
                        nodo.setTipo(Tipo.BOOLEAN);
                        
                        return nodo;
                    }
                    else {
                        MessageError mensajeError = new MessageError("Semantico", l, c, "No se puede aplicar OR en los tipos : " + nodoIzq.getTipo() + " con: " + nodoDer.getTipo());
                        ambito.addSalida(mensajeError);
                        return mensajeError;
                    }
                //</editor-fold>
                    
            
            
                //<editor-fold defaultstate="collapsed" desc="NAND">
                case NAND:
                    if(nodoIzq.getTipo() == Tipo.BOOLEAN && nodoDer.getTipo() == Tipo.BOOLEAN){
                        
                        //------------------------------------------- CORTO CIRCUITO ---------------------------------------------
                        //---------------------------------- SI ES FALSE SE SALE --------------------------------------
                        //---------------------------------- SI ES VERDADERO SE VA A LA SEGUNDA OPCION ------------------------
                        Nodo nodo = new Nodo();
                        nodo.addEtiquetaF(nodoDer.getEtiquetaV());
                        nodo.addEtiquetaV(nodoIzq.getEtiquetaF());
                        nodo.addEtiquetaV(nodoDer.getEtiquetaF());
                        
                        
                        String code = "";
                        if(nodoIzq.getCodigo3D() != null ) code = nodoIzq.getCodigo3D();
                        code += "\n" + Generador.getAllEtiquetas(nodoIzq.getEtiquetaV());
                        code += nodoDer.getCodigo3D();
                        
                        nodo.setCodigo3D(code);
                        nodo.setTipo(Tipo.BOOLEAN);
                        
                        return nodo;
                    }
                    else {
                        MessageError mensajeError = new MessageError("Semantico", l, c, "No se puede aplicar NAND en los tipos : " + nodoIzq.getTipo() + " con: " + nodoDer.getTipo());
                        ambito.addSalida(mensajeError);
                        return mensajeError;
                    }
                //</editor-fold>
            
            
                //<editor-fold defaultstate="collapsed" desc="NOR">
                case NOR:
                    if(nodoIzq.getTipo() == Tipo.BOOLEAN && nodoDer.getTipo() == Tipo.BOOLEAN){
                        
                        //------------------------------------------- CORTO CIRCUITO ---------------------------------------------
                        //---------------------------------- SI ES VERDADERO SE SALE (FALSO) --------------------------------------
                        //---------------------------------- SI ES FALSO SE VA A LA SEGUNDA OPCION ------------------------
                        Nodo nodo = new Nodo();
                        nodo.addEtiquetaF(nodoIzq.getEtiquetaV());
                        nodo.addEtiquetaF(nodoDer.getEtiquetaV());
                        nodo.addEtiquetaV(nodoDer.getEtiquetaF());
                        
                        
                        String code = "";
                        if(nodoIzq.getCodigo3D() != null ) code = nodoIzq.getCodigo3D();
                        code += "\n" + Generador.getAllEtiquetas(nodoIzq.getEtiquetaF());
                        code += nodoDer.getCodigo3D();
                        
                        nodo.setCodigo3D(code);
                        nodo.setTipo(Tipo.BOOLEAN);
                        
                        return nodo;
                    }
                    else {
                        MessageError mensajeError = new MessageError("Semantico", l, c, "No se puede aplicar NOR en los tipos : " + nodoIzq.getTipo() + " con: " + nodoDer.getTipo());
                        ambito.addSalida(mensajeError);
                        return mensajeError;
                    }
                //</editor-fold>
                    
                    
                    
                //<editor-fold defaultstate="collapsed" desc="NOT">
                case NOT:
                    if(nodoIzq.getTipo() == Tipo.BOOLEAN){
                        
                        //------------------------------------------- CORTO CIRCUITO ---------------------------------------------
                        //---------------------------------- VERDADERO = FALSO) --------------------------------------
                        //---------------------------------- FALSO = VERDADERO ------------------------
                        Nodo nodo = new Nodo();
                        nodo.addEtiquetaF(nodoIzq.getEtiquetaV());
                        nodo.addEtiquetaV(nodoIzq.getEtiquetaF());

                        nodo.setTipo(Tipo.BOOLEAN);
                        nodo.setCodigo3D("");
                        return nodo;
                    }
                    else {
                        MessageError mensajeError = new MessageError("Semantico", l, c, "No se puede aplicar NOT en el tipo : " + nodoIzq.getTipo());
                        ambito.addSalida(mensajeError);
                        return mensajeError;
                    }
                //</editor-fold>
            }
        } //------------------------------------------ VALORES PRIMARIOS -----------------------------------------------------------------------------
        else {
            Nodo nodo = new Nodo();
            nodo.setResultado(valor.toString());
            nodo.setTipo(tipo);
            nodo.setCodigo3D("");

            switch (tipo) {
                
                case INT:
                case DOUBLE:
                    return nodo;
                case CHAR:
                    nodo.setResultado(String.valueOf((int)valor.toString().charAt(l)));
                    return nodo;
                case NULL:
                    nodo.setResultado("0");
                    return nodo;
                case STRING:
                    return (valor.toString().length() < 254) ? guardarCadena3D(valor.toString().replaceAll("\"", ""), Tipo.WORD, ambito) : guardarCadena3D(valor.toString().replaceAll("\"", ""), tipo.STRING, ambito);
                    
                case BOOLEAN:
                    if(valor.toString().toLowerCase().equals("true")) nodo.setResultado("1");
                    else nodo.setResultado("0");
                    return nodo;
                case ID:
                    String identificador = valor.toString().toLowerCase();
                    Simbolo s = ambito.getSimbolo(identificador);
                    if(s != null){
                        if(s.getInicializada()){
                             nodo.setTipo(s.getTipo());
                             String tempPos = Generador.generarTemporal();
                             String tempVar = Generador.generarTemporal();
                             codigo = Generador.generarComentarioSimple("Accediendo a la variable: " + identificador);
                             codigo += "\n" + Generador.generarCuadruplo("+", "P", String.valueOf(s.getPosRelativa()), tempPos);
                             codigo += "\n" + Generador.guardarAcceso(tempVar, "Stack", tempPos);
                             codigo += "\n";
                             nodo.setResultado(tempVar);
                             nodo.setCodigo3D(codigo);
                             return nodo;
                        } else {
                            MessageError mensajeError = new MessageError("Sintactico", l, c, "la variable: " + identificador + " no ha sido inicializada");
                            ambito.addSalida(mensajeError);
                        }
                       
                    } else {
                        MessageError mensajeError = new MessageError("Sintactico", l, c, " no existe la variable: " + identificador);
                        ambito.addSalida(mensajeError);
                    }
                   
                    break;
            }
        }
        return error;
    }

    /**
     * METODO QUE TRADUCE LA CREACION DE UNA CADENA EN EL HEAP
     * @param cadena
     * @param tipo
     * @param ambito
     * @return 
     */
    private Nodo guardarCadena3D(String cadena, Tipo tipo, Ambito ambito) {
        Nodo nuevo = new Nodo();
        nuevo.setTipo(tipo);
        nuevo.setResultado(Generador.generarTemporal());
        String codigo = Generador.generarComentarioSimple("INICIO GUARDAR CADENA: " + cadena);
        codigo += "\n" + Generador.generarCuadruplo("=", "0", "", nuevo.getResultado());
        
        codigo += "\n" + Generador.generarCuadruplo("+", "H", "0", nuevo.getResultado());
        for (char c : cadena.toCharArray()) {
            codigo += "\n" + Generador.guardarEnPosicion("Heap", "H", String.valueOf((int) c));
            codigo += "\n" + Generador.generarCuadruplo("+", "H", "1", "H");
        }
        codigo += "\n" + Generador.guardarEnPosicion("Heap", "H", "0");
        codigo += "\n" + Generador.generarCuadruplo("+", "H", "1", "H");
        codigo += "\n" + Generador.generarComentarioSimple("FIN GUARDAR CADENA: " + cadena);
        nuevo.setCodigo3D(codigo);
        return nuevo;
    }

    /**
     * METODO QUE CONCATENA DOS EXPRESIONES Y LAS GUARDA EN EL HEAP
     * @param cadena
     * @param tipo
     * @param ambito 
     */
    private String concatenar(String cadena, Tipo tipo) {
        String codigo = "";
        switch (tipo) {
            case INT:
            case DOUBLE:
                codigo = Generador.guardarEnPosicion("Heap", "H", "-777.777"); // numero para separar el anterior fin de la cadena es decir el 0 que guardo para finalizar se adjunta el -777.77 que seria concatenar
                codigo += "\n" + Generador.generarCuadruplo("+", "H", "1", "H");
                codigo += "\n" + Generador.generarComentarioSimple("Se adjunta el numero: " + cadena);
                codigo += "\n" + Generador.guardarEnPosicion("Heap", "H", cadena);
                codigo += "\n" + Generador.generarCuadruplo("+", "H", "1", "H");
                
                break;
                
            case CHAR:
                codigo += "\n" + Generador.generarComentarioSimple("Se adjunta el char: " + cadena);
                int codigoAscii = (int) cadena.charAt(1);
                codigo += "\n" + Generador.guardarEnPosicion("Heap", "H", String.valueOf(codigoAscii));
                codigo += "\n" + Generador.generarCuadruplo("+", "H", "1", "H");
                break;
                
            case WORD:
            case STRING:
                codigo += "\n" + Generador.generarComentarioSimple("Se adjunta la cadena: " + cadena);
                String temporalAux = Generador.generarTemporal();
                String EtiquetaFinal = Generador.generarEtiqueta();
                String EtiquetaInicio = Generador.generarEtiqueta();
                codigo += "\n" + Generador.guardarEtiqueta(EtiquetaInicio);
                codigo += "\n" + Generador.guardarAcceso(temporalAux, "Heap", cadena);
                codigo += "\n" + Generador.generarComentarioSimple("Si no es el fin de la cadena guardar el valor");
                codigo += "\n" + Generador.guardarCondicional(EtiquetaFinal,temporalAux, "0", "=");
                codigo += "\n" + Generador.guardarEnPosicion("Heap", "H", temporalAux);
                codigo += "\n" + Generador.generarCuadruplo("+", "H", "1", "H");
                codigo += "\n" + Generador.generarComentarioSimple("Aumentar el contador que lleva la posicion del Heap");
                codigo += "\n" + Generador.generarCuadruplo("+", cadena, "1", cadena);
                codigo += "\n" + Generador.saltoIncondicional(EtiquetaInicio);
                codigo += "\n" + Generador.guardarEtiqueta(EtiquetaFinal);
                break;
        }
        return codigo;
    }


    
    /**
     * METODO QUE SE ENCARGA DE GENERAR EL 3D DE >,<,>=,<=
     * @param operacion
     * @param texto
     * @param izq
     * @param der
     * @param ambito
     * @return 
     */
    private Object generarRelacional(String operacion,String texto, Nodo izq, Nodo der, Ambito ambito){
        Nodo nodo = new Nodo();
        nodo.setTipo(Tipo.BOOLEAN);
        nodo.addEtiquetaV(Generador.generarEtiqueta());
        nodo.addEtiquetaF(Generador.generarEtiqueta());
        
        if (izq.getTipo() == Tipo.INT && der.getTipo() == Tipo.DOUBLE
                || izq.getTipo() == Tipo.DOUBLE && der.getTipo() == Tipo.INT
                || izq.getTipo() == Tipo.DOUBLE && der.getTipo() == Tipo.DOUBLE
                || izq.getTipo() == Tipo.INT && der.getTipo() == Tipo.INT
                || izq.getTipo() == Tipo.DOUBLE && der.getTipo() == Tipo.CHAR
                || izq.getTipo() == Tipo.CHAR && der.getTipo() == Tipo.DOUBLE
                || izq.getTipo() == Tipo.INT && der.getTipo() == Tipo.CHAR
                || izq.getTipo() == Tipo.CHAR && der.getTipo() == Tipo.INT
                || izq.getTipo() == Tipo.CHAR && der.getTipo() == Tipo.CHAR) {
            String codigo = izq.getCodigo3D();
            codigo += "\n" + der.getCodigo3D();
            codigo += "\n" + guardarValorBoolean(nodo,izq,der,operacion);
            nodo.setCodigo3D(codigo);
            return nodo;
        }
        else{
            MessageError mensaje = new MessageError("Semantico",l,c,"No se puede conocer el: " + operacion + " de los tipo: " + izq.getTipo() + " con: " + der.getTipo());
            ambito.addSalida(mensaje);
            return mensaje;
            
        }        
    }
    
    /**
     * METODO QUE SE ENCARGA DE GENERAR EL 3D DE = <>
     * @param operacion
     * @param texto
     * @param izq
     * @param der
     * @param ambito
     * @return 
     */
    private Object generarRelacionalEspecial(String operacion,String texto, Nodo izq, Nodo der, Ambito ambito){
        Nodo nodo = new Nodo();
        nodo.setTipo(Tipo.BOOLEAN);
        nodo.addEtiquetaV(Generador.generarEtiqueta());
        nodo.addEtiquetaF(Generador.generarEtiqueta());
        //---------------------------------------------- VALORES NUMERICOS -----------------------------------------------------------------
        if (izq.getTipo() == Tipo.INT && der.getTipo() == Tipo.DOUBLE
                || izq.getTipo() == Tipo.DOUBLE && der.getTipo() == Tipo.INT
                || izq.getTipo() == Tipo.DOUBLE && der.getTipo() == Tipo.DOUBLE
                || izq.getTipo() == Tipo.INT && der.getTipo() == Tipo.INT
                || izq.getTipo() == Tipo.DOUBLE && der.getTipo() == Tipo.CHAR
                || izq.getTipo() == Tipo.CHAR && der.getTipo() == Tipo.DOUBLE
                || izq.getTipo() == Tipo.INT && der.getTipo() == Tipo.CHAR
                || izq.getTipo() == Tipo.CHAR && der.getTipo() == Tipo.INT
                || izq.getTipo() == Tipo.CHAR && der.getTipo() == Tipo.CHAR
                || izq.getTipo() == Tipo.BOOLEAN && der.getTipo() == Tipo.BOOLEAN) {
            
            String codigo = izq.getCodigo3D();
            codigo += "\n" + der.getCodigo3D();
            codigo += "\n" + guardarValorBoolean(nodo,izq,der,operacion);
            nodo.setCodigo3D(codigo);
            return nodo;
        }
        //---------------------------------------------------- CADENAS -----------------------------------------------------------------------
        else if(
                izq.getTipo() == Tipo.STRING && der.getTipo() == Tipo.STRING
                || izq.getTipo() == Tipo.WORD && der.getTipo() == Tipo.STRING
                || izq.getTipo() == Tipo.WORD && der.getTipo() == Tipo.WORD){
            String codigo = izq.getCodigo3D();
            codigo += "\n" + der.getCodigo3D();
            codigo += "\n" + compararCadenas(nodo,izq,der,operacion);
            nodo.setCodigo3D(codigo);
            return nodo;
        }
        else{
            MessageError mensaje = new MessageError("Semantico",l,c,"No se puede conocer el: " + operacion + " de los tipo: " + izq.getTipo() + " con: " + der.getTipo());
            ambito.addSalida(mensaje);
            return mensaje;
            
        }        
    }
    
    /**
     * METODO QUE GUARDA EN LAS ETIQUETAS LOS POSIBLES VALORES DE UN VALOR NULL
     * @param nodo
     * @param izq
     * @param der
     * @param operacion
     * @return 
     */
    private String guardarValorBoolean(Nodo nodo,Nodo izq, Nodo der, String operacion){
        String codigo = "";
       
        codigo += "\n" + Generador.generarComentarioSimple("Verificar si las expresiones son : " + operacion);
        codigo += "\n" + Generador.guardarCondicional(nodo.getEtiquetaV().get(0), izq.getResultado(), der.getResultado(), operacion);
        codigo += "\n" + Generador.saltoIncondicional(nodo.getEtiquetaF().get(0));
        codigo += "\n" + Generador.generarComentarioSimple("FIN Verificar si las expresiones son : " + operacion);
        return codigo;
    }
    
    /**
     * METODO QUE SE ENCARGA DE COMPARA DOS CADENAS
     * @param nodo
     * @param izq
     * @param der
     * @param operacion
     * @return 
     */
    private String compararCadenas(Nodo nodo, Nodo izq, Nodo der, String operacion){
        String codigo = "";
        codigo += "\n" + Generador.generarComentarioSimple("Verificar si las expresiones son : " + operacion);
        String verdaderaTemporal = Generador.generarEtiqueta();
        String ciclo = Generador.generarEtiqueta();
        String temporalIzq = Generador.generarTemporal();
        String temporalDer = Generador.generarTemporal();
        String valorDer = Generador.generarTemporal();
        String valorIzq = Generador.generarTemporal();
        /*----------------------------------------------------- VERIFICAR SI UN CARACTER ES IGUAL AL OTRO -------------------------------------------------
        ---------------------------------------------------------- SI ES VERDADERO SALTAMOS  A VERIFICAR SI ES EL FIN DE LA CADENA ------------------------
        ---------------------------------------------------------- SI ES FALSO SALTAMOS A LA SALUDA DE UNA VEZ ------------------------------------------*/
        codigo += "\n" + Generador.generarComentarioSimple("Validando Caracter por Caracter : " + operacion);
        codigo += "\n" + Generador.generarCuadruplo("+", izq.getResultado(), "0", temporalIzq);
        codigo += "\n" + Generador.generarCuadruplo("+", der.getResultado(), "0", temporalDer);
        codigo += "\n" + Generador.guardarEtiqueta(ciclo);
        codigo += "\n" + Generador.guardarAcceso(valorIzq, "Heap", temporalIzq);
        codigo += "\n" + Generador.guardarAcceso(valorDer, "Heap", temporalDer);
        codigo += "\n" + Generador.generarComentarioSimple("Si son iguales validamos si estamos al final. si no son iguales saltamos a nuestra falsa : " + operacion);
        codigo += "\n" + Generador.guardarCondicional(verdaderaTemporal, valorIzq, valorDer, operacion);
        codigo += "\n" + Generador.saltoIncondicional(nodo.getEtiquetaF().get(0));
        
        //------------------------------------------------------- VERIFICAR SI ES EL FIN DE LA CADENA ----------------------------------------------------
        codigo += "\n" + Generador.generarComentarioSimple("Verificar si estamos al final de la cadena : " + operacion);
        codigo += "\n" + Generador.guardarEtiqueta(verdaderaTemporal);
        codigo += "\n" + Generador.guardarCondicional(nodo.getEtiquetaV().get(0),valorIzq , "0", operacion);
        codigo += "\n" + Generador.generarCuadruplo("+", temporalIzq, "1", temporalIzq);
        codigo += "\n" + Generador.generarCuadruplo("+", temporalDer, "1", temporalDer);
        codigo += "\n" + Generador.saltoIncondicional(ciclo);
        
        
        
        codigo += "\n" + Generador.generarComentarioSimple("FIN Verificar si las expresiones son : " + operacion);
        return codigo;
    }
}


