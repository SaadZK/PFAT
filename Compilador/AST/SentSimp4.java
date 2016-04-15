package AST;

import Errors.*;
import java.io.IOException;
import java.io.BufferedWriter;

public class SentSimp4 implements SentSimp {
	public final Print print;

	public SentSimp4(Print print) {
		this.print = print;
	}

	public void computeAH1() throws CompilerExc {
		print.computeAH1();
	}

	public void generateCode(BufferedWriter w, String tabs) throws IOException {
		print.generateCode(w, tabs);
		w.newLine();
	}
}