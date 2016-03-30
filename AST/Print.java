package AST;

import Errors.*;
import Compiler.*;

public class Print {
	public final Exp exp;

	public Print(Exp exp) {
		this.exp = exp;
	}

	public void computeAH1() throws CompilerExc {
		if (!(exp.computeType() == SymbolTable.STRING)) {
			throw new IncorrectTypesExc("String argument missed for print.");
		}
	}
}