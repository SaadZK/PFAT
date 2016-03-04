public class Programa1 implements Programa {
	public final String ident;
	public final LVar lvar;
	public final Body body;

	public Programa1(String ident, Lvar lvar, Body body) {
		this.ident = ident;
		this.lvar = lvar;
		this.body = body;
	}
}