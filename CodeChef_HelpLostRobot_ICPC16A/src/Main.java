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
 * 30-Apr-2017 9:20:50 PM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			Reader.init(System.in);
			int T = Reader.nextInt();
			while(T-- > 0) {
				int x1 = Reader.nextInt();	//current
				int y1 = Reader.nextInt();	//current
				int x2 = Reader.nextInt();	//home
				int y2 = Reader.nextInt();	//home
				
				String ans = "";
				if ((x2 > x1) && (y2 == y1)){
					ans = "right";
				} else if((x2 == x1) && (y2 > y1)) {
					ans = "up";
				} else if ((x2 < x1) && (y2 == y1)) {
					ans = "left";
				} else if ((x2 == x1) && (y2 < y1)) {
					ans = "down";
				} else {
					ans = "sad";
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
