package AST;

import Errors.*;

public class Body {
	public final Sent sent;

	public Body(Sent sent) {
		this.sent = sent;
	}

	public void computeAH1() throws CompilerExc {
		sent.computeAH1();
	}
}