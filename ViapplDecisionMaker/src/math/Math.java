/*******************************************************************************
 * Copyright (c) 2020 KC Igwe
 ******************************************************************************
 */
package math;

import java.util.Arrays;
public class Math {
	/**
	 * Private constructor.
	 */
	private Math() {
	}
	/**
	 * Returns the absolute value of a double value.
	 */
	public static double abs(double a) {
		return java.lang.Math.abs(a);
	}
	
	/**
	 * Returns the absolute value of a float value.
	 */
	public static float abs(float a) {
		return java.lang.Math.abs(a);
	}
	
	/**
	 * Returns the absolute value of an int value.
	 */
	public static int abs(int a) {
		return java.lang.Math.abs(a);
	}
	
	/**
	 * Returns the absolute value of a long value.
	 */
	public static long abs(long a) {
		return java.lang.Math.abs(a);
	}
	
	/**
	 * Returns the greater of two double values.
	 */
	public static double max(double a, double b) {
		return java.lang.Math.max(a, b);
	}
	
	/**
	 * Returns the greater of two float values.
	 */
	public static float max(float a, float b) {
		return java.lang.Math.max(a, b);
	}
	
	/**
	 * Returns the greater of two int values.
	 */
	public static int max(int a, int b) {
		return java.lang.Math.max(a, b);
	}
	
	/**
	 * Returns the greater of two long values.
	 */
	public static long max(long a, long b) {
		return java.lang.Math.max(a, b);
	}
	
	/**
	 * Returns the smaller of two double values.
	 */
	public static double min(double a, double b) {
		return java.lang.Math.min(a, b);
	}
	
	/**
	 * Returns the smaller of two float values.
	 */
	public static float min(float a, float b) {
		return java.lang.Math.min(a, b);
	}
	
	/**
	 * Returns the smaller of two int values.
	 */
	public static int min(int a, int b) {
		return java.lang.Math.min(a, b);
	}
	
	/**
	 * Returns the smaller of two long values.
	 */
	public static long min(long a, long b) {
		return java.lang.Math.min(a, b);
	}
	
	
	/**
	 * minimum of 3 integers
	 */
	public static int min(int a, int b, int c) {
		return min(min(a, b), c);
	}
	
	/**
	 * minimum of 3 floats
	 */
	public static double min(float a, float b, float c) {
		return min(min(a, b), c);
	}
	
	/**
	 * minimum of 3 doubles
	 */
	public static double min(double a, double b, double c) {
		return min(min(a, b), c);
	}
	
	/**
	 * maximum of 3 integers
	 */
	public static int max(int a, int b, int c) {
		return max(max(a, b), c);
	}
	
	/**
	 * maximum of 3 floats
	 */
	public static float max(float a, float b, float c) {
		return max(max(a, b), c);
	}
	
	/**
	 * maximum of 3 doubles
	 */
	public static double max(double a, double b, double c) {
		return max(max(a, b), c);
	}
	
	/**
	 * Returns the minimum value of an array.
	 */
	public static int min(int[] x) {
		int m = x[0];
		
		for (int n : x) {
			if (n < m) {
				m = n;
			}
		}
		
		return m;
	}
	
	/**
	 * Returns the minimum value of an array.
	 */
	public static float min(float[] x) {
		float m = Float.POSITIVE_INFINITY;
		
		for (float n : x) {
			if (n < m) {
				m = n;
			}
		}
		
		return m;
	}
	
	/**
	 * Returns the minimum value of an array.
	 */
	public static double min(double[] x) {
		double m = Double.POSITIVE_INFINITY;
		
		for (double n : x) {
			if (n < m) {
				m = n;
			}
		}
		
		return m;
	}
	
	/**
	 * Returns the index of minimum value of an array.
	 */
	public static int whichMin(int[] x) {
		int m = x[0];
		int which = 0;
		
		for (int i = 1; i < x.length; i++) {
			if (x[i] < m) {
				m = x[i];
				which = i;
			}
		}
		
		return which;
	}
	
