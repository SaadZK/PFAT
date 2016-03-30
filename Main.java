import Parser.*;
import Lexer.*;
import java.io.*;
import AST.S;

public class Main
{
  public static void main(String args[]) throws Exception{
    java.io.BufferedReader in;
    Yylex sc;
    parser p;
    java_cup.runtime.Symbol sroot;
    boolean error=false;

    //El primer parametro es el nombre del fichero con el programa
    if (args.length < 1) {
      System.out.println(
        "Uso: java Main <nombre_fichero>");
      error=true;
    }

    //Analisis lexico y sintactico

    if (!error) {  
    	try {
    	    in = new java.io.BufferedReader(new java.io.FileReader(args[0]));
    	    sc = new Yylex(in);
    	    p = new parser(sc);
    	    sroot = p.parse();
    	    System.out.println("Analisis lexico y sintactico correctos");

          /* Codigo para el analisis semantico, empieza a computar desde el nodo raiz */
          S root = (S) sroot.value;
          root.computeAH1();
          System.out.println("Analisis semantico correcto");
          /* Fin codigo analisis semantico */
          
    	} catch(IOException e) {
    	    System.out.println("Error abriendo fichero: " + args[0]);
    	    error= true;
    	}
    }
  }
}
