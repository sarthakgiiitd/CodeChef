import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Sarthak Goyal
 * 12-Jul-2017 8:20:07 AM
 * 
 */

public class Main {
	public static void main(String[] args) {
		try{
			Reader.init(System.in);
			int T = Reader.nextInt();
			while (T-- > 0) {
				int N = Reader.nextInt();
				int D = Reader.nextInt();
				int[][] input = new int[N][3];
				for (int i1 = 0; i1 < N; i1++) {
					input[i1][0] = Reader.nextInt();	// Di - day of arrival
					input[i1][1] = Reader.nextInt();	// Ti - no. of lectures wished 
					input[i1][2] = Reader.nextInt();	// Si - sadness level
				}
				
				int[] dayallocation = new int[D];
				for (int i = 0; i < D; i++) {
					int day = i+1;
					boolean[] eligible = new boolean[N];
					
					int maxsadness = -5;
					int id = -1;
					for (int j = 0; j < N; j++) {
						if ((input[j][0] <= day) && (input[j][1] > 0)) {
							eligible[j] = true;
							int sadnes = input[j][2];
							if (sadnes > maxsadness) {
								maxsadness = sadnes;
								id = j;
							}
							
						} 
					}

					dayallocation[i] = id;
					if (id > -1) {
						int prevval = input[id][1]; 
						input[id][1] = prevval - 1;
					}
				}	// for end
				
//				for (int q = 0; q < dayallocation.length; q++) {
//					System.out.print(dayallocation[q] + " ");
//				}
//				System.out.println();
//				
				int finalans = 0;	// contains the required sadness
				for (int s = 0; s < N; s++) {
					int lectleft = input[s][1];
					if (lectleft > 0) {
						int sadvar = input[s][2];
						int ans = sadvar*lectleft;
						finalans = finalans + ans;
					}
				}
				System.out.println(finalans);
			
			} // test case while end
			
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

