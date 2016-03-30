package AST;

import Errors.*;
import Compiler.*;

public class S4 implements S {
	public final String ident;
	public final LVar lvar;
	public final VDef vdef;
	public final Body body;

	public S4(String ident, LVar lvar, VDef vdef, Body body) {
		this.ident = ident;
		this.lvar = lvar;
		this.vdef = vdef;
		this.body = body;
	}

	public void computeAH1() throws CompilerExc {
		lvar.computeAH1(SymbolTable.STRING);
		vdef.computeAH1();
		body.computeAH1();
	}
}