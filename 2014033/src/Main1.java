import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Main1 main = new Main1();
		
		Scanner scanner = new Scanner(System.in);
		
		char[] commandArgs = scanner.nextLine().toCharArray();
//		char[] commandArgs = "a:lbw:x".toCharArray();
		int commandLength = Integer.parseInt(scanner.nextLine());
//		int commandLength = 4;
		String[] commands = new String[commandLength];
		
		for (int i = 0; i < commandLength; i++) {
			commands[i] = scanner.nextLine();
		}
		
//		commands[0] = "ls -a -l -a documents -b";
//		commands[1] = "ls";
//		commands[2] = "ls -w 10 -x -w 15";
//		commands[3] = "ls -a -b -c -d -e -l";
		
		CommandArg[] commandArgsList = new CommandArg[26];
		
		for (int i = 0; i < 26; i++) {
			commandArgsList[i] = main.new CommandArg();
		}
		
		for (int i = 0; i < commandArgs.length; i++) {
			char arg = commandArgs[i];
			if (commandArgs[i] != ':') {
				commandArgsList[arg - 'a'].isAppear = true;
			} else {
				commandArgsList[commandArgs[i - 1] - 'a'].hasValue = true;
			}
		}
		
		for (int i = 0; i < commandLength; i++) {
			boolean[] isAppear = new boolean[26];
			boolean[] hasValue = new boolean[26];
			String[] values = new String[26];
			String result = "Case " + String.valueOf(i + 1) + ":";
			
			String[] command = commands[i].split(" ");
			
			if (command.length > 1) {
				for (int j = 1; j < command.length; j++) {
					if (command[j].length() != 2
							|| !command[j].startsWith("-")
							|| command[j].charAt(1) - 'a' < 0
							|| command[j].charAt(1) - 'a' > 25
							|| !commandArgsList[command[j].charAt(1) - 'a'].isAppear) {
						break;
					}
					char arg = command[j].charAt(1);
					CommandArg commandArg = commandArgsList[arg - 'a'];
					
					if (commandArg.hasValue && j < command.length - 1) {
						isAppear[arg - 'a'] = true;
						hasValue[arg - 'a'] = true;
						values[arg - 'a'] = command[++j];
					} else if (!commandArg.hasValue && (j == command.length - 1 || command[j + 1].startsWith("-"))) {
						isAppear[arg - 'a'] = true;
					} else {
						break;
					}
				}
				
				for (int j = 0; j < 26; j++) {
					if (isAppear[j]) {
						result += " -" + (char)('a' + j);
						if (hasValue[j]) {
							result += " " + values[j];
						}
					}
				}
			} else {
				result += " ";
			}
			
			System.out.println(result);
		}
		
		scanner.close();
	}
	
	public class CommandArg {
		boolean isAppear;
		boolean hasValue;
		
		public CommandArg() {
			this.isAppear = false;
			this.hasValue = false;
		}
	}
}
