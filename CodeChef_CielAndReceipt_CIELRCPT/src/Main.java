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
 * 15-Mar-2017 1:33:38 PM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			Reader.init(System.in);
			int T = Reader.nextInt();
			while (T-- > 0) {
				int num = Reader.nextInt();
				int count = 0;
				for (int i = 11; i >= 0; i--) {
					int val = powerfunc(2,i);
					int modulo = num % val;
					if (modulo == num) {
					} else if (modulo == 0) {
						int quotient = num/val;
						count = count + quotient;
						num = 0;
						break;
					} else {
						num = num - val;
						count +=1;
					}
				}
				System.out.println(count);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static int powerfunc (int base, int index) {
		int ans = 1;
		for (int i = 1; i <= index; i++) {
			ans = ans*base;
		}
		return ans;
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
