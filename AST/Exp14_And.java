package AST;

import Errors.*;
import Compiler.*;

public class Exp14_And implements Exp {
	public final Exp exp1;
	public final Exp exp2;

	public Exp14_And(Exp exp1, Exp exp2) {
		this.exp1 = exp1;
		this.exp2 = exp2;
	}

	public int computeType() throws CompilerExc {
		if ((exp1.computeType() == SymbolTable.BOOL) && (exp2.computeType() == SymbolTable.BOOL)) {
			return SymbolTable.BOOL;
		}
		
		throw new IncorrectTypesExc("Incorrect type in and operation.");
	}
}