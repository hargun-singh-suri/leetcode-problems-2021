package leetcode.problems.weeklycontest232;

import leetcode.problems.common.Common;

/**
 * @author hargun.suri
 *
 */
public class Problem1790 implements Common {

	public static void main() {
		Problem1790 obj = new Problem1790();
		String s1;
		String s2;

		/******************** Inputs *****************************/
		// s1 = "bank";
		// s2 = "kanb";

		// s1 = "attack";
		// s2 = "defend";

		// s1 = "attack";
		// s2 = "defend";

		// s1 = "kelb";
		// s2 = "kelb";

		s1 = "abcd";
		s2 = "dcba";
		boolean result = obj.areAlmostEqual(s1, s2);
		System.out.print(result);
	}

	/*
	 * Agree this solution overkills just bruteforce for weekly contest
	 * submission.
	 */
	public boolean areAlmostEqual(String s1, String s2) {
		// Base conditions

		boolean result = false;
		boolean multipleResult = false;

		if (s1 == null || s2 == null) {
			return result;
		}

		int s1Length = s1.length();
		int s2Length = s2.length();

		if (!(s1Length >= 1 && s1Length <= 100)) {
			return result;
		}

		if (!(s2Length >= 1 && s2Length <= 100)) {
			return result;
		}

		if (s1Length != s2Length) {
			return result;
		}

		if (s1.equals(s2)) {
			return true;
		}

		/*
		 * Create character array of the string.
		 */
		char[] string1CharsMain = new char[s1Length];
		for (int i = 0; i < s1Length; i++) {
			string1CharsMain[i] = s1.charAt(i);
		}

		/*
		 * Create a temporary array which will be used for string comparison and
		 * swapping the array elements.
		 * 
		 * Complexity over-killing here o(n^3), this should be handled in O(n)
		 * time actually, but as a programmer we must have a solution first or
		 * an approach on top of that we can build efficient logic, so this is
		 * working code and we need to tweak this to achieve o(n) complexity.
		 */
		char[] string1CharsTemp = new char[s1Length];

		for (int i = 0; i < s1Length; i++) {

			/*
			 * On swapping the string element we can get multiple result as
			 * success then this fails the condition
			 * "at most one string swap on exactly one of the strings.", only 1
			 * swap should satisfy.
			 */
			if (multipleResult) {
				break;
			}

			for (int j = i + 1; j < s1Length; j++) {

				/*
				 * Copying elements of an array each time overkill here as well.
				 */
				System.arraycopy(string1CharsMain, 0, string1CharsTemp, 0, s1Length);

				// Store current value and the next value for swap
				char source = string1CharsMain[i];
				char destination = string1CharsMain[j];

				string1CharsTemp[i] = destination;
				string1CharsTemp[j] = source;

				// Convert array to string value.
				String newString = new String(string1CharsTemp);

				if (s2.equals(newString)) {

					/*
					 * If we have already achieve our result we don't want
					 * another success string comparison.
					 */
					if (result) {
						multipleResult = true;
						result = false;
						break;
					} else {
						result = true;
					}

				}

			}

			string1CharsTemp = new char[s1Length];
		}

		return result;
	}

	@Override
	public void question() {

		/*
		 * 1790. Check if One String Swap Can Make Strings Equal
		 * 
		 * You are given two strings s1 and s2 of equal length. A string swap is
		 * an operation where you choose two indices in a string (not
		 * necessarily different) and swap the characters at these indices.
		 * 
		 * Return true if it is possible to make both strings equal by
		 * performing at most one string swap on exactly one of the strings.
		 * Otherwise, return false.
		 * 
		 * 
		 * Example 1:
		 * 
		 * Input: s1 = "bank", s2 = "kanb" Output: true Explanation: For
		 * example, swap the first character with the last character of s2 to
		 * make "bank".
		 * 
		 * Example 2:
		 * 
		 * Input: s1 = "attack", s2 = "defend" Output: false Explanation: It is
		 * impossible to make them equal with one string swap.
		 * 
		 * Example 3:
		 * 
		 * Input: s1 = "kelb", s2 = "kelb" Output: true Explanation: The two
		 * strings are already equal, so no string swap operation is required.
		 * 
		 * Example 4:
		 * 
		 * Input: s1 = "abcd", s2 = "dcba" Output: false
		 * 
		 * 
		 * Constraints:
		 * 
		 * 1 <= s1.length, s2.length <= 100 s1.length == s2.length s1 and s2
		 * consist of only lowercase English letters.
		 * 
		 */

	}

}
