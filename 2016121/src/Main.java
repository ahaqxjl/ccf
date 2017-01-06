import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int count = Integer.parseInt(scanner.nextLine());
		
		int[] numbers = new int[count];
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = scanner.nextInt();
		}
		
		int result = -1;
		
		for (int i = 0; i < numbers.length; i++) {
			int gt = 0;
			int lt = 0;
			for (int j = 0; j < numbers.length; j++) {
				if (numbers[i] > numbers[j]) {
					lt++;
				} else if (numbers[i] < numbers[j]) {
					gt++;
				}
			}
			if (lt == gt) {
				result = numbers[i];
				break;
			}
		}
		
		System.out.println(result);
		
		scanner.close();
	}
}
