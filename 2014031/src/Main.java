import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int count = Integer.parseInt(scanner.nextLine());
		String[] numbersStr = scanner.nextLine().split(" ");
		
		int result = 0;
		
		for (int i = 0; i < count; i++) {
			for (int j = i + 1; j < count; j++) {
				if (Integer.parseInt(numbersStr[i]) + Integer.parseInt(numbersStr[j]) == 0) {
					result ++;
					break;
				}
			}
		}
		
		System.out.println(result);
		
		scanner.close();
	}
}
