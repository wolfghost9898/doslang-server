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
public class TipoDato {
    
    public Tipo tipo;     
    /**
     * GET DE TIPO
     * @return Tipo
     */
    public Tipo getTipo() {
        return this.tipo;
    }

    /**
     * GUARDAR SU NUEVO TIPO
     * @param tipo 
     */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    
    
    
    
    
    
    
    public enum Tipo{
        INT,
        DOUBLE,
        CHAR,
        WORD,
        STRING,
        CHARVALOR,
        BOOLEAN,
        ID,
        NULL
    }
    
    
    public enum Operacion{
        SUMA,
        RESTA,
        MULTIPLICACION,
        DIVISION,
        MODULO,
        POTENCIA,
        MAYOR,
        MENOR,
        MAYORIGUAL,
        MENORIGUAL,
        IGUAL,
        DIFERENTE,
        AND,
        OR,
        NAND,
        NOR,
        NOT
    }
}
