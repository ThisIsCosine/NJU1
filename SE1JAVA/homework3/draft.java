import java.util.Scanner;

public class draft {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int[][] a = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int i1 = 0; i1 < 5; i1++) {
                a[i][i1] = input.nextInt();
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.printf("%d ", a[i][j]);
            }
            System.out.println();
        }
    }
}
