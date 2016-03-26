package twentyFour.terms;

public class ConstantTerm extends Term {

	private double value;

	public ConstantTerm(double value) {
		this.value = value;
	}

	@Override
	public double getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		if (this.value % 1 == 0)
			return String.valueOf((long) this.value);
		return String.valueOf(this.value);
	}
}
