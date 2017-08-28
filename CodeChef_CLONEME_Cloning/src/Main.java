import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

/**
 * @author Sarthak Goyal
 * 07-Jun-2017 5:14:45 AM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			Reader.init(System.in);
			int T = Reader.nextInt();
			while (T-- > 0) {
				int N = Reader.nextInt();
				int Q = Reader.nextInt();
				int[] A = new int[N];
				for (int i1 = 0; i1 < N; i1++) {
					int num = Reader.nextInt();
					A[i1] = num;
				}
				while (Q-- > 0) {
					int a = Reader.nextInt();
					int b = Reader.nextInt();
					int c = Reader.nextInt();
					int d = Reader.nextInt();
					int len = b - a + 1;
					int[] array1 = new int[len];
					int[] array2 = new int[len];
					int p = 0;
					for (int i = a - 1; i < b; i++) {
						int val = A[i];
						array1[p] = val;
					p++;
					}
					int q = 0;
					for (int j = c -1; j < d; j++) {
						int val = A[j];
						array2[q] = val;
					q++;
					}
					Arrays.sort(array1);
					Arrays.sort(array2);
					int count = 0;
					boolean ans = true;
					for (int s = 0; s < array1.length; s++) {
						int val1 = array1[s];
						int val2 = array2[s];
						if (val1 != val2) {
							count++;
						}
						if (count > 1) {
							ans =false;
							break;
						}
					}
					
					if (ans) {
						System.out.println("YES");
					} else {
						System.out.println("NO");
					}
				}
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
