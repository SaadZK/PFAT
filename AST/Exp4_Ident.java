package AST;

import Errors.*;
import Compiler.SymbolTable;

public class Exp4_Ident implements Exp {
	public final String ident;

	public Exp4_Ident(String ident) {
		this.ident = ident;
	}

	public int computeType() throws CompilerExc {
		return SymbolTable.getVariableType(ident);
	}
}