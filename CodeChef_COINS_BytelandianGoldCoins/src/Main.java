import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
/**
 * @author Sarthak Goyal
 * 04-Jun-2017 9:13:55 PM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			while (br.readLine() != null) {
				int n = Integer.parseInt(br.readLine());
				int original = n;
				int val1 = n/2;
				val1 = val1 + n/3;
				val1 = val1 + n/4;
				if (val1 > original) {
					System.out.println(val1);
				} else {
					System.out.println(original);
				}	
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
