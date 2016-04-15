package AST;

import Errors.*;
import java.io.IOException;
import java.io.BufferedWriter;

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

	public void generateCode(BufferedWriter w, String tabs) throws IOException {
		sentsimp.generateCode(w, tabs);
		sentlist.generateCode(w, tabs);
	}
}