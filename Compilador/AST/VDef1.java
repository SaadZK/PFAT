package AST;

import Errors.*;
import java.io.BufferedWriter;
import java.io.IOException;

public class VDef1 implements VDef {
	public final Decl decl;

	public VDef1(Decl decl) {
		this.decl = decl;
	}

	public void computeAH1() throws CompilerExc {
		decl.computeAH1();
	}

	public void generateCode(BufferedWriter w, String tabs) throws IOException {
		decl.generateCode(w, tabs);
	}
}