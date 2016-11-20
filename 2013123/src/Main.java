import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int count = Integer.parseInt(scanner.nextLine());
		
		String[] numbersStr = new String[count];
		numbersStr = scanner.nextLine().split(" ");
		
		int[] numbers = new int[count];
		
		int result = 0;
		
		for (int i = 0; i < count; i++) {
			numbers[i] = Integer.parseInt(numbersStr[i]);
		}
		
		for (int i = 0; i < count; i++) {
			int start = i;
			int end = i;
			int tmpResult = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (numbers[j] >= numbers[i]) {
					start = j;
				} else {
					break;
				}
			}
			for (int k = i + 1; k < count; k++) {
				if (numbers[k] >= numbers[i]) {
					end = k;
				} else {
					break;
				}
			}
			
			tmpResult = (end - start + 1) * numbers[i];
			
			if (tmpResult > result) {
				result = tmpResult;
			}
		}
		
		System.out.println(result);
		
	}
	
}
