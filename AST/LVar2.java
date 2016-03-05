package AST;

public class LVar2 implements LVar {
	public final String ident;
	public final LVar lvar;

	public LVar2(String ident, LVar lvar) {
		this.ident = ident;
		this.lvar = lvar;
	}
}