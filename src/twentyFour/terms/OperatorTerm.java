package twentyFour.terms;

import java.util.function.BinaryOperator;

public class OperatorTerm<T> extends Term<T> {

	private Term<T> t1;
	private Term<T> t2;
	private BinaryOperator<T> operator;

	public OperatorTerm(Term<T> t1, Term<T> t2, BinaryOperator<T> operator) {
		this.t1 = t1;
		this.t2 = t2;
		this.operator = operator;
	}

	@Override
	public T getValue() {
		return this.operator.apply(this.t1.getValue(), this.t2.getValue());
	}

}
