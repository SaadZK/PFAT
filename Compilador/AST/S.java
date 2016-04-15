package AST;

import Errors.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.IOException;

public interface S {
	public void computeAH1() throws CompilerExc;
	public void generateCode(BufferedWriter w) throws IOException;
}