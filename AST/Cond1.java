package AST;

import Errors.*;
import Compiler.*;

public class Cond1 implements Cond {
	public final Exp exp;
	public final Sent sent;

	public Cond1(Exp exp, Sent sent) {
		this.exp = exp;
		this.sent = sent;
	}

	public void computeAH1() throws CompilerExc {
		if (!(exp.computeType() == SymbolTable.BOOL)) {
			throw new IncorrectConditionExc("Incorrect condition expresion.");
		} 
		sent.computeAH1();
	}
}