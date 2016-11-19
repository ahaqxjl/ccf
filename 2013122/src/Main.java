import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String result;
		String RIGHT = "Right";
		
		String originalISBN = scanner.nextLine();
		
		int sum = 0;
		int numberCount = 1;
		int length = originalISBN.length();
		for (int i=0; i < length -1; i++) {
			String num = String.valueOf(originalISBN.charAt(i));
			if (!"-".equals(num)) {
				sum += (numberCount) * Integer.parseInt(num);
				numberCount ++;
			}
		}
		String lastChar = String.valueOf(originalISBN.charAt(length - 1));
		int identifier = sum % 11;
		if (identifier == 10) {
			if ("X".equals(lastChar)) {
				result = RIGHT;
			} else {
				result = originalISBN.substring(0, originalISBN.length() - 1) + "X";
			}
		} else if (lastChar.equals(String.valueOf(identifier))) {
			result = RIGHT;
		} else {
			result = originalISBN.substring(0, originalISBN.length() - 1) + String.valueOf(identifier);
		}
		
		System.out.println(result);
		
	}
}
