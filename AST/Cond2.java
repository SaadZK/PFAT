package AST;

import Errors.*;
import Compiler.SymbolTable;
import java.io.BufferedWriter;
import java.io.IOException;

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

	public void generateCode(BufferedWriter w, String tabs) throws IOException {
		w.newLine();
		w.write(tabs + "if ((" + exp.generateCode() + ").isTrue()) {");
		w.newLine();
		sent1.generateCode(w, tabs + "	");
		w.newLine();
		w.write(tabs + "} else {");
		w.newLine();
		sent2.generateCode(w, tabs + "	");
		w.newLine();
		w.write(tabs + "}");
		w.newLine();
	}

}