package AST;

import Errors.*;
import Compiler.SymbolTable;

public class Exp8_Multiplicacion implements Exp {
	public final Exp exp1;
	public final Exp exp2;

	public Exp8_Multiplicacion(Exp exp1, Exp exp2) {
		this.exp1 = exp1;
		this.exp2 = exp2;
	}

	public int computeType() throws CompilerExc {
		if ((exp1.computeType() == SymbolTable.INT) && (exp2.computeType() == SymbolTable.INT)) {
			return SymbolTable.INT;
		}
		
		throw new IncorrectTypesExc("Incorrect type in multiplication operation.");
	}
}