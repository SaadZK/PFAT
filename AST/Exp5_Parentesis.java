package AST;

import Errors.*;

public class Exp5_Parentesis implements Exp {
	public final Exp exp;

	public Exp5_Parentesis(Exp exp) {
		this.exp = exp;
	}

	public int computeType() throws CompilerExc {
		return exp.computeType();
	}
}