package AST;

import Errors.*;

public class SentSimp3 implements SentSimp {
	public final Repet repet;

	public SentSimp3(Repet repet) {
		this.repet = repet;
	}

	public void computeAH1() throws CompilerExc {
		repet.computeAH1();
	}
}