import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/**
 * @author Sarthak Goyal
 * 21-May-2017 9:51:35 PM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			int R = Integer.parseInt(br.readLine());
			while (R-- > 0) {
				int len = Integer.parseInt(br.readLine());
				String input = br.readLine();
				int count = 0;		//+1 for heads, -1 for tails
				boolean valid = true;
				for (int i = 0; i < input.length(); i++) {
					char val = input.charAt(i);
					if (val == 'H') {
						count++;
					} else if (val == 'T') {
						count = count - 1;
					}
					
					if (i < input.length() - 1) {
						if ((count == 0) || (count == 1)) {
							
						} else {
							valid = false;
							break;
						}
					} else {
						if (count != 0) {
							valid = false;
							break;
						}
					}
				} // for
				if (valid) {
					System.out.println("Valid"); 
					
				} else {
					System.out.println("Invalid");
				}
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
