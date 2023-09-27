import java.io.*;

public class CurrencyCalculation {

    public static void main(String[] args) {

        double money = 0;
        double rate = 0;
        double result = 0;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("How many euros are you exchanging?");
            money = Double.parseDouble(br.readLine());
            System.out.println("What is the exchange rate?");
            rate = Double.parseDouble(br.readLine());
        }catch (IOException e){
            e.printStackTrace();
        }
        result = money * rate / 100;
        System.out.printf("%.2f euros at an exchange rate of %.2f is %.2f U.S. dollars.",money, rate, result);
        }

}
