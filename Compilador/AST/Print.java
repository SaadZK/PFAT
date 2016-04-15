package AST;

import Errors.*;
import Compiler.SymbolTable;
import java.io.BufferedWriter;
import java.io.IOException;

public class Print {
	public final Exp exp;

	public Print(Exp exp) {
		this.exp = exp;
	}

	public void computeAH1() throws CompilerExc {
		if (!(exp.computeType() == SymbolTable.STRING)) {
			throw new IncorrectTypesExc("String argument missed for print.");
		}
	}

	public void generateCode(BufferedWriter w, String tabs) throws IOException {
		w.write(tabs + "System.out.println(" + exp.generateCode() + ");");
	}
}