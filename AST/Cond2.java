package AST;

import Errors.*;
import Compiler.SymbolTable;

public class Cond2 implements Cond {
	public final Exp exp;
	public final Sent sent1;
	public final Sent sent2;

	public Cond2(Exp exp, Sent sent1, Sent sent2) {
		this.exp = exp;
		this.sent1 = sent1;
		this.sent2 = sent2;
	}

	public void computeAH1() throws CompilerExc {
		if (!(exp.computeType() == SymbolTable.BOOL)) {
			throw new IncorrectConditionExc("Incorrect condition expresion.");
		} 
		sent1.computeAH1();
		sent2.computeAH1();
	}
}