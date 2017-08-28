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
 * 11-Apr-2017 9:45:01 PM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			Reader.init(System.in);
			int T = Reader.nextInt();
			while (T-- > 0) {
				int n = Reader.nextInt();
				String[] input = Reader.nextStringarray();
				int max = Integer.parseInt(input[0]);
				for (int i = 1; i < input.length; i++) {
					int data = Integer.parseInt(input[i]);
					if (data > max) {
						max = data;
					}
				}
				int[] counterarray = new int[max+1];
				for (int j = 0; j < input.length; j++) {
					int data = Integer.parseInt(input[j]);
					counterarray[data] = counterarray[data] + 1;
				}
				
				int ans = 0;
				for (int z = 0; z < counterarray.length; z++) {
					int value = counterarray[z];
					if (value > 0) {
						ans++;
					}
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

