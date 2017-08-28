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
 * 19-Feb-2017 11:11:56 PM
 * 
 */
public class Main {
	public static void main(String[] args) {
		
		try{
			Reader.init(System.in);
			int N = Reader.nextInt();
			int tmpN = N;
			int tmpN2 = N;
			int[] player1 = new int[N];
			int[] player2 = new int[N];
			int i = 0;
			while (tmpN-- > 0) {
				int val1 = Reader.nextInt();
				int val2 = Reader.nextInt();
				player1[i] = val1;
				player2[i] = val2;
			i++;	
			}
			
			int[] lead = new int[tmpN2];
			lead[0] = player1[0] - player2[0];
			int j = 1;
			while (tmpN2-- > 1) {
				lead[j] = lead[j-1] + (player1[j] - player2[j]);
			j++;
			}
			int max = maxfunc(lead);
			int min = minfunc(lead);
			int winner = 0;
			int absmin = min*(-1);
			if (max > absmin) {
				winner = 1;
				System.out.print(winner);
				System.out.print(" ");
				System.out.print(max);
				
			} else if (max < absmin) {
				winner = 2;
				System.out.print(winner);
				System.out.print(" ");
				System.out.print(absmin);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private static int minfunc(int[] array) {
		int l = array.length;
		int min = array[0];
		int i = 0;
		while (l-- > 0) {
			int data = array[i];
			if (data < min) {
				min = data;
			}
		i++;
		}
		return min;
	}
	
	private static int maxfunc(int[] array) {
		int l = array.length;
		int max = array[0];
		int i = 0;
		while (l-- > 0) {
			int data = array[i];
			if (data > max) {
				max = data;
			}
		i++;
		}
		return max;
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
