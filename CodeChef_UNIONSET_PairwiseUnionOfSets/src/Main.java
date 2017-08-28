import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashSet;

/**
 * @author Sarthak Goyal
 * 04-Jun-2017 6:45:40 PM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			Reader.init(System.in);
			int T = Reader.nextInt();
			while (T-- > 0) {
				int N = Reader.nextInt();
				int K = Reader.nextInt();
				int[][] array = new int[N][];
				HashSet<Integer> hashfunc = new HashSet<>();
				for (int k = 0; k < N; k++) {
					int len = Reader.nextInt();
					for (int j = 0; j < len; j++) {
						int val = Reader.nextInt();
						hashfunc.add(val);
					}
					Integer[] array2 = hashfunc.toArray(new Integer[hashfunc.size()]);
					int[] array2int= new int[array2.length];
					for (int p = 0; p < array2.length; p++) {
						int val = array2[p].intValue();
						array2int[p] = val;
					}
					array[k] = array2int;	
				hashfunc.clear();
				}
				HashSet<Integer> hashcheck = new HashSet<>();
				for (int q = 1; q <= K; q++) {
					hashcheck.add(q);
				}
				int count = 0;
				for (int i = 0; i < N; i++) {
					int[] arrayi = array[i];
					HashSet<Integer> hash1 = new HashSet<>();
					for (int z = 0; z < arrayi.length; z++) {
						hash1.add(arrayi[z]);
					}
					boolean ans2 = hash1.containsAll(hashcheck);
					if (ans2) {
						count = count + N - i - 1;
					} else {
						for (int j = i+1; j < N; j++) {
							int[] arrayj = array[j]; 
							HashSet<Integer> hashcomb = new HashSet<>();
							hashcomb.addAll(hash1);
							for (int h = 0; h < arrayj.length; h++) {
								hashcomb.add(arrayj[h]);
							}
							boolean ans = hashcomb.containsAll(hashcheck);
							if (ans) {
								count++;
							}
						}
					}
				hash1.clear();
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
