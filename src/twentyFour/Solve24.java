package twentyFour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solve24 {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 3, 4, 9);
		ArrayList<Integer> numberList = new ArrayList<Integer>(numbers);

		TwentyFourProblem problem = new TwentyFourProblem(0, numberList);
		problem.doesSolveProblem();
		System.out.println("Estimated possibilities: " + problem.getPossibilities());

		for (int i = 0; i < problem.getPossibilities(); i++) {
			TwentyFourProblem problemCase = new TwentyFourProblem(i, new ArrayList<Integer>(numbers));
			if (problemCase.doesSolveProblem()) {
				System.out.println(problemCase.getLog());
			}
		}
	}
}
