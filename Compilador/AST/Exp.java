package AST;

import Errors.*;
import java.io.BufferedWriter;
import java.io.IOException;

public interface Exp {
	public int computeType() throws CompilerExc;
	public String generateCode();
}