
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package Pascal.Parser;

import java_cup.runtime.*;
import Pascal.Analisis.*;
import Pascal.Analisis.TipoDato.*;
import Pascal.Componentes.*;
import java.util.LinkedList;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class Sintactico extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public Sintactico() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public Sintactico(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Sintactico(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\032\000\002\002\004\000\002\002\003\000\002\003" +
    "\005\000\002\003\005\000\002\003\005\000\002\003\005" +
    "\000\002\003\005\000\002\003\005\000\002\003\005\000" +
    "\002\003\005\000\002\003\005\000\002\003\005\000\002" +
    "\003\005\000\002\003\005\000\002\003\005\000\002\003" +
    "\005\000\002\003\005\000\002\003\005\000\002\003\004" +
    "\000\002\003\005\000\002\003\003\000\002\003\003\000" +
    "\002\003\003\000\002\003\003\000\002\003\003\000\002" +
    "\003\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\057\000\022\015\006\016\005\017\013\021\015\022" +
    "\004\023\007\024\012\037\014\001\002\000\046\002\uffea" +
    "\005\uffea\006\uffea\007\uffea\010\uffea\011\uffea\012\uffea\020" +
    "\uffea\025\uffea\026\uffea\027\uffea\030\uffea\031\uffea\032\uffea" +
    "\033\uffea\034\uffea\035\uffea\036\uffea\001\002\000\046\002" +
    "\uffec\005\uffec\006\uffec\007\uffec\010\uffec\011\uffec\012\uffec" +
    "\020\uffec\025\uffec\026\uffec\027\uffec\030\uffec\031\uffec\032" +
    "\uffec\033\uffec\034\uffec\035\uffec\036\uffec\001\002\000\046" +
    "\002\uffed\005\uffed\006\uffed\007\uffed\010\uffed\011\uffed\012" +
    "\uffed\020\uffed\025\uffed\026\uffed\027\uffed\030\uffed\031\uffed" +
    "\032\uffed\033\uffed\034\uffed\035\uffed\036\uffed\001\002\000" +
    "\046\002\uffe9\005\uffe9\006\uffe9\007\uffe9\010\uffe9\011\uffe9" +
    "\012\uffe9\020\uffe9\025\uffe9\026\uffe9\027\uffe9\030\uffe9\031" +
    "\uffe9\032\uffe9\033\uffe9\034\uffe9\035\uffe9\036\uffe9\001\002" +
    "\000\004\002\061\001\002\000\044\002\000\005\027\006" +
    "\021\007\024\010\025\011\031\012\022\025\030\026\023" +
    "\027\026\030\020\031\032\032\035\033\017\034\036\035" +
    "\033\036\034\001\002\000\046\002\uffe8\005\uffe8\006\uffe8" +
    "\007\uffe8\010\uffe8\011\uffe8\012\uffe8\020\uffe8\025\uffe8\026" +
    "\uffe8\027\uffe8\030\uffe8\031\uffe8\032\uffe8\033\uffe8\034\uffe8" +
    "\035\uffe8\036\uffe8\001\002\000\022\015\006\016\005\017" +
    "\013\021\015\022\004\023\007\024\012\037\014\001\002" +
    "\000\022\015\006\016\005\017\013\021\015\022\004\023" +
    "\007\024\012\037\014\001\002\000\046\002\uffeb\005\uffeb" +
    "\006\uffeb\007\uffeb\010\uffeb\011\uffeb\012\uffeb\020\uffeb\025" +
    "\uffeb\026\uffeb\027\uffeb\030\uffeb\031\uffeb\032\uffeb\033\uffeb" +
    "\034\uffeb\035\uffeb\036\uffeb\001\002\000\046\002\uffef\005" +
    "\027\006\021\007\024\010\025\011\031\012\022\020\uffef" +
    "\025\030\026\023\027\026\030\020\031\032\032\035\033" +
    "\uffef\034\uffef\035\uffef\036\uffef\001\002\000\022\015\006" +
    "\016\005\017\013\021\015\022\004\023\007\024\012\037" +
    "\014\001\002\000\022\015\006\016\005\017\013\021\015" +
    "\022\004\023\007\024\012\037\014\001\002\000\022\015" +
    "\006\016\005\017\013\021\015\022\004\023\007\024\012" +
    "\037\014\001\002\000\022\015\006\016\005\017\013\021" +
    "\015\022\004\023\007\024\012\037\014\001\002\000\022" +
    "\015\006\016\005\017\013\021\015\022\004\023\007\024" +
    "\012\037\014\001\002\000\022\015\006\016\005\017\013" +
    "\021\015\022\004\023\007\024\012\037\014\001\002\000" +
    "\022\015\006\016\005\017\013\021\015\022\004\023\007" +
    "\024\012\037\014\001\002\000\022\015\006\016\005\017" +
    "\013\021\015\022\004\023\007\024\012\037\014\001\002" +
    "\000\022\015\006\016\005\017\013\021\015\022\004\023" +
    "\007\024\012\037\014\001\002\000\022\015\006\016\005" +
    "\017\013\021\015\022\004\023\007\024\012\037\014\001" +
    "\002\000\022\015\006\016\005\017\013\021\015\022\004" +
    "\023\007\024\012\037\014\001\002\000\022\015\006\016" +
    "\005\017\013\021\015\022\004\023\007\024\012\037\014" +
    "\001\002\000\022\015\006\016\005\017\013\021\015\022" +
    "\004\023\007\024\012\037\014\001\002\000\022\015\006" +
    "\016\005\017\013\021\015\022\004\023\007\024\012\037" +
    "\014\001\002\000\022\015\006\016\005\017\013\021\015" +
    "\022\004\023\007\024\012\037\014\001\002\000\022\015" +
    "\006\016\005\017\013\021\015\022\004\023\007\024\012" +
    "\037\014\001\002\000\046\002\ufff2\005\027\006\021\007" +
    "\024\010\025\011\031\012\022\020\ufff2\025\030\026\023" +
    "\027\026\030\020\031\032\032\035\033\017\034\ufff2\035" +
    "\033\036\034\001\002\000\046\002\ufff4\005\027\006\021" +
    "\007\024\010\025\011\031\012\022\020\ufff4\025\ufff4\026" +
    "\ufff4\027\ufff4\030\ufff4\031\ufff4\032\ufff4\033\ufff4\034\ufff4" +
    "\035\ufff4\036\ufff4\001\002\000\046\002\ufff0\005\027\006" +
    "\021\007\024\010\025\011\031\012\022\020\ufff0\025\030" +
    "\026\023\027\026\030\020\031\032\032\035\033\017\034" +
    "\ufff0\035\ufff0\036\ufff0\001\002\000\046\002\ufff1\005\027" +
    "\006\021\007\024\010\025\011\031\012\022\020\ufff1\025" +
    "\030\026\023\027\026\030\020\031\032\032\035\033\017" +
    "\034\ufff1\035\ufff1\036\ufff1\001\002\000\046\002\ufff5\005" +
    "\027\006\021\007\024\010\025\011\031\012\022\020\ufff5" +
    "\025\ufff5\026\ufff5\027\ufff5\030\ufff5\031\ufff5\032\ufff5\033" +
    "\ufff5\034\ufff5\035\ufff5\036\ufff5\001\002\000\046\002\ufffb" +
    "\005\ufffb\006\ufffb\007\ufffb\010\ufffb\011\ufffb\012\022\020" +
    "\ufffb\025\ufffb\026\ufffb\027\ufffb\030\ufffb\031\ufffb\032\ufffb" +
    "\033\ufffb\034\ufffb\035\ufffb\036\ufffb\001\002\000\046\002" +
    "\ufff9\005\027\006\021\007\024\010\025\011\031\012\022" +
    "\020\ufff9\025\ufff9\026\ufff9\027\ufff9\030\ufff9\031\ufff9\032" +
    "\ufff9\033\ufff9\034\ufff9\035\ufff9\036\ufff9\001\002\000\046" +
    "\002\uffff\005\uffff\006\uffff\007\024\010\025\011\031\012" +
    "\022\020\uffff\025\uffff\026\uffff\027\uffff\030\uffff\031\uffff" +
    "\032\uffff\033\uffff\034\uffff\035\uffff\036\uffff\001\002\000" +
    "\046\002\ufff7\005\027\006\021\007\024\010\025\011\031" +
    "\012\022\020\ufff7\025\ufff7\026\ufff7\027\ufff7\030\ufff7\031" +
    "\ufff7\032\ufff7\033\ufff7\034\ufff7\035\ufff7\036\ufff7\001\002" +
    "\000\046\002\ufffc\005\ufffc\006\ufffc\007\ufffc\010\ufffc\011" +
    "\ufffc\012\022\020\ufffc\025\ufffc\026\ufffc\027\ufffc\030\ufffc" +
    "\031\ufffc\032\ufffc\033\ufffc\034\ufffc\035\ufffc\036\ufffc\001" +
    "\002\000\046\002\ufffd\005\ufffd\006\ufffd\007\ufffd\010\ufffd" +
    "\011\ufffd\012\022\020\ufffd\025\ufffd\026\ufffd\027\ufffd\030" +
    "\ufffd\031\ufffd\032\ufffd\033\ufffd\034\ufffd\035\ufffd\036\ufffd" +
    "\001\002\000\046\002\ufff8\005\027\006\021\007\024\010" +
    "\025\011\031\012\022\020\ufff8\025\ufff8\026\ufff8\027\ufff8" +
    "\030\ufff8\031\ufff8\032\ufff8\033\ufff8\034\ufff8\035\ufff8\036" +
    "\ufff8\001\002\000\046\002\ufffa\005\ufffa\006\ufffa\007\ufffa" +
    "\010\ufffa\011\ufffa\012\ufffa\020\ufffa\025\ufffa\026\ufffa\027" +
    "\ufffa\030\ufffa\031\ufffa\032\ufffa\033\ufffa\034\ufffa\035\ufffa" +
    "\036\ufffa\001\002\000\046\002\ufffe\005\ufffe\006\ufffe\007" +
    "\024\010\025\011\031\012\022\020\ufffe\025\ufffe\026\ufffe" +
    "\027\ufffe\030\ufffe\031\ufffe\032\ufffe\033\ufffe\034\ufffe\035" +
    "\ufffe\036\ufffe\001\002\000\046\002\ufff6\005\027\006\021" +
    "\007\024\010\025\011\031\012\022\020\ufff6\025\ufff6\026" +
    "\ufff6\027\ufff6\030\ufff6\031\ufff6\032\ufff6\033\ufff6\034\ufff6" +
    "\035\ufff6\036\ufff6\001\002\000\046\002\ufff3\005\027\006" +
    "\021\007\024\010\025\011\031\012\022\020\ufff3\025\030" +
    "\026\023\027\026\030\020\031\032\032\035\033\ufff3\034" +
    "\ufff3\035\ufff3\036\ufff3\001\002\000\044\005\027\006\021" +
    "\007\024\010\025\011\031\012\022\020\060\025\030\026" +
    "\023\027\026\030\020\031\032\032\035\033\017\034\036" +
    "\035\033\036\034\001\002\000\046\002\uffee\005\uffee\006" +
    "\uffee\007\uffee\010\uffee\011\uffee\012\uffee\020\uffee\025\uffee" +
    "\026\uffee\027\uffee\030\uffee\031\uffee\032\uffee\033\uffee\034" +
    "\uffee\035\uffee\036\uffee\001\002\000\004\002\001\001\002" +
    "" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\057\000\006\002\007\003\010\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\003\056\001\001\000\004\003\015\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\003\055\001\001\000" +
    "\004\003\054\001\001\000\004\003\053\001\001\000\004" +
    "\003\052\001\001\000\004\003\051\001\001\000\004\003" +
    "\050\001\001\000\004\003\047\001\001\000\004\003\046" +
    "\001\001\000\004\003\045\001\001\000\004\003\044\001" +
    "\001\000\004\003\043\001\001\000\004\003\042\001\001" +
    "\000\004\003\041\001\001\000\004\003\040\001\001\000" +
    "\004\003\037\001\001\000\004\003\036\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Sintactico$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Sintactico$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Sintactico$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}




	public static LinkedList<Instruccion> lista;

	

	public  void setLista(LinkedList<Instruccion> listaG){
		lista = listaG;
	}

	public  LinkedList<Instruccion> getLista(){
		return lista;
	}
	
	public static int cont=0;
	public void syntax_error(Symbol s){
        System.err.println("Error Sintáctico en la Línea " + (s.left) +" Columna "+s.right+ ". No se esperaba este componente: " +s.value+".");
	}

	 public void unrecovered_syntax_error(Symbol s) throws java.lang.Exception{
        System.err.println("Error síntactico irrecuperable en la Línea " + (s.left)+ " Columna "+s.right+". Componente " + s.value + " no reconocido.");
    }


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$Sintactico$actions {
  private final Sintactico parser;

  /** Constructor */
  CUP$Sintactico$actions(Sintactico parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$Sintactico$do_action_part00000000(
    int                        CUP$Sintactico$act_num,
    java_cup.runtime.lr_parser CUP$Sintactico$parser,
    java.util.Stack            CUP$Sintactico$stack,
    int                        CUP$Sintactico$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Sintactico$result;

      /* select the action based on the action number */
      switch (CUP$Sintactico$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= inicio EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		RESULT = start_val;
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Sintactico$parser.done_parsing();
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // inicio ::= expresion 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Expresion a = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 
																				LinkedList<Instruccion> ins = new LinkedList<Instruccion>();
																				ins.addLast(a);	
																				parser.lista = ins; 
																			
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("inicio",0, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // expresion ::= expresion MAS expresion 
            {
              Expresion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).right;
		Expresion a = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Expresion b = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT = new Expresion(a,b,Operacion.SUMA,aleft,aright);  
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expresion",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // expresion ::= expresion MENOS expresion 
            {
              Expresion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).right;
		Expresion a = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Expresion b = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT = new Expresion(a,b,Operacion.RESTA,aleft,aright); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expresion",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // expresion ::= expresion POR expresion 
            {
              Expresion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).right;
		Expresion a = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Expresion b = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT = new Expresion(a,b,Operacion.MULTIPLICACION,aleft,aright); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expresion",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // expresion ::= expresion DIVIDIDO expresion 
            {
              Expresion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).right;
		Expresion a = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Expresion b = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT = new Expresion(a,b,Operacion.DIVISION,aleft,aright); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expresion",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // expresion ::= expresion MODULO expresion 
            {
              Expresion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).right;
		Expresion a = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Expresion b = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT = new Expresion(a,b,Operacion.MODULO,aleft,aright); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expresion",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // expresion ::= expresion POTENCIA expresion 
            {
              Expresion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).right;
		Expresion a = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Expresion b = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT = new Expresion(a,b,Operacion.POTENCIA,aleft,aright); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expresion",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // expresion ::= expresion MAYOR expresion 
            {
              Expresion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).right;
		Expresion a = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Expresion b = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT = new Expresion(a,b,Operacion.MAYOR,aleft,aright); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expresion",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // expresion ::= expresion MENOR expresion 
            {
              Expresion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).right;
		Expresion a = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Expresion b = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT = new Expresion(a,b,Operacion.MENOR,aleft,aright); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expresion",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // expresion ::= expresion MAYORIGUAL expresion 
            {
              Expresion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).right;
		Expresion a = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Expresion b = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT = new Expresion(a,b,Operacion.MAYORIGUAL,aleft,aright); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expresion",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // expresion ::= expresion MENORIGUAL expresion 
            {
              Expresion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).right;
		Expresion a = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Expresion b = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT = new Expresion(a,b,Operacion.MENORIGUAL,aleft,aright); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expresion",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // expresion ::= expresion IGUAL expresion 
            {
              Expresion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).right;
		Expresion a = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Expresion b = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT = new Expresion(a,b,Operacion.IGUAL,aleft,aright); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expresion",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // expresion ::= expresion DIFERENTE expresion 
            {
              Expresion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).right;
		Expresion a = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Expresion b = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT = new Expresion(a,b,Operacion.DIFERENTE,aleft,aright); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expresion",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // expresion ::= expresion AND expresion 
            {
              Expresion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).right;
		Expresion a = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Expresion b = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT = new Expresion(a,b,Operacion.AND,aleft,aright); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expresion",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // expresion ::= expresion OR expresion 
            {
              Expresion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).right;
		Expresion a = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Expresion b = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT = new Expresion(a,b,Operacion.OR,aleft,aright); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expresion",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // expresion ::= expresion NAND expresion 
            {
              Expresion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).right;
		Expresion a = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Expresion b = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT = new Expresion(a,b,Operacion.NAND,aleft,aright); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expresion",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // expresion ::= expresion NOR expresion 
            {
              Expresion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).right;
		Expresion a = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Expresion b = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT = new Expresion(a,b,Operacion.NOR,aleft,aright); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expresion",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // expresion ::= NOT expresion 
            {
              Expresion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Expresion a = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT = new Expresion(a,null,Operacion.NOT,aleft,aright); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expresion",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // expresion ::= PARIZQ expresion PARDER 
            {
              Expresion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		Expresion a = (Expresion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		 RESULT = a; 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expresion",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // expresion ::= ENTERO 
            {
              Expresion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT = new Expresion(a,Tipo.INT,aleft,aright); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expresion",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // expresion ::= DECIMAL 
            {
              Expresion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT = new Expresion(a,Tipo.DOUBLE,aleft,aright); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expresion",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // expresion ::= CHAR 
            {
              Expresion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT = new Expresion(a,Tipo.CHAR,aleft,aright); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expresion",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // expresion ::= CADENA 
            {
              Expresion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT = new Expresion(a,Tipo.STRING,aleft,aright); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expresion",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // expresion ::= TRUE 
            {
              Expresion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT = new Expresion(a,Tipo.BOOLEAN,aleft,aright); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expresion",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // expresion ::= FALSE 
            {
              Expresion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 RESULT = new Expresion(a,Tipo.BOOLEAN,aleft,aright); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("expresion",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$Sintactico$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$Sintactico$do_action(
    int                        CUP$Sintactico$act_num,
    java_cup.runtime.lr_parser CUP$Sintactico$parser,
    java.util.Stack            CUP$Sintactico$stack,
    int                        CUP$Sintactico$top)
    throws java.lang.Exception
    {
              return CUP$Sintactico$do_action_part00000000(
                               CUP$Sintactico$act_num,
                               CUP$Sintactico$parser,
                               CUP$Sintactico$stack,
                               CUP$Sintactico$top);
    }
}

}
