package AST;

import Errors.*;
import Compiler.*;

public class LVar2 implements LVar {
	public final String ident;
	public final LVar lvar;
	private int ah1;

	public LVar2(String ident, LVar lvar) {
		this.ident = ident;
		this.lvar = lvar;
	}

	public void computeAH1(int tipo) throws CompilerExc {
		ah1 = tipo;
		lvar.computeAH1(tipo);
		SymbolTable.newVariableEntry(ident, ah1);
	}

	public int getAH1() {
		return ah1;
	}
}