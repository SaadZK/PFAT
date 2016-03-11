package Errors;

public class DoubleVarDefExc extends CompilerExc {

	private String msg;

	public DoubleVarDefExc(String msg) {
		this.msg = msg;
	}

	public String toString() {
		return msg;
	}
}
