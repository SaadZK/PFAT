package AST;

import Errors.*;
import Compiler.SymbolTable;
import java.io.IOException;

public class Exp10_Opuesto implements Exp {
	public final Exp exp;

	public Exp10_Opuesto(Exp exp) {
		this.exp = exp;
	}

	public int computeType() throws CompilerExc {
		if (exp.computeType() == SymbolTable.INT) {
			return SymbolTable.INT;
		}
		
		throw new IncorrectTypesExc("Incorrect type in opposite operation.");
	}
    
    public String generateCode() {
        return "-(" + exp.generateCode() + ")";
    }

}