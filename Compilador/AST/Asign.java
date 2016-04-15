package AST;

import Errors.*;
import Compiler.SymbolTable;
import java.io.BufferedWriter;
import java.io.IOException;

public class Asign {
	public final String ident;
	public final Exp exp;

	public Asign(String ident, Exp exp) {
		this.ident = ident;
		this.exp = exp;
	}

	public void computeAH1() throws CompilerExc {
		if (!(SymbolTable.getVariableType(ident) == exp.computeType())) {
			throw new IncorrectTypesExc("Incorrect type in asign.");
		}
	}

	public void generateCode(BufferedWriter w, String tabs) throws IOException {
		w.write(tabs + ident + " = " + exp.generateCode() + ";");
	}
}