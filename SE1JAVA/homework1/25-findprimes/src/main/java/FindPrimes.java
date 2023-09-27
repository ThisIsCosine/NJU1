import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindPrimes {


	public static void main(String[] args) {
		int t = 0;
		int[] array = new int[100];
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			t = Integer.parseInt(br.readLine());
			for (int i = 0; i < t; i++){
				array[i] = Integer.parseInt(br.readLine());
			}
		}catch (IOException e){
			e.printStackTrace();
		}
		for (int i = 0; i < t; i++){
			for (int j = 2; j < array[i]; j++){
				int a = 1;
				for (int k = 2; k < j; k++){
					if(j % k == 0){
						a = 0;
						break;
					}
				}
				int b = 1;
				for(int k = 2; k < array[i] - j; k++){
					if((array[i] - j) % k == 0){
						b = 0;
						break;
					}
				}
				if(a == 1 && b == 1){
					System.out.printf("%d %d\n",j,array[i] - j);
					break;
				}
			}
		}
	}

}
