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
 * 24-Feb-2017 2:17:40 AM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			Reader.init(System.in);
			int T = Reader.nextInt();
			while (T-- > 0) {
				int length = Reader.nextInt();
				int breadth = Reader.nextInt();
				int min = length;
				int side2 = breadth;
				if (breadth < length){
					min = breadth;
					side2 = length;
				}
				
				int j = min/2;
				int gcd = 1;
				for (int i = j; i > 0; i--) {
					if (side2 % min == 0) {
						gcd = min;
						break;
					} else if ((length % i == 0) && (breadth % i == 0)) {
						gcd = i;
						break;
					}
					
				}
				int ans = ((length*breadth)/(gcd*gcd));
				System.out.println(ans);
					
					
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

