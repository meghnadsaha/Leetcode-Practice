package com.interview.backtracking;

public class Twenty4Game {
	public boolean judgePoint24(int[] nums) {
		double[] a = new double[] { nums[0], nums[1], nums[2], nums[3] };
		return helper(a);
	}

	private boolean helper(double[] a) {
		if (a.length == 1)
			return Math.abs(a[0] - 24) < 0.0001;

		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				double[] d = new double[a.length - 1];

				for (int k = 0, index = 0; k < a.length; k++) {
					if (k != i && k != j) {
						d[index++] = a[k];
					}
				}

				for (double num : compute(a[i], a[j])) {
					d[d.length - 1] = num;
					if (helper(d))
						return true;
				}
			}
		}

		return false;
	}

	private double[] compute(double x, double y) {
		return new double[] { x + y, x - y, y - x, x * y, x / y, y / x };
	}
}
