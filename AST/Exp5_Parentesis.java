package AST;

import Errors.*;
import java.io.IOException;

public class Exp5_Parentesis implements Exp {
	public final Exp exp;

	public Exp5_Parentesis(Exp exp) {
		this.exp = exp;
	}

	public int computeType() throws CompilerExc {
		return exp.computeType();
	}

	public String generateCode() {
		return "(" + exp.generateCode() + ")";
	}
}