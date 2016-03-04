public class Programa4 implements Programa {
	public final String ident;
	public final LVar lvar;
	public final VDef vdef;
	public final Body body;

	public Programa4(String ident, LVar lvar, VDef vdef, Body body) {
		this.ident = ident;
		this.lvar = lvar;
		this.vdef = vdef;
		this.body = body;
	}
}