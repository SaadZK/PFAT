package AST;

import Errors.*;
import java.io.IOException;
import java.io.BufferedWriter;

public class S2 implements S {
	public final String ident;
	public final Body body;

	public S2(String ident, Body body) {
		this.ident = ident;
		this.body = body;
	}

	public void computeAH1() throws CompilerExc {
		body.computeAH1();
	}

	public void generateCode(BufferedWriter w) throws IOException {
		w.write("	public static void " + ident + "() {");
		w.newLine(); w.newLine();
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