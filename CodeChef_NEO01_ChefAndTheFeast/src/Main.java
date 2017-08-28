import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Sarthak Goyal
 * 04-Jun-2017 7:47:49 PM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			Reader.init(System.in);
			int T = Reader.nextInt();
			while (T-- > 0) {
				int N = Reader.nextInt();
				long sum = 0;
				long sumway2 = 0;
				long countnegative = 0;
				long sumnegative = 0;
				long countpositive = 0;
				long sumpositive = 0;
				for (int i1 = 0; i1 < N; i1++) {
					long val = Reader.nextLong();
					if (val < 0) {
						sumnegative = sumnegative + val;
					} else {
						countpositive++;
						sumpositive = sumpositive + val;
					}
					
					sumway2 = sumway2+val;
				}
				sum = sum + sumnegative;
				long sum2 = countpositive*sumpositive;
				sum = sum + sum2;
				sumway2 = sumway2 * N;
				if (sumway2 > sum) {
					sum = sumway2;
				}
				System.out.println(sum);
			}
		} catch (IOException e){
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
