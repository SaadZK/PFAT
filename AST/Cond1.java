package AST;

public class Cond1 implements Cond {
	public final Exp exp;
	public final Sent sent;

	public Cond1(Exp exp, Sent sent) {
		this.exp = exp;
		this.sent = sent;
	}
}