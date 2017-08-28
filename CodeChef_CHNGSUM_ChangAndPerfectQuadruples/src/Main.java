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
 * 23-Jul-2017 10:23:58 PM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			Reader.init(System.in);
			int N = Reader.nextInt();
			int[] input = new int[N];
			for (int i1 = 0; i1 < N; i1++) {
				int num = Reader.nextInt();
				input[i1] = num;
			}
			int max = Integer.MIN_VALUE;
			int prevmax = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			int prevmin = Integer.MAX_VALUE;
			long finalans = 0;
			for (int i = 0; i < N-1; i++) {
				for (int j = i; j < N-1; j++) {
					if (j == i) {
						max = input[i];
					} else {
						if (input[j] > prevmax) {
							max = input[j];
						} else {
							max = prevmax;
						}
					}
					
					
					for (int k = j+1; k < N; k++) {
						for (int l = k; l < N; l++) {
							if (k == l) {
								min = input[k];
							} else {
								if (input[l] < prevmin) {
									min = input[l];
								} else {
									min = prevmin;
								}
							}
						//	System.out.println("i: " + i + " j: " + j + " k: " + k + " l: " + l); 
							long ans = min*max;
							ans = ans% (1000000007);
							finalans = finalans + ans;
							
						prevmin = min;	
						} //  l
					}// k
					
					prevmax = max;
				}// j
			}// i
			finalans = finalans % (1000000007);
			System.out.println(finalans);
			
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
