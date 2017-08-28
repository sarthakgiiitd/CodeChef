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
 * 05-May-2017 4:39:19 PM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			Reader.init(System.in);
			int T = Reader.nextInt();
			while (T-- > 0) {
				String input = Reader.nextString();
				int len = input.length();
				int tmpE = -10;
				int tmpS = -10;
				boolean finalans = true;
				for(int i = 0; i < len; i++) {
					char val = input.charAt(i);
					if (val == 'E') {
						tmpE = i;
						if (tmpS >= 0) {
							if (i > tmpS) {
								finalans = false;
								break;
							}
						}
					} else if (val == 'S') {
						tmpS = i;
					} else if (val == 'C') {
						if ((tmpE >= 0) || (tmpS >= 0)) {
							if ((i > tmpE) || (i > tmpS)) {
								finalans = false;
								break;
							}
						} 
						
					}
				}
				if (finalans) {
					System.out.println("yes");
				} else {
					System.out.println("no");
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

