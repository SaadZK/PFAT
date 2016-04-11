package AST;

import Errors.*;
import Compiler.SymbolTable;
import java.io.IOException;
import GeneratedCodeLib.Logic;

public class Exp16_Igual implements Exp {
	public final Exp exp1;
	public final Exp exp2;
	private int type;

	public Exp16_Igual(Exp exp1, Exp exp2) {
		this.exp1 = exp1;
		this.exp2 = exp2;
	}

	public int computeType() throws CompilerExc {
		if (exp1.computeType() == exp2.computeType()) {
			type = exp1.computeType(); /* Guardamos type para no controlar la excepción en generateCode() */
			return SymbolTable.BOOL;
		}
		
		throw new IncorrectTypesExc("Incorrect type in comparison operation.");
	}

	public String generateCode() {
        if (type == SymbolTable.INT) {
        	return "new Logic(false, (" + exp1.generateCode() + ") == (" + exp2.generateCode() + "))";
        } else if (type == SymbolTable.STRING) {
        	return "new Logic(false, (" + exp1.generateCode() + ").equals(" + exp2.generateCode() + "))";
        } else {
        	return "new Logic(false, (" + exp1.generateCode() + ").compareLogic(" + exp2.generateCode() + "))";
        }
    }
}