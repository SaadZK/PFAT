package AST;

public class Asign {
	public final String ident;
	public final Exp exp;

	public Asign(String ident, Exp exp) {
		this.ident = ident;
		this.exp = exp;
	}
}