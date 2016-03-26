package twentyFour.terms;

public class ConstantTerm<T> extends Term<T> {

	private T value;

	public ConstantTerm(T value) {
		this.value = value;
	}

	@Override
	public T getValue() {
		return this.value;
	}
}
