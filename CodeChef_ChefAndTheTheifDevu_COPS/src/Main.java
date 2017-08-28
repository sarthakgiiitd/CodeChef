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
 * 15-Apr-2017 7:42:35 PM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			Reader.init(System.in);
			int T = Reader.nextInt();
			while (T-- > 0) {
				int M = Reader.nextInt();
				int x = Reader.nextInt();
				int y = Reader.nextInt();
				int housecount = x*y;
				int[] copsarray = new int[M];
				for (int i1 = 0; i1 < M; i1++) {
					int num = Reader.nextInt();
					copsarray[i1] = num;
				}
				boolean[] array = new boolean[101];
				for (int i2 = 0; i2 < array.length; i2++) {
					array[i2] = true;
				}
				for (int i = 0; i < copsarray.length; i++) {
					int house = copsarray[i];
					int minhouse = house - housecount;
					int maxhouse = house + housecount;
					if (minhouse < 1) {
						minhouse = 1;
					}
					if (maxhouse > 100) {
						maxhouse = 100;
					}
					for (int j = minhouse; j <= maxhouse; j++) {
						array[j] = false;
					}
				}
				int count = 0;
				for (int k = 1; k < array.length; k++) {
					if (array[k]) {
						count++;
					}
				}
				System.out.println(count);
				
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
