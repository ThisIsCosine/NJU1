import java.util.Scanner;
public class ZTransformation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.next();
        int N= input.nextInt();
        char[] charArray = str.toCharArray();

        if (N == 1){
            for (int i = 0; i < str.length(); i++){
                if (i != str.length() - 1)
                    System.out.printf("%c ",charArray[i]);
                else
                    System.out.printf("%c",charArray[i]);
            }
            System.out.println();
        }
        int onePart = 2 * N - 2;
        if (N != 1) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < str.length(); j++) {
                    if (j % onePart < N && j % onePart == i) {
                        if (j / onePart == 0) {
                            if (j + onePart > str.length())
                                System.out.printf("%c", charArray[j]);
                            else
                                System.out.printf("%c ", charArray[j]);
                        } else {
                            if (j % onePart == 0) {
                                for (int k = 0; k < N - 2; k++) {
                                    System.out.printf("  ");
                                }
                                if (((j + onePart < str.length() || j - i + onePart - i < str.length()) && i != N - 1)
                                || (j + onePart < str.length() && i == N - 1))
                                    System.out.printf("%c ", charArray[j]);
                                else
                                    System.out.printf("%c", charArray[j]);
                            } else {
                                for (int k = 0; k < (j % onePart - 1); k++) {
                                    System.out.printf("  ");
                                }
                                if (((j + onePart < str.length() || j - i + onePart - i < str.length()) && i != N - 1)
                                        || (j + onePart < str.length() && i == N - 1))
                                    System.out.printf("%c ", charArray[j]);
                                else
                                    System.out.printf("%c", charArray[j]);
                            }
                        }
                    } else if (j % onePart == (onePart - i)) {
                        for (int k = 0; k < (N - 2 - i); k++) {
                            System.out.printf("  ");
                        }
                        if (j + i * 2 < str.length())
                            System.out.printf("%c ", charArray[j]);
                        else
                            System.out.printf("%c", charArray[j]);
                    }
                }
                if (i < str.length()) {
                    System.out.println();
                }
            }
        }
        //TODO
    }
}
