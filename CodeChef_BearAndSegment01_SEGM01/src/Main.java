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
 * 29-Apr-2017 7:38:17 PM
 * 
 */
public class Main {
	public static void main(String[] args){
		try{
			Reader.init(System.in);
			int T = Reader.nextInt();
			while (T-- > 0) {
				String input = Reader.nextString();
				int onecount = 0;
				for (int i = 0; i < input.length(); i++) {
					char value = input.charAt(i);
					int val = Character.getNumericValue(value);
					if (val == 1) {
						onecount++;
					}
				}
				
				int newcount = 0;
				int j = -1;
				for (int i = 0; i < input.length(); i++) {
					char value = input.charAt(i);
					int val = Character.getNumericValue(value);
					if (val == 1) {
						if (j == -1) {
							newcount++;
							j = i;
						} else if (i == j + 1){
							newcount++;
							j++;
						} else {
							break;
						}
					}
				}
				
				if ((newcount == onecount) && (onecount > 0)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
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
