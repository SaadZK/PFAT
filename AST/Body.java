package AST;

import Errors.*;
import java.io.BufferedWriter;
import java.io.IOException;

public class Body {
	public final Sent sent;

	public Body(Sent sent) {
		this.sent = sent;
	}

	public void computeAH1() throws CompilerExc {
		sent.computeAH1();
	}

	public void generateCode(BufferedWriter w, String tabs) throws IOException {
		sent.generateCode(w, tabs);
	}
}