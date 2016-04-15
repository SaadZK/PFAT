package AST;

import Errors.*;
import Compiler.SymbolTable;
import java.io.IOException;

public class Exp2_String implements Exp {
	public final String valor;

	public Exp2_String(String valor) {
		this.valor = valor;
	}

	public int computeType() throws CompilerExc {
		return SymbolTable.STRING;
	}

	public String generateCode() {
		return valor;
	}
}