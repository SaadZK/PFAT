package AST;

public class S2 implements S {
	public final String ident;
	public final Body body;

	public S2(String ident, Body body) {
		this.ident = ident;
		this.body = body;
	}
}