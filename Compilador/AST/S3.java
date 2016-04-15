package AST;

import Errors.*;
import java.io.IOException;
import java.io.BufferedWriter;

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

	public void generateCode(BufferedWriter w) throws IOException {
		w.write("	public static void " + ident + "() {");
		w.newLine(); w.newLine();
		vdef.generateCode(w, "		");
		w.newLine();
		body.generateCode(w, "		");
		w.newLine();
		w.write("	}");
		// MAIN
		w.newLine();
		w.newLine();
        w.write("	public static void main(String [] args) {");
        w.newLine();
        w.write("		" + ident + "();");
        w.newLine();
        w.write("	}");
        // END MAIN
	}
}