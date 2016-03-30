package AST;

import Errors.*;

public class SentList2 implements SentList {
	public final SentSimp sentsimp;
	public final SentList sentlist;

	public SentList2(SentSimp sentsimp, SentList sentlist) {
		this.sentsimp = sentsimp;
		this.sentlist = sentlist;
	}

	public void computeAH1() throws CompilerExc {
		sentsimp.computeAH1();
		sentlist.computeAH1();
	}
}