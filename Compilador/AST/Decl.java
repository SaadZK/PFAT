package AST;

import Errors.*;
import Compiler.SymbolTable;
import java.io.BufferedWriter;
import java.io.IOException;


public class Decl {
	public final int tipo;
	public final LVar lvar;

	public Decl(int tipo, LVar lvar){
		this.tipo = tipo;
		this.lvar = lvar;
	}

	public void computeAH1() throws CompilerExc {
		lvar.computeAH1(tipo);
	}

	public void generateCode(BufferedWriter w, String tabs) throws IOException {
		w.write(tabs + SymbolTable.typeToString(tipo) + " " + lvar.generateCode());
	}
}