package AST;

import Errors.*;

public interface Exp {
	public int computeType() throws CompilerExc;
}