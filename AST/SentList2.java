package AST;

public class SentList2 implements SentList {
	public final SentList sentlist;
	public final SentSimp sentsimp;

	public SentList2(SentList sentlist, SentSimp sentsimp) {
		this.sentlist = sentlist;
		this.sentsimp = sentsimp;
	}
}