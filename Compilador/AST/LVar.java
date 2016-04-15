package AST;

import Errors.*;

public interface LVar {
	public void computeAH1(int type) throws CompilerExc;
	public int getAH1();
	public String generateArguments();
	public String generateCode();
	public String generateMain(int index);
}