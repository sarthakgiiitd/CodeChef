import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 */

/**
 * @author Sarthak Goyal
 * 11-Apr-2017 9:57:27 PM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			 Reader.init(System.in);
			 int T = Reader.nextInt();
			 while (T-- > 0) {
				 String num = Reader.nextString();
				 int val0 = 0;
				 int val1 = 0;
				 for (int i = 0; i < num.length(); i++) {
					 char digit = num.charAt(i);
					 int digit1 = Character.getNumericValue(digit);
					 if (digit1 == 0) {
						 val0++;
					 } else {
						 val1++;
					 }
				 }
				 
				 if ((val0 == 1) || (val1 == 1)) {
					 System.out.println("Yes");
				 } else {
					 System.out.println("No");
				 }
				 
			 }
			
		} catch (IOException e) {
			e.printStackTrace();
		}
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
