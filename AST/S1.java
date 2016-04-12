package AST;

import Errors.*;
import java.io.IOException;
import Compiler.SymbolTable;
import java.io.BufferedWriter;

public class S1 implements S {
	public final String ident;
	public final LVar lvar;
	public final Body body;

	public S1(String ident, LVar lvar, Body body) {
		this.ident = ident;
		this.lvar = lvar;
		this.body = body;
	}

	public void computeAH1() throws CompilerExc {
		lvar.computeAH1(SymbolTable.STRING);
		body.computeAH1();
	}

	public void generateCode(BufferedWriter w) throws IOException {
		String arguments = lvar.generateArguments();
		w.write("	public static void " + ident + "(" + arguments + ") {");
		w.newLine(); w.newLine();
		body.generateCode(w, "		");
		w.newLine();
		w.write("	}");
		// MAIN
		w.newLine(); w.newLine();
        w.write("	public static void main(String [] args) {");
		w.newLine(); w.newLine();
		w.write("		String argumentos [] = new String [" + arguments.split(", ").length + "];");
		w.newLine(); w.newLine();
		w.write("		for (int i = 0; i < argumentos.length; i++)");
		w.newLine();
		w.write("			argumentos[i] = (i >= args.length) ? \"\" : args[i];");
		w.newLine(); w.newLine();
        w.write("		" + ident + "(" + lvar.generateMain(0) + ");");
        w.newLine();
        w.write("	}");
        // END MAIN
	}
}