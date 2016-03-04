public class Cond3 implements Cond {
	public final Exp exp;
	public final Sent sent1;
	public final Sent sent2;
	public final Sent sent3;

	public Cond3(Exp exp, Sent sent1, Sent sent2, Sent sent3) {
		this.exp = exp;
		this.sent1 = sent1;
		this.sent2 = sent2;
		this.sent3 = sent3;
	}
}