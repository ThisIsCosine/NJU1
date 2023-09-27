
import java.util.Scanner;
public class CompareNumbers {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] num = new int[3];
		boolean repeat = false;
		System.out.println("Enter the first number:");

		num[0] = input.nextInt();
		System.out.println("Enter the second number:");
		num[1] = input.nextInt();
		System.out.println("Enter the third number:");
		num[2] = input.nextInt();
		for (int i = 0; i < 2; i++){
			h:for (int j = i + 1; j < 3; j++){
				if (num[j] == num[i]){
					System.out.println("There are same numbers.");
					repeat = true;
					break h;
				}
			}
		}
		if (!repeat){
			int max = num[0];
			for (int i = 0; i < 3; i++) {
				max = Math.max(num[i], max);
			}
			System.out.println("The largest number is " + max + ".");
		}
	}

}
