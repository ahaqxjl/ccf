import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int number = scanner.nextInt();
		int result = 0;
		
		int[] taxRate = new int[8];
		int[] step = new int[8];
		int[] afterTaxMax = new int[8];
		
		taxRate[0] = 0;
		taxRate[1] = 3;
		taxRate[2] = 10;
		taxRate[3] = 20;
		taxRate[4] = 25;
		taxRate[5] = 30;
		taxRate[6] = 35;
		taxRate[7] = 45;
		
		int base = 3500;
		step[0] = 0;
		step[1] = 1500;
		step[2]	= 4500;
		step[3]	= 9000;
		step[4] = 35000;
		step[5] = 55000;
		step[6] = 80000;
		
		afterTaxMax[0] = base;
		for (int i = 1; i < 7; i++) {
			afterTaxMax[i] = afterTaxMax[i - 1] + (step[i] - step[i - 1]) * (100 - taxRate[i]) / 100;
		}
		
		result = number;
		for (int i = 6; i >= 0; i--) {
			if (number > afterTaxMax[i]) {
				result = (number - afterTaxMax[i]) * 100 / (100 - taxRate[i + 1]) + step[i] + base;
				break;
			}
		}
		
		System.out.println(result);
		
		scanner.close();
	}
}
