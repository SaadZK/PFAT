package AST;

public class S1 implements S {
	public final String ident;
	public final LVar lvar;
	public final Body body;

	public S1(String ident, LVar lvar, Body body) {
		this.ident = ident;
		this.lvar = lvar;
		this.body = body;
	}
}