import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ResponseTimeCalculation {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a Number:");
		String input = scanner.next();
		int time;
		ArrayList<Integer> arrayList = new ArrayList<>();
		while (!input.equals("done")){
			System.out.println("Enter a Number:");
			time = Integer.parseInt(input);
			arrayList.add(time);
			input = scanner.next();
		}
		double sum = 0;
		double avarge = 0;
		int length = arrayList.size();
		for (int i = 0; i < length; i++) {
			sum += (double) arrayList.get(i);
		}
		avarge = sum / length;
		int max = Collections.max(arrayList);
		int min = Collections.min(arrayList);
		double Fangcha = 0;
		for (int i = 0; i < length; i++) {
			Fangcha += Math.pow((double)arrayList.get(i) - avarge, 2);
		}
		double standardDeviation = Math.sqrt(Fangcha / length);
		System.out.print("Numbers:");
		for (int i = 0; i < length; i++) {
			if (i < length - 1)
				System.out.printf("%d,", arrayList.get(i));
			else
				System.out.printf("%d", arrayList.get(i));
		}
		System.out.println();
		System.out.printf("The average is %.2f.\n", avarge);
		System.out.printf("The minimum is %d.\n", min);
		System.out.printf("The maximum is %d.\n", max);
		System.out.printf("The standard deviation is %.2f.\n", standardDeviation);


	}

}
