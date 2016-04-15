package Errors;

public class IncorrectConditionExc extends CompilerExc {

	private String msg;

	public IncorrectConditionExc(String msg) {
		this.msg = msg;
	}

	public String toString() {
		return msg;
	}
}
