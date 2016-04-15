package Errors;

public class IncorrectTypesExc extends CompilerExc {

	private String msg;

	public IncorrectTypesExc(String msg) {
		this.msg = msg;
	}

	public String toString() {
		return msg;
	}
}
