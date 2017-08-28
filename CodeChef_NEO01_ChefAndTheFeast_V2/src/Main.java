import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

/**
 * @author Sarthak Goyal
 * 06-Jun-2017 11:07:25 AM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			Reader.init(System.in);
			int T = Reader.nextInt();
			while (T-- > 0) {
				int N = Reader.nextInt();
				long[] input = new long[N];
				int countnegative = 0;
				long sumpositive = 0;
				int countpositive = 0;
				long ans = 0;
				for(int i1 = 0; i1 < N; i1++) {
					long num = Reader.nextInt();
					input[i1] = num;
					if (num < 0) {
						countnegative++;
					} else {
						countpositive++;
						sumpositive = sumpositive + num;
					}
				}
				ans = ans + sumpositive*countpositive;
				long[] negative = new long[countnegative];
				int q = 0;
				for(int i2= 0; i2 < N; i2++) {
					long num = input[i2];
					if (num < 0) {
						negative[q] = num;
						q++;
					}
				}
				Arrays.sort(negative);
				long sum = sumpositive;
				long count= countpositive;
				
				int p = -1;
				for (int i = negative.length - 1; i > -1; i--) {
					long val = negative[i];
					long way1 = ans + val;
					long way2 = (sum +val)*(count+1);
					if (way2 > way1) {
						sum = sum+val;
						count++;
						ans = way2;
					} else {
						p = i;
						break;
					}
					
				}
				
				while (p > -1) {
					long val = negative[p];
					ans = ans+val;
				p--;
				}
				System.out.println(ans);
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
