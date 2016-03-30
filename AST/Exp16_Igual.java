package AST;

import Errors.*;
import Compiler.*;

public class Exp16_Igual implements Exp {
	public final Exp exp1;
	public final Exp exp2;

	public Exp16_Igual(Exp exp1, Exp exp2) {
		this.exp1 = exp1;
		this.exp2 = exp2;
	}

	public int computeType() throws CompilerExc {
		if (exp1.computeType() == exp2.computeType()) {
			return SymbolTable.BOOL;
		}
		
		throw new IncorrectTypesExc("Incorrect type in comparison operation.");
	}
}