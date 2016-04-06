package AST;

import Errors.*;
import Compiler.SymbolTable;
import GeneratedCodeLib.Logic;

public class Exp3_Boolean implements Exp {
	public final int valor;

	public Exp3_Boolean(int valor) {
		this.valor = valor;
	}

	public int computeType() throws CompilerExc {
		return SymbolTable.BOOL;
	}

	public String generateCode() {
		return Logic.valueToString(valor);
	}
}