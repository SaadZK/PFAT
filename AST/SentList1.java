package AST;

import Errors.*;

public class SentList1 implements SentList {
	public final SentSimp sentsimp;

	public SentList1(SentSimp sentsimp) {
		this.sentsimp = sentsimp;
	}

	public void computeAH1() throws CompilerExc {
		sentsimp.computeAH1();
	}
}