package AST;

public class Exp13_Or implements Exp {
	public final Exp exp1;
	public final Exp exp2;

	public Exp13_Or(Exp exp1, Exp exp2) {
		this.exp1 = exp1;
		this.exp2 = exp2;
	}
}