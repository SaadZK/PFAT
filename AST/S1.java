package AST;

import Errors.*;
import Compiler.*;

public class S1 implements S {
	public final String ident;
	public final LVar lvar;
	public final Body body;

	public S1(String ident, LVar lvar, Body body) {
		this.ident = ident;
		this.lvar = lvar;
		this.body = body;
	}

	public void computeAH1() throws CompilerExc {
		lvar.computeAH1(SymbolTable.STRING);
		body.computeAH1();
	}
}