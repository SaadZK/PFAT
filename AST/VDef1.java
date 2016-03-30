package AST;

import Errors.*;

public class VDef1 implements VDef {
	public final Decl decl;

	public VDef1(Decl decl) {
		this.decl = decl;
	}

	public void computeAH1() throws CompilerExc {
		decl.computeAH1();
	}
}