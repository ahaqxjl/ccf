import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public class Window {
		int startx = 0;
		int endx = 0;
		int starty = 0;
		int endy = 0;
		int index = 0;
		
		public int getStarty() {
			return starty;
		}

		public int getStartx() {
			return startx;
		}

		public int getEndx() {
			return endx;
		}

		public int getEndy() {
			return endy;
		}

		public int getIndex() {
			return index;
		}
		
		public void setIndex(int index) {
			this.index = index;
		}

		public Window(String[] points, int index) {
			this.startx = Integer.parseInt(points[0]);
			this.starty = Integer.parseInt(points[1]);
			this.endx = Integer.parseInt(points[2]);
			this.endy = Integer.parseInt(points[3]);
			this.index = index;
		}
		
		public boolean includes(String[] point) {
			int x = Integer.parseInt(point[0]);
			int y = Integer.parseInt(point[1]);
			if (x >= startx && y >= starty && x <= endx && y <= endy) {
				return true;
			}
			return false;
		}
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		Scanner scanner = new Scanner(System.in);
		
		int n = 0;
		int m = 0;
		
		String[] nmStr = scanner.nextLine().split(" ");
		n = Integer.parseInt(nmStr[0]);
		m = Integer.parseInt(nmStr[1]);
		
		ArrayList<Window> windows = new ArrayList<Window>(n);
		String[][] mousePoints = new String[m][2];
		
		for (int i = 0; i < n; i++) {
			String[] points = scanner.nextLine().split(" ");
			windows.add(main.new Window(points, i));
		}
		
		for (int i = 0; i < m; i++) {
			mousePoints[i] = scanner.nextLine().split(" ");
		}
		
		for (int i = 0; i < m; i++) {
			int top = 0;
			boolean found = false;
			for (int j = n - 1; j >= 0; j--) {
				Window window = windows.get(j);
				if (window.includes(mousePoints[i])) {
					found = true;
					if (window.getIndex() > windows.get(top).getIndex()) {
						top = j;
					}
				}
			}
			if (!found) {
				System.out.println("IGNORED");
			} else {
				System.out.println(top + 1);
				for (int j = n -1; j >= 0; j--) {
					Window window = windows.get(j);
					if (window.getIndex() > windows.get(top).getIndex()) {
						window.setIndex(window.getIndex() - 1);
					}
				}
				windows.get(top).setIndex(n-1);
			}
			
		}
		
		scanner.close();
	}
}
