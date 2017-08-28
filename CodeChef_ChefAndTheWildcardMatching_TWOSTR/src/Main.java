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
 * 23-Feb-2017 2:47:45 PM
 * 
 */
public class Main {
	public static void main(String[] args){
		try{
			Reader.init(System.in);
			int T = Reader.nextInt();
			while(T-- > 0) {
				String X = Reader.nextString();
				String Y = Reader.nextString();
				String ans = "Yes";
				for (int i = 0; i < X.length(); i++){
					char valx = X.charAt(i);
					char valy = Y.charAt(i);
					if ((valx == valy) || (valx == '?') || (valy == '?')){
						ans = "Yes";
					}else {
						ans = "No";
						break;
					}
				}
				System.out.println(ans);
			}
			
			
		}catch(IOException e) {
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



