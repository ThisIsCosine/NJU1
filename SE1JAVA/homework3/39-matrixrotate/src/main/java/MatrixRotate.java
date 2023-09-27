import java.util.Scanner;

public class MatrixRotate {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int[][] s = new int[m][n];
        int[][] result1 = new int[m][n];
        int[][] result2 = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                s[i][j] = input.nextInt();
            }
        }
        int angle = input.nextInt() % 360;
        if ((m == 1 && n == 1) || (angle == 0)){
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.printf("%d ",s[i][j]);
                }
                System.out.println();
            }
        } else if (angle == 90) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    result2[j][m - 1 - i] = s[i][j];
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.printf("%d ",result2[i][j]);
                }
                System.out.println();
            }
        } else if (angle == 180) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    result1[m - 1 - i][n - 1 - j] = s[i][j];
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.printf("%d ",result1[i][j]);
                }
                System.out.println();
            }
        } else if (angle == 270){
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    result2[n - 1 - j][i] = s[i][j];
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.printf("%d ",result2[i][j]);
                }
                System.out.println();
            }
        }

        //TODO
        //your implementation should not be too slow
    }
}
