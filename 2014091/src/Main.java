import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = Integer.parseInt(scanner.nextLine());
		int[] numbers = new int[n];
		
		for (int i = 0; i < n; i++) {
			numbers[i] = scanner.nextInt();
		}
		
		int result = 0;
		
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (Math.abs(numbers[i] - numbers[j]) == 1) {
					result ++;
				}
			}
		}
		
		System.out.println(result);
		
		scanner.close();
	}
}
