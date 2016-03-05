package AST;

public class Decl {
	public final int tipo;
	public final LVar lvar;

	public Decl(int tipo, LVar lvar){
		this.tipo = tipo;
		this.lvar = lvar;
	}
}