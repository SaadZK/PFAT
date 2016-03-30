package AST;

import Errors.*;
import Compiler.*;

public class Exp3_Boolean implements Exp {
	public final int valor; /* 0: true, 1: false, 2: unk */

	public Exp3_Boolean(int valor) {
		this.valor = valor;
	}

	public int computeType() throws CompilerExc {
		return SymbolTable.BOOL;
	}
}