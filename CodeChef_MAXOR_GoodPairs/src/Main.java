import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Sarthak Goyal
 * 29-Jul-2017 9:52:21 PM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			Reader.init(System.in);
			int T = Reader.nextInt();
			while (T-- > 0) {
				int N = Reader.nextInt();
				int[] input = new int[N];
				for (int i = 0; i < N; i++) {
					int num = Reader.nextInt();
					input[i] = num;
				}
				
				int count = 0;
				for (int i = 0; i < N-1; i++) {
					for (int j = i+1; j < N; j++) {
						int val1 = input[i];
						int val2 = input[j];
						int val = val1 | val2;
						int max = val1;
						if (val2 > max) {
							max = val2;
						}
						if (val <= max) {
							count++;
						}
					}
				}
				System.out.println(count);
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
