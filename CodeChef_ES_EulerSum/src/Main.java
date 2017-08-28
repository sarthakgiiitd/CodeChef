import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * @author Sarthak Goyal
 * 02-Jun-2017 9:01:09 PM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			int n = Integer.parseInt(br.readLine());
			//System.out.println(Math.E);
			BigInteger sum = BigInteger.valueOf(0);
			for(int i = 1; i <= n; i++) {
				double val = Math.E;
				double val2 = val*i;
				int val3 = (int)val2;
				BigInteger val4 = BigInteger.valueOf(val3);
			}
			System.out.println(sum);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
