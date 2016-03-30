package AST;

import Errors.*;

public class Sent2 implements Sent {
	public final SentList sentlist;

	public Sent2(SentList sentlist) {
		this.sentlist = sentlist;
	}

	public void computeAH1() throws CompilerExc {
		sentlist.computeAH1();
	}
}