package twentyFour.terms;

import java.util.function.BinaryOperator;

public enum PrimitiveOperator {

	ADD("+", (a, b) -> a + b),
	SUBTRACT("-", (a, b) -> a - b),
	MULTIPLY("*", (a, b) -> a * b),
	DIVIDE("/", (a, b) -> {
		double r = (double) a / b;
		return r;
	});

	private String name;
	private BinaryOperator<Double> binaryOperator;

	private PrimitiveOperator(String name, BinaryOperator<Double> func) {
		this.binaryOperator = func;
		this.name = name;
	}

	public BinaryOperator<Double> getOperator() {
		return this.binaryOperator;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
