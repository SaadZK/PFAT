package AST;

import Errors.*;

public class S3 implements S {
	public final String ident;
	public final VDef vdef;
	public final Body body;

	public S3(String ident, VDef vdef, Body body) {
		this.ident = ident;
		this.vdef = vdef;
		this.body = body;
	}

	public void computeAH1() throws CompilerExc {
		vdef.computeAH1();
		body.computeAH1();
	}
}