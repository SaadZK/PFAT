package AST;

import Errors.*;
import java.io.BufferedWriter;
import java.io.IOException;

public interface SentList {
	public void computeAH1() throws CompilerExc;
	public void generateCode(BufferedWriter w, String tabs) throws IOException;
}