package AST;

import Errors.*;
import Compiler.SymbolTable;
import java.io.IOException;

public class Exp1_Entero implements Exp {
	public final int valor;

	public Exp1_Entero(int valor) {
		this.valor = valor;
	}

	public int computeType() throws CompilerExc {
		return SymbolTable.INT;
	}

	public String generateCode() {
		return Integer.toString(valor);
	}
}