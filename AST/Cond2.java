package AST;

public class Cond2 implements Cond {
	public final Exp exp;
	public final Sent sent1;
	public final Sent sent2;

	public Cond2(Exp exp, Sent sent1, Sent sent2) {
		this.exp = exp;
		this.sent1 = sent1;
		this.sent2 = sent2;
	}
}