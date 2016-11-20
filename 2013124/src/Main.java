import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int count = scanner.nextInt();
		long mod = 1000000007;
		
		long[][] numbers = new long[count][6];
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < 6; j++) {
				numbers[i][j] = 0;
			}
		}
		
		numbers[0][0] = 1;
		
		for (int i = 1; i < count; i++) {
			int j = i - 1;
			// status 0: 2
			numbers[i][0] = 1;
			// status 1: 2 0
			numbers[i][1] = (numbers[j][0] + numbers[j][1] * 2) % mod;
			// status 2: 2 3
			numbers[i][2] = (numbers[j][0] + numbers[j][2]) % mod;
			// status 3: 2 0 3
			numbers[i][3] = (numbers[j][1] + numbers[j][2] + numbers[j][3] * 2) % mod;
			// status 4: 2 0 1
			numbers[i][4] = (numbers[j][1] + numbers[j][4] * 2) % mod;
			// status 5: 2 0 1 3
			numbers[i][5] = (numbers[j][3] + numbers[j][4] + numbers[j][5] * 2) % mod;
		}
		
		System.out.println(numbers[count - 1][5]);
	}
}
