package AST;

import Errors.*;
import java.io.IOException;
import java.io.BufferedWriter;

public class VDef2 implements VDef {
	public final Decl decl;
	public final VDef vdef;

	public VDef2(Decl decl, VDef vdef) {
		this.decl = decl;
		this.vdef = vdef;
	}

	public void computeAH1() throws CompilerExc {
		decl.computeAH1();
		vdef.computeAH1();
	}

	public void generateCode(BufferedWriter w, String tabs) throws IOException {
		decl.generateCode(w, tabs);
		w.newLine();
		vdef.generateCode(w, tabs);
	}
}