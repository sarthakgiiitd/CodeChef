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
 * 23-Jul-2017 9:58:01 PM
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
				String[] inputbin = new String[N];
				int max = 0;
				for (int i1 = 0; i1 < N; i1++) {
					int num = Reader.nextInt();
					input[i1] = num;
					inputbin[i1] = Integer.toBinaryString(num);
					if (num > max) {
						max = num;
					}
				}
				
				String maxbin = Integer.toBinaryString(max);
				StringBuilder sb = new StringBuilder(maxbin);
				for (int i = 0; i < maxbin.length(); i++) {
					char val = sb.charAt(i);
					if (val == '0') {
						int index = sb.length() - i - 1;
						for (int j = 0; j < inputbin.length; j++) {
							int newindex = inputbin[j].length() - index - 1;
							char val2 = '0';
							if (newindex >= 0) {
								val2 = inputbin[j].charAt(newindex);
							}
							if (val2 == '1') {
								sb.replace(i, i+1, "1");
								break;
							}
						}
					}
				}
				String ans = sb.toString();
				int finalans = Integer.parseInt(ans, 2);
				System.out.println(finalans);
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
