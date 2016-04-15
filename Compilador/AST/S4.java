package AST;

import Errors.*;
import Compiler.SymbolTable;
import java.io.IOException;
import java.io.BufferedWriter;

public class S4 implements S {
	public final String ident;
	public final LVar lvar;
	public final VDef vdef;
	public final Body body;

	public S4(String ident, LVar lvar, VDef vdef, Body body) {
		this.ident = ident;
		this.lvar = lvar;
		this.vdef = vdef;
		this.body = body;
	}

	public void computeAH1() throws CompilerExc {
		lvar.computeAH1(SymbolTable.STRING);
		vdef.computeAH1();
		body.computeAH1();
	}

	public void generateCode(BufferedWriter w) throws IOException {
		String arguments = lvar.generateArguments();
		w.write("	public static void " + ident + "(" + lvar.generateArguments() + ") {");
		w.newLine(); w.newLine();
		vdef.generateCode(w, "		");
		w.newLine();
		body.generateCode(w, "		");
		w.newLine();
		w.write("	}");
		// MAIN
		w.newLine();
		w.newLine();
        w.write("	public static void main(String [] args) {");
        w.newLine();
		w.newLine();
        w.write("		String argumentos [] = new String [" + arguments.split(", ").length + "];");
		w.newLine();
		w.newLine();
		w.write("		for (int i = 0; i < argumentos.length; i++)");
		w.newLine();
		w.write("			argumentos[i] = (i >= args.length) ? \"\" : args[i];");
		w.newLine();
		w.newLine();
        w.write("		" + ident + "(" + lvar.generateMain(0) + ");");
        w.newLine();
        w.write("	}");
        // END MAIN
	}
}