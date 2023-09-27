

import java.util.Arrays;

/**
 * 矩阵类，实现矩阵的加法，矩阵乘法
 * 1.传入一个int[][]进行2个矩阵的操作
 * 2.返回一个int[][]
 * 所有的数据均为int型
 * 输入数据均默认为正确数据，不需要对输入数据进行校验
 * @author Qin Liu
 *
 */
public class BadMatrix {
	private int[][] data;

	/**
	 * 构造函数，参数为2维int数组
	 * a[i][j]是矩阵中的第i+1行，第j+1列数据
	 * @param a
	 */
	public BadMatrix(int[][] a){
		this.data = a;
	}

	public int[][] getData() {
		return data;
	}


	/**
	 * 实现矩阵加法，返回一个新的矩阵
	 * @param b
	 * @return
	 */
    public int[][] plus(int[][] b){
		int[][] a = {
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0}
		};
		for (int i = 0; i < 3; i++) {
			for (int i1 = 0; i1 < 3; i1++) {
				a[i][i1] = this.data[i][i1] + b[i][i1];
			}
		}
		return a;
	}


	/**
	 * 实现矩阵乘法，返回一个新的矩阵
	 * @param b
	 * @return
	 */
	public int[][] times(int[][] b){
		int[][] a = {
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0}
		};
		a = new int[this.data.length][b[0].length];
		for (int i = 0; i < this.data.length; i++) {
			for (int i1 = 0; i1 < b[0].length; i1++) {
				for (int i2 = 0; i2 < this.data[0].length; i2++) {
					a[i][i1] += this.data[i][i2] * b[i2][i1];
				}
			}
		}
		return a;
	}

	//不要修改下面print方法

	/**
	 * 打印出该矩阵的数据
	 *
	 */
	public void print(){
		System.out.print(this.toString());
	}

	/**
	 * 实现toString方法
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
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(System.getProperty("line.separator"));
		for (int i = 0; i < data.length; i++) {
			for (int i1 = 0; i1 < data[0].length; i1++) {
				if (i1 < data[0].length - 1){
					stringBuilder.append(Integer.toString(this.data[i][i1]));
					stringBuilder.append(' ');
				} else {
					stringBuilder.append(Integer.toString(this.data[i][i1]));
					stringBuilder.append(System.getProperty("line.separator"));
				}
			}
		}
		return stringBuilder.toString();
	}

	//不要修改下面equals方法
	public boolean equals(Object o){
		if(this.toString().equals(((BadMatrix)o).toString()))
			return true;
		else
			return false;
	}
}
