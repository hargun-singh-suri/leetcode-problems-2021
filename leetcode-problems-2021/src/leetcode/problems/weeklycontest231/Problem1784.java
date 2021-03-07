/**
 * 
 */
package leetcode.problems.weeklycontest231;

import leetcode.problems.common.Common;

/**
 * @author hargun.suri
 *
 */
public class Problem1784 implements Common {

	public static void main(String args[]) {
		String input = null;
		Problem1784 obj = new Problem1784();
		//input = "110011"; --false
		//input = "1"; -- true
		//input = "10"; -- true
		//input = "10001"; -- false
		//input = "110"; -- true
		boolean result = obj.checkOnesSegment(input);
		System.out.println(result);

	}

	public boolean checkOnesSegment(String s) {

		boolean result = false;
		boolean continiouseSequence = false;
		boolean sequenceBreaked = false;

		// Base condition
		if (s == null || s.length() < 0 || s.length() > 100) {
			return false;
		}

		for (int index = 0; index < s.length(); index++) {

			/*
			 * Get integer ASCII value by Substracting character ASCII by ASCII
			 * of 0
			 */
			int value = s.charAt(index) - '0';

			/*
			 * If we have first value as 1 and sequence of 1 is still not break
			 * we keep on parsing the value.
			 */
			if (value == 1 && !sequenceBreaked) {
				continiouseSequence = true;
				result = true;
			}

			/*
			 * If value identified as 0 and continiouseSequence earlier was
			 * valid now it termed to be break.
			 */
			else if (value == 0 && continiouseSequence) {
				sequenceBreaked = true;
			}

			/*
			 * If we identify value as 1 but sequence was earlier break by 0
			 * then at most one contiguous segment of ones does not satisfy.
			 */
			else if (value == 1 && sequenceBreaked) {
				result = false;
				break;
			}
			/*
			 * if value == 0 && !continiouseSequence
			 * 
			 * Value as 0 and continiouseSequence is still false we don't have
			 * to add condition because first element will always 1 and then
			 * continiouseSequence will be marked as true initially will hardly
			 * reach here.
			 */

		}

		return result;
	}

	@Override
	public void question() {
		/*
		 * 1784 Check if Binary String Has at Most One Segment of Ones
		 * 
		 * Given a binary string s without leading zeros, return true, if s
		 * contains at most one contiguous segment of ones. Otherwise, return
		 * false.
		 * 
		 * Example 1:
		 * 
		 * Input: s = "1001" Output: false Explanation: The ones do not form a
		 * contiguous segment.
		 * 
		 * Example 2:
		 * 
		 * Input: s = "110" Output: true
		 * 
		 * 
		 * Constraints:
		 * 
		 * 1 <= s.length <= 100 s[i] is either '0' or '1'. s[0] is '1'.
		 * 
		 */
	}

}
