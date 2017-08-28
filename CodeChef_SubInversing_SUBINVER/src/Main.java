import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * @author Sarthak Goyal
 * 27-May-2017 8:32:50 PM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			Reader.init(System.in);
			int N = Reader.nextInt();
			int U = Reader.nextInt();
			StringBuilder str = new StringBuilder();
			str.setLength(N);
			for(int q = 0; q < N; q++) {
				str.setCharAt(q, '0');
			}
			String string = str.toString();
			int max = Integer.parseInt(string);
			while (U-- > 0) {
				int start = Reader.nextInt();
				int end = Reader.nextInt();
				flip(start, end, str);
				string = str.toString();
				int val = Integer.parseInt(string);
				if (val > max) {
					max = val;
				}
			}
			System.out.println(max);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void flip (int start, int end, StringBuilder str) {
		for (int i = start-1; i < end; i++){
			char val  = str.charAt(i);
			if (val == '0') {
				str.setCharAt(i, '1');
			} else {
				str.setCharAt(i, '0');
			}
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
