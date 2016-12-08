import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static class CommandArg {
		char argName;
		boolean hasValue;
		String value;
		
		public CommandArg(char argName, boolean hasValue) {
			this.argName = argName;
			this.hasValue = hasValue;
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String argsStr = scanner.nextLine();
//		String argsStr = "a:lbw:x";
		ArrayList<CommandArg> commandArgs = new ArrayList<CommandArg>();
		
		for (int i = 0; i < argsStr.length(); i++) {
			char ch = argsStr.charAt(i);
			if (i < argsStr.length() - 1 && ':' == (argsStr.charAt(i + 1))) {
				commandArgs.add(new CommandArg(ch, true));
				i++;
			} else {
				commandArgs.add(new CommandArg(ch, false));
			}
		}
		
		int count = Integer.parseInt(scanner.nextLine());
//		int count = 4;
		
		String[] commands = new String[count];
		
		for (int i = 0; i < count; i++) {
			commands[i] = scanner.nextLine();
		}
//		commands[0] = "ls -a -l -a documents -b";
//		commands[1] = "ls";
//		commands[2] = "ls -w 10 -x -w 15";
//		commands[3] = "ls -a -b -c -d -e -l";
		
		for (int i = 0; i < count; i++) {
			ArrayList<CommandArg> currentArgs = new ArrayList<CommandArg>();
			String command = commands[i];
			String[] elements = command.split(" ");
			int len = elements.length;
			String result = "Case " + (i + 1) + ":";
			if (len > 1) {
				for (int j = 1; j < len; j++) {
					boolean found = false;
					if (elements[j].startsWith("-") && elements[j].length() == 2) {
						char arg = elements[j].charAt(1);
						if (arg - 'a' < 0 || arg - 'a' > 25) {
							break;
						}
						for (int k = 0; k < commandArgs.size(); k++) {
							if (arg == commandArgs.get(k).argName) {
								if (commandArgs.get(k).hasValue) {
									if (j < len - 1) {
										found = true;
										CommandArg currentArg = new CommandArg(arg, true);
										currentArg.value = elements[j + 1];
										currentArgs.add(currentArg);
										j++;
									} else {
										break;
									}
								} else{
									found = true;
									currentArgs.add(new CommandArg(arg, false));
									break;
								}
							}
						}						
					}
					
					if (!found) {
						break;
					}
				}
				if (!currentArgs.isEmpty()) {
					Collections.sort(currentArgs, new Comparator<CommandArg>() {

						@Override
						public int compare(CommandArg o1, CommandArg o2) {
							return String.valueOf(o1.argName).compareTo(String.valueOf(o2.argName));
						}
					});
					
					for (CommandArg arg : currentArgs) {
						if (result.contains("-" + arg.argName)) {
							if (arg.hasValue) {
								result = result.substring(0, result.lastIndexOf(" ") + 1).concat(arg.value);
							}
						} else {
							result += " -" + arg.argName;
							if (arg.hasValue) {
								result += " " + arg.value;
							}
						}
					}
				}
			}
			System.out.println(result.trim());
		}
		
		scanner.close();
	}
}
