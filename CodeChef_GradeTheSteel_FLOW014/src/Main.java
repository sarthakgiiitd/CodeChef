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
 * 15-Mar-2017 11:13:42 AM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			Reader.init(System.in);
			int T = Reader.nextInt();
			while (T-- > 0) {
				int hardness = Reader.nextInt();
				double carbon = Reader.nextDouble();
				int tensile = Reader.nextInt();
				boolean cond1 = (hardness > 50);
				boolean cond2 = (carbon < 0.7);
				boolean cond3 = (tensile > 5600);
				int grade = 5;
				if (cond1 && cond2 && cond3) {
					grade = 10;
				} else if ((cond1 && cond2) && (cond3 == false)) {
					grade = 9;
				} else if ((cond2 && cond3) && (cond1 == false)) {
					grade = 8;
				} else if ((cond1 && cond3) && (cond2 == false)) {
					grade = 7;
				} else if ((cond1) && ((cond2 == false) && (cond3 == false))){
					grade = 6;
				} else if ((cond2) && ((cond1 == false) && (cond3 == false))){
					grade = 6;
				} else if ((cond3) && ((cond1 == false) && (cond2 == false))){
					grade = 6;
				} else {
					grade = 5;
				}
				System.out.println(grade);
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
