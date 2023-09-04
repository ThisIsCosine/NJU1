import java.util.Scanner;
public class CurrencyExchange {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many euros are you exchanging?");
        int money = input.nextInt();
        System.out.print("What is the exchange rate?");
        double rate = input.nextDouble();
        double result = money * rate;
        System.out.printf("%.2f euros at an exchange rate of %.2f is %.2f U.S. dollars.",(double)money, rate, result);
        input.close();
    }
}
