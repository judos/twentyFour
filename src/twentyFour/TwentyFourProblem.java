package twentyFour;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import twentyFour.terms.PrimitiveOperator;

public class TwentyFourProblem extends BaseProblem {

	private ArrayList<Integer> numbers;
	private StringBuffer log;

	public TwentyFourProblem(int caseNr, ArrayList<Integer> numbers) {
		super(caseNr);
		this.numbers = numbers;
		this.log = new StringBuffer();
		if (numbers.size() != 4)
			throw new InvalidParameterException("must provide 4 numbers");
	}

	public boolean doesSolveProblem() {
		try {
			double result;
			int nr1 = numbers.remove(getNr(4));
			int nr2 = numbers.remove(getNr(3));
			int nr3 = numbers.remove(getNr(2));
			int nr4 = numbers.remove(0);

			// can do multiple orders:
			int orderCase = getNr(0, 3);
			if (orderCase == 0) { // (a x b) x (c x d)
				double a = calc(nr1, nr2);
				double b = calc(nr3, nr4);
				result = calc(a, b);
			}
			else if (orderCase == 1) { // ((a x b) x c) x d
				double a = calc(nr1, nr2);
				double b = calc(a, nr3);
				result = calc(b, nr4);
			}
			else if (orderCase == 2) { // a x ((b x c) x d)
				double a = calc(nr2, nr3);
				double b = calc(a, nr4);
				result = calc(nr1, b);
			}
			else { // a x (b x (c x d))
				double a = calc(nr3, nr4);
				double b = calc(nr2, a);
				result = calc(nr1, b);
			}
			return result == 24;
		}
		catch (InvalidParameterException e) {}
		return false;
	}

	public double calc(double nr1, double nr2) {
		PrimitiveOperator op = getEnum(PrimitiveOperator.class);
		double result = op.getOperator().apply(nr1, nr2);
		log.append(nr1 + op.toString() + nr2 + "=" + result + ", ");
		return result;
	}

	public String getLog() {
		return this.log.toString();
	}
}
