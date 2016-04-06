package AST;

import Errors.*;
import java.io.IOException;
import java.io.BufferedWriter;

public class Sent1 implements Sent {
	public final SentSimp sentsimp;

	public Sent1(SentSimp sentsimp) {
		this.sentsimp = sentsimp;
	}

	public void computeAH1() throws CompilerExc {
		sentsimp.computeAH1();
	}

	public void generateCode(BufferedWriter w, String tabs) throws IOException {
		sentsimp.generateCode(w, tabs);
	}
}