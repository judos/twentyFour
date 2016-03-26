package twentyFour;

public class FindUnsolvable {

	/**
	 * Unsolvable problems: 5952 of total 28561 <br>
	 * or ~ 20.84 %
	 */
	public static void main(String[] args) {

		int[] numbers = new int[4];
		int unsolvable = 0;
		for (int i = 0; i < Math.pow(13, 4); i++) {
			if (i % 1000 == 0)
				System.out.print(i + ".");
			int current = i;
			for (int j = 0; j < 4; j++) {
				numbers[j] = (current % 13) + 1;
				current /= 13;
			}

			Solve24 s = new Solve24(numbers);
			if (!s.isSolvable()) {
				unsolvable++;
			}
		}
		System.out.println("Unsolvable problems: " + unsolvable);
	}

}
