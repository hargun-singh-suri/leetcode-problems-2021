/**
 * 
 */
package leetcode.problems.easy.qno1480;

import java.util.Arrays;

/**
 * @author hargun.suri
 *
 */
public class BruteForceV1 {

	public static void main(String args[]) {
		BruteForceV1 obj = new BruteForceV1();
		//Inputs
		// int[] intArray = new int[] { 1, 2, 3, 4 };
		// int[] intArray = new int[] { 1,1,1,1,1 };
		int[] intArray = new int[] { 3, 1, 2, 10, 1 };
		int[] returnedValue = obj.action(intArray);
		System.out.println(Arrays.toString(returnedValue));
	}

	public int[] action(int[] nums) {

		int[] output = new int[nums.length];

		int newValue = 0;
		int currentValue = 0;

		if (nums.length <= 0) {
			return output;
		}

		for (int index = 0; index < nums.length; index++) {
			newValue = nums[index] + currentValue;
			output[index] = newValue;
			currentValue = newValue;
		}

		return output;
	}

}
