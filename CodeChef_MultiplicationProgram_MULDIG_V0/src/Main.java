import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Sarthak Goyal
 * 16-Jul-2017 8:26:50 AM
 * 
 */

public class Main {
	public static void main(String[] args) {
		try{
			Reader.init(System.in);
			System.out.print("Enter the base B : ");
			int B = Reader.nextInt();
			System.out.println(B);
			String[] array1 = new String[B*B];	// array storing all possible two digit numbers
			int k = 0;
			for (int i  = 0; i < B; i++) {
				for (int j = 0; j < B; j++) {
					String num = Integer.toString(i) + Integer.toString(j);
					array1[k] = num;
					k++;
				}
				k--;
			}
			
			
			for (int q = 0; q < array1.length; q++) {
				System.out.print(array1[q] + " ");
			}
			System.out.println();
			
			for (int i = 0; i < array1.length; i++) {
				for (int j = i; j < array1.length; j++) {
					String num1 = array1[i];
					String num2 = array1[j];
					int no1 = ((Character.getNumericValue(num1.charAt(0))) * B) + (Character.getNumericValue(num1.charAt(1))*1);
					int no2 = ((Character.getNumericValue(num2.charAt(0))) * B) + (Character.getNumericValue(num2.charAt(1))*1);
					int ans = no1*no2;
					String baseBans = convert(ans, B);
					String newans = ("0000" + baseBans).substring(baseBans.length());
					System.out.println(num1 + " x " + num2 +  " --> " + newans);
					System.out.println(no1 + " x " + no2 + " --> " + ans);
					System.out.println();
				}
			}
	
		} catch (IOException e) {
			
		}
	}
	
	private static String convert(int val, int base) {
		return Long.toString(val, base);
	}
}


//Class for buffered reader reading int and double values.
class Reader {
	static BufferedReader reader;
	static StringTokenizer tokenizer;
	
	/** call this method to initialize reader for InputStream */
	static void init(InputStream input) {
		reader = new BufferedReader(
					new InputStreamReader(input) );
		tokenizer = new StringTokenizer("");
	}
	
	/** get next word */
	static String next() throws IOException {
		while ( ! tokenizer.hasMoreTokens() ) {
			//TODO and check for eof if necessary
			tokenizer = new StringTokenizer(
					reader.readLine() );
		}
		return tokenizer.nextToken();
	}
	
	static int nextInt() throws IOException {
		return Integer.parseInt( next() );
	}
	
	static double nextDouble() throws IOException {
		return Double.parseDouble(next() );
	}
	static String nextString() throws IOException {
		return reader.readLine();
	}
	
	static long nextLong() throws IOException {
		return Long.parseLong( next() );
	}
	
	static String[] nextStringarray() throws IOException {
		return reader.readLine().split(" ");
	}
}
