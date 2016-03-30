package AST;

import Errors.*;
import Compiler.*;

public class LVar1 implements LVar {
	public final String ident;
	private int ah1;

	public LVar1(String ident) {
		this.ident = ident;
	}

	public void computeAH1(int tipo) throws CompilerExc {
		ah1 = tipo;
		SymbolTable.newVariableEntry(ident, ah1);
	}

	public int getAH1() {
		return ah1;
	}
}