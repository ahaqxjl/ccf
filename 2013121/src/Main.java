import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int count = Integer.parseInt(scanner.nextLine());
		int[] numbers = new int[count];
		
		String numbersStr = scanner.nextLine();
		
		String[] numbersArray = numbersStr.split(" ");
		
		for(int i = 0; i < numbersArray.length; i++) {
			numbers[i] = Integer.parseInt(numbersArray[i]);
		}
		
		int result = numbers[0];
		int maxOccurenceFreq = 1;
		
		for(int i = 0; i < count; i++){
			int tmpResult = numbers[i];
			int tmpMaxFreq = 1;
			for(int j=i + 1; j < count; j++){
				if (numbers[i] == numbers[j]) {
					tmpMaxFreq ++;
				}
			}
			if (tmpMaxFreq > maxOccurenceFreq) {
				maxOccurenceFreq = tmpMaxFreq;
				result = tmpResult;
			} else if (tmpMaxFreq == maxOccurenceFreq && tmpResult < result) {
				result = tmpResult;
			}
		}
		
		System.out.println(result);
		scanner.close();
	}
}
