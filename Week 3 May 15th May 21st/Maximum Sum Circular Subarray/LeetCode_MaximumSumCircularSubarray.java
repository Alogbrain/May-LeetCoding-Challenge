import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class LeetCode_MaximumSumCircularSubarray {
	public static int maxSubarraySumCircular(int[] a) {

		int n = a.length;
		// Case 1: get the maximum sum using standard kadane'
		// s algorithm
		int max_kadane = kadane(a);

		// Case 2: Now find the maximum sum that includes
		// corner elements.
		int max_wrap = 0;
		for (int i = 0; i < n; i++) {
			max_wrap += a[i]; // Calculate array-sum
			a[i] = -a[i]; // invert the array (change sign)
		}
		// max sum with corner elements will be:
		// array-sum - (-max subarray sum of inverted array)

		max_wrap = max_wrap + kadane(a);

		// The maximum circular sum will be maximum of two sums
		if (max_kadane > 0)
			return (max_wrap > max_kadane) ? max_wrap : max_kadane;
		else
			return max_kadane;
	}

	static int kadane(int a[]) {
		int n = a.length;
		int max_so_far = a[0], max_ending_here = a[0];
		for (int i = 1; i < n; i++) {
			max_ending_here = Math.max(a[i], max_ending_here + a[i]);

			if (max_so_far < max_ending_here)
				max_so_far = max_ending_here;
		}
		return max_so_far;
	}

	public static void main(String[] args) {
		int A[] = { -2, -3, -1 };
		System.out.println(maxSubarraySumCircular(A));
	}
}
