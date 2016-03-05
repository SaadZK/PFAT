package AST;

public class S3 implements S {
	public final String ident;
	public final VDef vdef;
	public final Body body;

	public S3(String ident, VDef vdef, Body body) {
		this.ident = ident;
		this.vdef = vdef;
		this.body = body;
	}
}