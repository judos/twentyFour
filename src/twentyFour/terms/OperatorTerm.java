package twentyFour.terms;

public class OperatorTerm extends Term {

	private Term t1;
	private Term t2;
	private PrimitiveOperator operator;

	public OperatorTerm(Term t1, Term t2, PrimitiveOperator operator) {
		this.t1 = t1;
		this.t2 = t2;
		this.operator = operator;
	}

	@Override
	public double getValue() {
		return this.operator.getOperator().apply(this.t1.getValue(), this.t2.getValue());
	}

	@Override
	public String toString() {
		return "(" + this.t1 + this.operator + this.t2 + ")";
	}

}
