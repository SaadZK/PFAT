package AST;

import Errors.*;
import java.io.IOException;
import java.io.BufferedWriter;

public class SentSimp3 implements SentSimp {
	public final Repet repet;

	public SentSimp3(Repet repet) {
		this.repet = repet;
	}

	public void computeAH1() throws CompilerExc {
		repet.computeAH1();
	}

	public void generateCode(BufferedWriter w, String tabs) throws IOException {
		repet.generateCode(w, tabs);
		w.newLine();
	}
}