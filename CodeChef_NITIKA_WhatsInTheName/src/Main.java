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
 * 08-Jul-2017 7:14:46 PM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			Reader.init(System.in);
			int T = Reader.nextInt();
			while (T-- > 0) {
				String input = Reader.nextString();
				boolean whiteSpace = input.contains(" ");
				String ans = "";
				if (whiteSpace) {
					String[] stringarray = input.split(" ");
					int len = stringarray.length;
					String last1 = stringarray[len - 1];
					String last2 = last1.substring(0, 1).toUpperCase();
					String last3 = last1.substring(1, last1.length()).toLowerCase();
					String last = last2 + last3;
					
					if (len == 3) {
						String mid = stringarray[1];
						String first = stringarray[0];
						mid = mid.substring(0, 1).toUpperCase() + ".";
						first = first.substring(0, 1).toUpperCase()  + ".";
						ans = first + " " + mid + " " + last;
					} else if (len == 2) {
						String first = stringarray[0];
						first = first.substring(0,1).toUpperCase() + ".";
						ans = first + " " + last;
					}
					
				} else {
					String ans1 = input.substring(0,1).toUpperCase();
					String ans2 = input.substring(1,input.length()).toLowerCase();
					ans = ans1 + ans2;
				}
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

