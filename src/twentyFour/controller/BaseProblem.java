package twentyFour.controller;

import java.lang.reflect.Method;
import java.security.InvalidParameterException;
import java.util.List;

public class BaseProblem {

	private int caseNr;
	private int possibilities;

	public BaseProblem(int caseNr) {
		this.caseNr = caseNr;
		this.possibilities = 1;
	}

	/**
	 * creates a random number depending on the caseNr
	 * 
	 * @param max
	 *           exclusive max number
	 */
	public int getNr(int max) {
		this.possibilities *= max;
		int nr0toMax = this.caseNr % max;
		this.caseNr /= max;
		return nr0toMax;
	}

	/** creates a random number between min (inclusive), max (exclusive) */
	public int getNr(int min, int max) {
		int nr0toMax = getNr(max - min + 1);
		return nr0toMax + min;
	}

	public <T> T getEnum(Class<T> clazz) {
		if (!clazz.isEnum())
			throw new InvalidParameterException("Given Type must be an enum class");
		try {
			Method getValues = clazz.getDeclaredMethod("values");
			@SuppressWarnings("unchecked")
			T[] values = (T[]) getValues.invoke(null);
			int nr = getNr(values.length);
			return values[nr];
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public <T> List<T> removeElementsFromList(List<T> list, int numberOfElements) {

		return list;
	}

	public int getPossibilities() {
		return this.possibilities;
	}

}
