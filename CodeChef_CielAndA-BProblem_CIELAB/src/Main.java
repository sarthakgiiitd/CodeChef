import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Sarthak Goyal
 * 19-May-2017 12:14:16 AM
 * 
 */
public class Main {
	public static void main (String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String inputtmp = br.readLine();
		String[] input = inputtmp.split(" ");
		int A = Integer.parseInt(input[0]);
		int B = Integer.parseInt(input[1]);
		int ans = A-B;
		int lastdigit = ans%10;
		if (lastdigit == 9) {
			ans = ans-1;
		} else {
			ans = ans+1;
		}
		System.out.println(ans);
	}
}
