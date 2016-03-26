package twentyFour;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import twentyFour.controller.TwentyFourProblem;

public class Solve24 {

	public static void main(String[] args) {
		int[] numbers = { 1, 3, 4, 6 };
		Solve24 s = new Solve24(numbers);
		if (s.isSolvable()) {
			System.out.println(s.getFirstSolution());
			System.out.println("Solutions: " + s.solutions.size() + " / " + s.possibilities);
		}
	}

	private int[] numbers;
	private boolean solved;
	private boolean isSolvable;
	private ArrayList<String> solutions;
	private int possibilities;

	public Solve24(int[] numbers) {
		this.numbers = numbers;
		this.solutions = new ArrayList<String>();
	}

	public boolean isSolvable() {
		if (!this.solved) {
			solve();
		}
		return this.isSolvable;
	}

	public String getFirstSolution() {
		if (this.solutions.size() == 0)
			throw new InvalidParameterException("This problem has no solution");
		return this.solutions.get(0);
	}

	private void solve() {
		this.isSolvable = false;
		this.possibilities = 0;
		ArrayList<Integer> numberList = new ArrayList<>(Arrays.stream(numbers).boxed().collect(Collectors.toList()));
		TwentyFourProblem problem = new TwentyFourProblem(0, numberList);
		problem.doesSolveProblem();
		this.possibilities = problem.getPossibilities();
		for (int i = 0; i < this.possibilities; i++) {
			TwentyFourProblem problemCase = new TwentyFourProblem(i, new ArrayList<Integer>(numberList));
			if (problemCase.doesSolveProblem()) {
				this.isSolvable = true;
				this.solutions.add(problemCase.getLog());
			}
		}
	}

}
