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
 * 29-Apr-2017 7:14:24 PM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			Reader.init(System.in);
			while (true) {
			int n = Reader.nextInt();
			if (n > 0) {
				int[] array = new int[n+1];
				for (int i = 1; i < n+1; i++) {
					int num = Reader.nextInt();
					array[i] = num;
				}
				int[] newarray = new int[n+1];
				for (int i = 1; i < array.length; i++) {
					int val = array[i];
					newarray[val] = i;
				}
				
				boolean ambiguos = true;
				for (int i = 1; i < array.length; i++) {
					if (array[i] != newarray[i]) {
						ambiguos = false;
						break;
					}
				}
				if (ambiguos) {
					System.out.println("ambiguous");
				} else {
					System.out.println("not ambiguous");
				}
			} else {
				break;
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
