import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 矩阵类，实现矩阵的加法，矩阵乘法，点乘以及转置方法
 * 其中加法和点乘方法需要有两种实现方式
 * 1.传入一个MyMatrix对象进行2个矩阵的操作
 * 2.从控制台（console）读入一个矩阵数据，再进行操作
 * 所有的数据均为int型
 * 输入数据均默认为正确数据，不需要对输入数据进行校验
 * @author Ray Liu & Qin Liu
 *
 */
public class MyMatrix {
	private int[][] data;

	/**
	 * 构造函数，参数为2维int数组
	 * a[i][j]是矩阵中的第i+1行，第j+1列数据
	 * @param a
	 */
	public MyMatrix(int[][] a){
		this.data = a;
	}

	public int[][] getData() {
		return data;
	}

	/**
	 * 实现矩阵加法，返回一个新的矩阵
	 * @param B
	 * @return
	 */
	public MyMatrix plus(MyMatrix B){
		int[][] b = B.getData();
		int[][] r = new int[data.length][data[0].length];
		for (int i = 0; i < data.length; i++) {
			for (int i1 = 0; i1 < data[0].length; i1++) {
				r[i][i1] = data[i][i1] + b[i][i1];
			}
		}
		MyMatrix result = new MyMatrix(r);
		return  result;
	}


	/**
	 * 实现矩阵乘法，返回一个新的矩阵
	 * @param B
	 * @return
	 */
	public MyMatrix times(MyMatrix B){
		int[][] b = B.getData();
		int[][] r = new int[data.length][b[0].length];
		for (int i = 0; i < data.length; i++) {
			for (int i1 = 0; i1 < b[0].length; i1++) {
				for (int i2 = 0; i2 < data[0].length; i2++) {
					r[i][i1] += data[i][i2] * b[i2][i1];
				}
			}
		}
		return new MyMatrix(r);
	}

	/**
	 * 实现矩阵的点乘，返回一个新的矩阵
	 * @param b
	 * @return
	 */
	public MyMatrix times(int b){
		int[][] r = new int[data.length][data[0].length];
		for (int i = 0; i < data.length; i++) {
			for (int i1 = 0; i1 < data[0].length; i1++) {
				r[i][i1] = b * data[i][i1];
			}
		}
		return  new MyMatrix(r);
	}

	/**
	 * 实现矩阵的转置，返回一个新的矩阵
	 * @return
	 */
	public MyMatrix transpose(){
		int[][] r = new int[data[0].length][data.length];
		for (int i = 0; i < data.length; i++) {
			for (int i1 = 0; i1 < data[0].length; i1++) {
				r[i1][i] = data[i][i1];
			}
		}
		return new MyMatrix(r);
	}

	/**
	 * 从控制台读入矩阵数据，进行矩阵加法，读入数据格式如下：
	 * m n
	 * m * n 的数据方阵，以空格隔开
	 * example:
	 * 4 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 返回一个新的矩阵
	 * @return
	 */
	public MyMatrix plusFromConsole(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String input = br.readLine();
			String[] nums = input.split(" ");
			int row = Integer.parseInt(nums[0]);
			int col = Integer.parseInt(nums[1]);
			int[][] inputMatrix = new int[row][col];
			for (int i = 0; i < row; i++) {
				input = br.readLine();
				nums = input.split(" ");
				for (int i1 = 0; i1 < col; i1++) {
					inputMatrix[i][i1] = Integer.parseInt(nums[i1]);
				}
			}
			int[][] r = new int[row][col];
			for (int i = 0; i < row; i++) {
				for (int i1 = 0; i1 < col; i1++) {
					r[i][i1] = data[i][i1] + inputMatrix[i][i1];
				}
			}
			return new MyMatrix(r);
		}catch (IOException e){
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 输入格式同上方法相同
	 * 实现矩阵的乘法
	 * 返回一个新的矩阵
	 * @return
	 */
	public MyMatrix timesFromConsole(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String input = br.readLine();
			String[] nums = input.split(" ");
			int row = Integer.parseInt(nums[0]);
			int col = Integer.parseInt(nums[1]);
			int[][] inputMatrix = new int[row][col];
			for (int i = 0; i < row; i++) {
				input = br.readLine();
				nums = input.split(" ");
				for (int i1 = 0; i1 < col; i1++) {
					inputMatrix[i][i1] = Integer.parseInt(nums[i1]);
				}
			}
			int[][] r = new int[row][col];
			for (int i = 0; i < data.length; i++) {
				for (int i1 = 0; i1 < col; i1++) {
					for (int i2 = 0; i2 < row; i2++) {
						r[i][i1] += data[i][i2] * inputMatrix[i2][i1];
					}
				}
			}
			return new MyMatrix(r);
		}catch (IOException e){
			e.printStackTrace();
		}
		return null;
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
	public void print(){
		System.out.println();
		for (int i = 0; i < data.length; i++) {
			for (int i1 = 0; i1 < data[0].length; i1++) {
				if (i1 < data[0].length - 1){
					System.out.print(Integer.toString(data[i][i1]) + ' ');
				}else {
					System.out.print(data[i][i1] + System.getProperty("line.separator"));
				}
			}
		}
		System.out.println();
	}
}
