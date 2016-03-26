package twentyFour.controller;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import twentyFour.terms.ConstantTerm;
import twentyFour.terms.OperatorTerm;
import twentyFour.terms.PrimitiveOperator;
import twentyFour.terms.Term;

public class TwentyFourProblem extends BaseProblem {

	private ArrayList<Term> numbers;
	private StringBuffer log;
	private Term resultTerm;

	public TwentyFourProblem(int caseNr, ArrayList<Integer> numbers) {
		super(caseNr);
		this.numbers = new ArrayList<>();
		for (Integer i : numbers)
			this.numbers.add(new ConstantTerm((double) i));

		if (numbers.size() != 4)
			throw new InvalidParameterException("must provide 4 numbers");
	}

	public boolean doesSolveProblem() {
		try {
			do {
				addUpTogether();
			} while (numbers.size() > 1);
			this.resultTerm = numbers.remove(0);
			return this.resultTerm.getValue() == 24;
		}
		catch (InvalidParameterException e) {}
		return false;
	}

	private void addUpTogether() {
		Term nr1 = numbers.remove(getNr(numbers.size()));
		Term nr2 = numbers.remove(getNr(numbers.size()));
		Term result = new OperatorTerm(nr1, nr2, getEnum(PrimitiveOperator.class));
		this.numbers.add(result);
	}

	public double calc(double nr1, double nr2) {
		PrimitiveOperator op = getEnum(PrimitiveOperator.class);
		double result = op.getOperator().apply(nr1, nr2);
		log.append(nr1 + op.toString() + nr2 + "=" + result + ", ");
		return result;
	}

	public String getLog() {
		return this.resultTerm.toString();
	}
}
