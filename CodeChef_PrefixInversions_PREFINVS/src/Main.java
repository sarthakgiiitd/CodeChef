import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * @author Sarthak Goyal
 * 27-May-2017 8:03:34 PM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			String input = br.readLine();
			StringBuilder str = new StringBuilder(input);
			int location = findone(str);
			int count = 0;
			while (location > -1) {
				count++;
				flip(str, location);
				location = findone(str);
			}
			System.out.println(count);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static int findone(StringBuilder input) {
		for (int i = input.length() - 1; i > -1; i--) {
			char val = input.charAt(i);
			if (val == '1') {
				return i;
			}
		}
		return -1;
	}
	
	private static void flip(StringBuilder str, int index) {
		for (int i = 0; i <= index; i++) {
			char val = str.charAt(i);
			if (val == '0') {
				str.setCharAt(i, '1');
			} else {
				str.setCharAt(i, '0');
			}
		}
	}
}