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
 * 30-Apr-2017 2:42:14 PM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			Reader.init(System.in);
			int T = Reader.nextInt();
			while(T-- > 0) {
				int A = Reader.nextInt();   //f(1)
				int B = Reader.nextInt();	//f(2)
				int N = Reader.nextInt();
				int newnum = N%6;
				int ans = 0;
				switch(newnum) {
				case 0 : ans = -(B-A);	break;
				case 1 : ans = A;	break;
				case 2 : ans = B;	break;
				case 3 : ans = B-A;	break;
				case 4 : ans = -A;	break;
				case 5 : ans = -B;	break;
				}
				int divider = powerfunc(10, 9) + 7;
				ans = ans % divider;
				if (ans < 0) {
					ans = ans + divider;
				}
				System.out.println(ans);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static int powerfunc(int base, int index) {
		int ans = 1;
		for(int i = 0; i < index; i++) {
			ans = ans*base;
		}
		return ans;
	}
	
	// no use of recursive function
//	private static int function(int n, int A, int B) {
//		if (n == 1) {
//			return A;
//		} else if (n == 2) {
//			return B;
//		}
//		return function(n-1, A, B) - function(n-2, A, B);
//	}
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
