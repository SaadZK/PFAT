package AST;

import Errors.*;
import java.io.IOException;
import java.io.BufferedWriter;

public class SentSimp2 implements SentSimp {
	public final Cond cond;

	public SentSimp2(Cond cond) {
		this.cond = cond;
	}

	public void computeAH1() throws CompilerExc {
		cond.computeAH1();
	}

	public void generateCode(BufferedWriter w, String tabs) throws IOException {
		cond.generateCode(w, tabs);
		w.newLine();
	}
}