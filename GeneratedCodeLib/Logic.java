package GeneratedCodeLib;

public class Logic {

	private boolean unkVal; /* is unknown */
	private boolean tfVal; /* true-false value */

	public Logic(boolean unkVal, boolean tfVal) {
		this.unkVal = unkVal;
		this.tfVal = tfVal;
	}

	/* Returns true if the Logic value represented by this object is unknown */
	public boolean isUnk() {
		return unkVal;
	}

	/* Returns true if the Logic value represented by this object is true */
	public boolean isTrue() {
		return !unkVal && tfVal;
	}
	
	/* Returns true if the Logic value represented by this object is false */
	public boolean isFalse() {
		return !unkVal && !tfVal;
	}

	/* Implements the and operator between this object and the argument */
	public Logic and(Logic other) {
		if (this.isFalse() || other.isFalse()){
			return new Logic(false, false);
		}
		
		if (this.isTrue() && other.isTrue()){
			return new Logic(false, true);
		}

		return new Logic(true, true);
	}
	
	/* Implements the or operator between this object and the argument */
	public Logic or(Logic other) {
		if (this.isTrue() || other.isTrue()){
			return new Logic(false, true);
		}

		if (this.isFalse() && other.isFalse()){
			return new Logic(false, false);
		}

		return new Logic(true, true);
	}
	
	/* Implements the not operator for this object */
	public Logic not() {
		if (this.isUnk()){
			return this;
		}

		return new Logic(false, !tfVal);
	}

	public static String valueToString(int type) {
		String value = (type == 0) ? "false, true" : (type == 1) ? "false, false" : "true, true";
		return "new Logic(" + value + ")";
	}

	public boolean compareLogic(Logic logic) {
		if ((this.unkVal == logic.unkVal) && (this.tfVal == logic.tfVal)){
			return true;
		}
		return false;
	}

}