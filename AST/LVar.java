package AST;

import Errors.*;

public interface LVar {
	public void computeAH1(int type) throws CompilerExc;
	public int getAH1();
}