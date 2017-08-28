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
 * 04-Mar-2017 1:54:23 PM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			Reader.init(System.in);
			int T = Reader.nextInt();
			while(T-- > 0) {
				int N = Reader.nextInt();	//No. of tasks to be completed
				int Ncopy2 = N;
				int Ncopy = N;
				int i1 = 0;
				int[] Xtime = new int[N];
				int[] Ytime = new int[N];
				while(Ncopy2-- > 0) {
					int time = Reader.nextInt();
					Xtime[i1] = time;
				i1++;
				}
				
				int j1 = 0;
				while(Ncopy -- > 0) {
					int time = Reader.nextInt();
					Ytime[j1] = time;
				j1++;
				}
				
				//odd sum
				int Xodd = 0;
				int Yodd = 0;
				for(int i = 0; i < N; i = i+2) {
					int Xval = Xtime[i];
					int Yval = Ytime[i];
					Xodd = Xodd + Xval;
					Yodd = Yodd + Yval;
				}
				//even sum
				int Xeven = 0;
				int Yeven = 0;
				for (int j = 1; j < N; j=j+2) {
					int Xval = Xtime[j];
					int Yval = Ytime[j];
					Xeven = Xeven + Xval;
					Yeven = Yeven + Yval;
				}
				
				int val1 = Xodd + Yeven;
				int val2 = Xeven + Yodd;
				int min = val1;
				if (val2 < val1) {
					min = val2;
				}
				System.out.println(min);
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
