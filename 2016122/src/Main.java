import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int number = scanner.nextInt();
		int result = 0;
		
		int[] tax = new int[8];
		int[] base = new int[8];
		int[] top = new int[8];
		int[] afterTax = new int[8];
		
		tax[0] = 0;
		tax[1] = 3;
		tax[2] = 10;
		tax[3] = 20;
		tax[4] = 25;
		tax[5] = 30;
		tax[6] = 35;
		tax[7] = 45;
		
		top[0] = 3500;
		top[1] = 1500;
		top[2] = 4500 - 1500;
		top[3] = 9000 - 4500;
		top[4] = 35000 - 9000;
		top[5] = 55000 - 35000;
		top[6] = 80000 - 55000;
		top[7] = 1000000 - 8000;
		
		afterTax[0] = top[0];
		afterTax[1] = afterTax[0] + top[1] * (100 - tax[1]) / 100;
		afterTax[2] = afterTax[1] + top[2] * (100 - tax[2]) / 100;
		afterTax[3] = afterTax[2] + top[3] * (100 - tax[3]) / 100;
		afterTax[4] = afterTax[3] + top[4] * (100 - tax[4]) / 100;
		afterTax[5] = afterTax[4] + top[5] * (100 - tax[5]) / 100;
		afterTax[6] = afterTax[5] + top[6] * (100 - tax[6]) / 100;
		afterTax[7] = afterTax[6] + top[7] * (100 - tax[7]) / 100;
		
		if (number > afterTax[6]) {
			result = (number - afterTax[6]) * 100 / (100 - tax[7]) + 3500 + 80000;
		} else if (number > afterTax[5]) {
			result = (number - afterTax[5]) * 100 / (100 - tax[6]) + 3500 + 55000;
		} else if (number > afterTax[4]) {
			result = (number - afterTax[4]) * 100 / (100 - tax[5]) + 3500 + 35000;
		} else if (number > afterTax[3]) {
			result = (number - afterTax[3]) * 100 / (100 - tax[4]) + 3500 + 9000;
		} else if (number > afterTax[2]) {
			result = (number - afterTax[2]) * 100 / (100 - tax[3]) + 3500 + 4500;
		} else if (number > afterTax[1]) {
			result = (number - afterTax[1]) * 100 / (100 - tax[2]) + 3500 + 1500;
		} else if (number > afterTax[0]) {
			result = (number - afterTax[0]) * 100 / (100 - tax[1]) + 3500 + 0;
		} else {
			result = number;
		}
		
		System.out.println(result);
		
		scanner.close();
	}
}
