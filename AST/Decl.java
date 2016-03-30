package AST;

import Errors.*;

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
}