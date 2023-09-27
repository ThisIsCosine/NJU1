package edu.nju;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 实现矩阵的加法、乘法以及控制台输出
 * 其中加法和乘法需要有两种实现方式
 * 1.传入一个矩阵进行2个矩阵的操作
 * 2.从控制台（console）读入一个矩阵，再进行操作
 * 所有的数据均为int型
 * 输入数据均默认为正确数据，不需要对输入数据进行校验
 * @author Ray Liu & Qin Liu
 */
public class MatrixCalculation {

	/**
	 * 实现矩阵加法，返回一个新的矩阵
	 * @return result matrix = A + B
	 */
	public int[][] plus(int[][] A, int[][] B){
		int[][] result = new int[A.length][A[0].length];
		for (int i = 0; i < A.length; i++) {
			for (int i1 = 0; i1 < A[i].length; i1++) {
				result[i][i1] = A[i][i1] + B[i][i1];
			}
		}
		// TODO
		return result;
	}

	/**
	 * 实现矩阵乘法，返回一个新的矩阵
	 * @return result matrix = A * B
	 */
	public int[][] times(int[][] A, int[][] B){
		int[][] result = new int[A.length][B[0].length];
		for (int i = 0; i < A.length; i++) {
			for (int i1 = 0; i1 < B[0].length; i1++) {
				for (int i2 = 0; i2 < A[0].length; i2++) {
					result[i][i1] += A[i][i2] * B[i2][i1];
				}
			}
		}
		// TODO
		return result;
	}

	/**
	 * 从控制台读入矩阵数据，进行矩阵加法，读入数据格式如下：
	 * m n
	 * m * n 的数据方阵，以空格隔开
	 * 连续读入2个矩阵数据
	 * example:
	 * 4 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 4 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 返回一个新的矩阵
	 */
	public int [][] plusFromConsole(){
		Scanner scanner = new Scanner(System.in);
		int m1 = 0;
		int n1 = 0;
		int m2 = 0;
		int n2 = 0;
		m1 = scanner.nextInt();
		n1 = scanner.nextInt();
		if (m1 == 0 || n1 == 0){
			int[][] r = new int[0][0];
			return r;
		}
		int[][] A = new int[m1][n1];
		for (int i = 0; i < m1; i++) {
			for (int i1 = 0; i1 < n1; i1++) {
				A[i][i1] = scanner.nextInt();
			}
		}
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String[]  l = br.readLine().split(" ");
			m2 = Integer.parseInt(l[0]);
			n2 = Integer.parseInt(l[1]);
		}catch (IOException e){
			e.printStackTrace();
		}

			if (m2 == 0 || n2 == 0){
				int[][] r = new int[0][0];
				return r;
			}
			int[][] B = new int[m1][n1];
			for (int i = 0; i < m2; i++) {
				for (int i1 = 0; i1 < n2; i1++) {
					B[i][i1] = scanner.nextInt();
				}
			}
			int[][] result = new int[A.length][A[0].length];
			for (int i = 0; i < A.length; i++) {
				for (int i1 = 0; i1 < A[i].length; i1++) {
					result[i][i1] = A[i][i1] + B[i][i1];
				}
			}
			// TODO
			return result;
		}

		/**
		 * 输入格式同上方法相同
		 * 实现矩阵的乘法
		 * 返回一个新的矩阵
		 */
		public int[][] timesFromConsole(){
			Scanner scanner = new Scanner(System.in);
			int m1 = 0;
			int n1 = 0;
			int m2 = 0;
			int n2 = 0;
			m1 = scanner.nextInt();
			n1 = scanner.nextInt();
			if (m1 == 0 || n1 == 0){
				int[][] r = new int[0][0];
				return r;
			}
			int[][] A = new int[m1][n1];
			for (int i = 0; i < m1; i++) {
				for (int i1 = 0; i1 < n1; i1++) {
					A[i][i1] = scanner.nextInt();
				}
			}
			m2 = scanner.nextInt();
			n2 = scanner.nextInt();
			if (m2 == 0 || n2 == 0){
				int[][] r = new int[0][0];
				return r;
			}
			int[][] B = new int[m2][n2];
			for (int i = 0; i < m2; i++) {
				for (int i1 = 0; i1 < n2; i1++) {
					B[i][i1] = scanner.nextInt();
				}
			}
			int[][] result = new int[A.length][B[0].length];
			for (int i = 0; i < A.length; i++) {
				for (int i1 = 0; i1 < B[0].length; i1++) {
					for (int i2 = 0; i2 < A[0].length; i2++) {
						result[i][i1] += A[i][i2] * B[i2][i1];
					}
				}
			}
			// TODO
			return result;
		}

		/**
		 * 打印出该矩阵的数据
		 * 起始一个空行，结束一个空行
		 * 矩阵中每一行数据呈一行，数据间以空格隔开
		 * example：
		 *
		 * 1 2 3
		 * 1 2 3
		 * 1 2 3
		 * 1 2 3
		 *
		 */
		public void print(int[][] A){
			System.out.println();
			for (int i = 0; i < A.length; i++) {
				for (int i1 = 0; i1 < A[0].length - 1; i1++) {
					System.out.printf("%d ", A[i][i1]);
				}
				System.out.println(A[i][A[0].length - 1]); // try
			}
			// TODO
		}
}
