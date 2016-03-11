package Errors;

public class VarNotFoundExc extends CompilerExc {

	private String msg;

	public VarNotFoundExc(String msg) {
		this.msg = msg;
	}

	public String toString() {
		return msg;
	}
}
