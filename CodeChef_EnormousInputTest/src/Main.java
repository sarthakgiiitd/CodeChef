import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args){
		try{
			Reader.init(System.in);
			int n = Reader.nextInt();
			int k = Reader.nextInt();
			int num = 0;
			int count = 0;
			while (n-- > 0) {
				num = Reader.nextInt();
				if (num %k == 0){
					count = count + 1;
				}
			}
			System.out.print(count);
			
			
			
		}catch(IOException e){
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
	
}



