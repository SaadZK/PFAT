import Parser.*;
import Lexer.*;
import java.io.*;
import AST.S;

public class Main {
    
  private static void codeGenerator(String className, S s){
    try {
        BufferedWriter w = new BufferedWriter(new FileWriter(className + ".java"));
        w.write("import GeneratedCodeLib.Logic;");
        w.newLine();
        w.write("import java.util.*;");
        w.newLine(); w.newLine();
        w.write("public class " + className + " {");
        w.newLine(); w.newLine();
        s.generateCode(w);
        w.newLine();
        w.write("}");
        w.newLine();
        w.close();
        System.out.println("Código generado con éxito en " + className + ".java");
      } catch(IOException e) {
        System.out.println("Error generando código de " + className + ".java");
      }
  }

  /* Generar codigo main del programa */

  public static void main(String args[]) throws Exception{
    java.io.BufferedReader in;
    Yylex sc;
    parser p;
    java_cup.runtime.Symbol sroot;
    boolean error=false;

    //El primer parametro es el nombre del fichero con el programa
    if (args.length < 1) {
      System.out.println(
        "Uso: java Main <nombre_fichero> <fichero_generado>");
      error=true;
    }

    //Analisis lexico y sintactico

    if (!error) {  
    	try {
    	    in = new java.io.BufferedReader(new java.io.FileReader(args[0]));
    	    sc = new Yylex(in);
    	    p = new parser(sc);
    	    sroot = p.parse();
    	    System.out.println("Análisis léxico y sintáctico correctos");

          /* Codigo para el analisis semantico, empieza a computar desde el nodo raiz */
          S root = (S) sroot.value;
          root.computeAH1();
          System.out.println("Análisis semántico correcto");
          /* Fin codigo analisis semantico */
          
          /* Codigo para generar codigo Java */
          codeGenerator(args[1], root);
          /* Fin codigo para generar codigo Java */
    	} catch(IOException e) {
    	    System.out.println("Error abriendo fichero: " + args[0]);
    	    error= true;
    	}
    }
  }
}
