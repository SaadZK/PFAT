package AST;

import Errors.*;
import Compiler.*;

public class Exp11_Str2Int implements Exp {
	public final Exp exp;

	public Exp11_Str2Int(Exp exp) {
		this.exp = exp;
	}

	public int computeType() throws CompilerExc {
		if (exp.computeType() == SymbolTable.STRING) {
			return SymbolTable.INT;
		}
		
		throw new IncorrectTypesExc("Incorrect type in Str2Int operation.");
	}
}