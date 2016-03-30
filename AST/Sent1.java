package AST;

import Errors.*;

public class Sent1 implements Sent {
	public final SentSimp sentsimp;

	public Sent1(SentSimp sentsimp) {
		this.sentsimp = sentsimp;
	}

	public void computeAH1() throws CompilerExc {
		sentsimp.computeAH1();
	}
}