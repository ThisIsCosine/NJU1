
import java.util.Scanner;

public class HeartRateCalculation {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int restingHR = 0;
		int age = 0;
		System.out.println("RestingHR:");
		restingHR = input.nextInt();
		System.out.println("Age:");
		age = input.nextInt();
		int intensity = 50;
		System.out.println("Intensity|TargetHeartRate\n" + "---------|---------------");
		for (int i = 0; i < 9; i++) {
			intensity += 5;
			double result = (((220 - age) - restingHR) * (intensity / 100.0)) + restingHR;
			System.out.println(intensity + "%|" + Math.round(result) + "bpm"); // Math.round(double/float) -> 四舍五入
		}
	}

}
