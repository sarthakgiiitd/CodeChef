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
 * 04-Aug-2017 10:38:19 PM
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
				int[][] array = new int[13][2];
				int count = 0;
				int prev = 0;
				int k = 0;
				for (int i1 = 0; i1< N; i1++) {
					int num = Reader.nextInt();
					input[i1] = num;
					int curr = num;
					if (curr != prev && i1>0) {
						array[k][0] = prev;
						array[k][1] = count;
						count = 1;
						k++;
					} else {
						count++;
					}
				prev = curr;	
				}
				array[k][0] = prev;
				array[k][1] = count;
				
				boolean cond1 = true;
				int prev1 = array[0][0];
				// check if the numbers are not consecutive
				for (int j = 1; j < array.length; j++) {
					int curr = array[j][0];
					if (j <= 6) {
						if (curr == prev1 +1) {
							
						} else {
							cond1 = false;
							break;
						}
					} else {
						if (curr == prev1 - 1) {
							
						} else {
							cond1 = false;
							break;
						}
					}
				prev1 = curr;
				}
				
				// check for any zero ai
				boolean cond2 = true;
				if (cond1) {
					for (int j = 0; j < array.length; j++) {
						int val = array[j][1];
						if (val == 0) {
							cond2 = false;
							break;
						}
					}
				}
			
				boolean cond3 = true;
				if (cond1 && cond2) {
					int z = 12;
					for (int j = 0; j <= 6; j++) {
						int left = array[j][1];
						int right = array[z][1];
						if (left == right) {
							
						} else {
							cond3 = false;
							break;
						}
					z--;
					} 
				}
				
				if (cond1 && cond2 && cond3) {
					System.out.println("yes");
				} else {
					System.out.println("no");
				}
//				for (int i = 0; i < array.length; i++) {
//					System.out.println(array[i][0] + " : " + array[i][1]);
//				}
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