	/**
	 * Returns the index of minimum value of an array.
	 */
	public static int whichMin(float[] x) {
		float m = Float.POSITIVE_INFINITY;
		int which = 0;
		
		for (int i = 0; i < x.length; i++) {
			if (x[i] < m) {
				m = x[i];
				which = i;
			}
		}
		
		return which;
	}
	
	/**
	 * Returns the index of minimum value of an array.
	 */
	public static int whichMin(double[] x) {
		double m = Double.POSITIVE_INFINITY;
		int which = 0;
		
		for (int i = 0; i < x.length; i++) {
			if (x[i] < m) {
				m = x[i];
				which = i;
			}
		}
		
		return which;
	}
	
	
	/**
	 * Returns the maximum value of an array.
	 */
	public static int max(int[] x) {
		int m = x[0];
		
		for (int n : x) {
			if (n > m) {
				m = n;
			}
		}
		
		return m;
	}
	
	/**
	 * Returns the maximum value of an array.
	 */
	public static float max(float[] x) {
		float m = Float.NEGATIVE_INFINITY;
		
		for (float n : x) {
			if (n > m) {
				m = n;
			}
		}
		
		return m;
	}
	
	/**
	 * Returns the maximum value of an array.
	 */
	public static double max(double[] x) {
		double m = Double.NEGATIVE_INFINITY;
		
		for (double n : x) {
			if (n > m) {
				m = n;
			}
		}
		
		return m;
	}
	/**
	 * Returns Euler's number e raised to the power of a double value.
	 */
	public static double exp(double a) {
		return java.lang.Math.exp(a);
	}
	/**
	 * Returns the natural logarithm (base e) of a double value.
	 */
	public static double log(double a) {
		return java.lang.Math.log(a);
	}
	
	/**
	 * Returns the base 10 logarithm of a double value.
	 */
	public static double log10(double a) {
		return java.lang.Math.log10(a);
	}
	
	/**
	 * L1 vector norm.
	 */
	public static double norm1(double[] x) {
		double norm = 0.0;
		
		for (double n : x) {
			norm += java.lang.Math.abs(n);
		}
		
		return norm;
	}
	/**
	 * Unitize an array so that L1 norm of x is 1.
	 *
	 * @param x an array of nonnegative double
	 */
	public static void unitize1(double[] x) {
		double n = norm1(x);
		
		for (int i = 0; i < x.length; i++) {
			x[i] /= n;
		}
	}
	/**
	 * Unitize an array so that L1 norm of sub array x[from], x[from + 1] ... to x[to -1] is 1.
	 *
	 * @param x an array of nonnegative double
	 * @param from the start index
	 * @param to the end index (exclusive)
	 * Method by KC Igwe
	 */
	public static void unitize1(double[] x, int from, int to) {
		if(from >= x.length){
			from = x.length-1;
		}
		double n = norm1(Arrays.copyOfRange(x, from, to));
		
		for (int i = from; i < to; i++) {
			x[i] /= n;
		}
	}
	
	/**
	 * Returns the sum of an array.
	 */
	public static int sum(int[] x) {
		double sum = 0.0;
		
		for (int n : x) {
			sum += n;
		}
		
		if (sum > Integer.MAX_VALUE || sum < -Integer.MAX_VALUE) {
			throw new ArithmeticException("Sum overflow: " + sum);
		}
		
		return (int) sum;
	}
	
	
	/**
	 * Returns the sum of an array.
	 */
	public static double sum(float[] x) {
		double sum = 0.0;
		
		for (float n : x) {
			sum += n;
		}
		
		return sum;
	}
	
	/**
	 * Returns the sum of an array.
	 */
	public static double sum(double[] x) {
		double sum = 0.0;
		
		for (double n : x) {
			sum += n;
		}
		
		return sum;
	}
	
	
	
	
}
