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
 * 29-Jul-2017 9:44:20 PM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			Reader.init(System.in);
			int T = Reader.nextInt();
			while(T-- > 0) {
				String input = Reader.nextString();
				String[] inputarray = input.split(" ");
				int N = inputarray.length - 1;
				int max = 0;
				int checkcount = 0;
				for (int i = 0; i < inputarray.length; i++) {
					int val = Integer.parseInt(inputarray[i]);
					if (val > max) {
						if (val == N) {
							checkcount++;
							if (checkcount > 1) {
								max = val;
							}
						} else {
							max = val;
						}
						
				
					}
				}
				
				System.out.println(max);
				
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
