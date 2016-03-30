package AST;

import Errors.*;

public class VDef2 implements VDef {
	public final Decl decl;
	public final VDef vdef;

	public VDef2(Decl decl, VDef vdef) {
		this.decl = decl;
		this.vdef = vdef;
	}

	public void computeAH1() throws CompilerExc {
		decl.computeAH1();
	}
}