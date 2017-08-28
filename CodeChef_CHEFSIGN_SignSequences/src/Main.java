import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Sarthak Goyal
 * 10-Jul-2017 8:38:13 AM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try {
			Reader.init(System.in);
			int T = Reader.nextInt();
			while (T-- > 0) {
				String input = Reader.nextString();
				char prev = input.charAt(0);
				int maxcount = 1;
				int count = 1;
				if (prev == '=') {
					count = 0;
					maxcount = 0;
				} else {
					count = 1;
					maxcount = 1;
				}
				
				for (int i = 1; i < input.length(); i++) {
					char current = input.charAt(i);
					if (current == '=') {
						current = prev;
					} else {
						if (current == prev) {
							count++;
						} else {
							count = 1;
						}
					}
					if (count > maxcount) {
						maxcount = count;
					}
				prev = current;
				}
				
				int ans = maxcount + 1;
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

