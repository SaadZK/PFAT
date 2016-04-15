package AST;

import Errors.*;
import java.io.IOException;
import java.io.BufferedWriter;

public class Sent2 implements Sent {
	public final SentList sentlist;

	public Sent2(SentList sentlist) {
		this.sentlist = sentlist;
	}

	public void computeAH1() throws CompilerExc {
		sentlist.computeAH1();
	}

	public void generateCode(BufferedWriter w, String tabs) throws IOException {
		sentlist.generateCode(w, tabs);
	}
}