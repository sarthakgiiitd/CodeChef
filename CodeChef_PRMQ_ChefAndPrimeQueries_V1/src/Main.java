import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * @author Sarthak Goyal
 * 07-Jun-2017 9:47:39 AM
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
			int Q = Reader.nextInt();
			while (Q-- > 0) {
				int L = Reader.nextInt();
				int R = Reader.nextInt();
				int X = Reader.nextInt();
				int Y = Reader.nextInt();
//				int m = (int) Math.sqrt(Y);
				int[] primes = findPrime(Y);
				
				HashSet<Integer> hash = new HashSet<>();
				for (int i = 0; i < primes.length; i++) {
					int prime = primes[i];
					if ((prime >= X) && (prime <= Y)) {
						hash.add(prime);
					}
				}
				
				Integer[] array2 = hash.toArray(new Integer[hash.size()]);
				int[] array = new int[array2.length];
				for (int k = 0; k < array2.length; k++) {
					int val = array2[k].intValue();
					array[k] = val;
				}
				
				
				
				
//				System.out.println("primes array : ---------");
//				printArray(primes);
//				boolean[] arraybool = new boolean[Y-X+1];	// scale the index by +X
//				Arrays.fill(arraybool, true);
//				for (int q = 0; q < primes.length; q++) {
//					int prime = primes[q];
//					for (int i=0; i < arraybool.length; i++) {
//						int val = i + X;
//						if (val != prime) {
//							if (val % prime == 0) {
//								arraybool[i] = false;
//							}
//						}
//					}
//				}
//				HashSet<Integer> hashfunc = new HashSet<>();
//				for (int i = 0; i < arraybool.length; i++) {
//					if (arraybool[i]) {
//						int ans = i + X;
//						hashfunc.add(ans);
//					}
//				}
//				
//				Integer[] array2 = hashfunc.toArray(new Integer[hashfunc.size()]);
//				int[] array = new int[array2.length];
//				for (int k = 0; k < array2.length; k++) {
//					int val = array2[k].intValue();
//					array[k] = val;
//				}
//				
				// array contains all the primes between X and Y
//				for (int s =0; s< array.length; s++) {
//					System.out.print(array[s] +" ");
//				}
//				System.out.println();
//				
				int result =0;
				for (int i = 0; i < array.length; i++) {
					int val = array[i];
					for (int j = L-1; j < R; j++) {
						int number = input[j];
						int exponent = 0;
						while (number % val == 0) {
							exponent++;
							number = number/val;
						}
						result = result + exponent;
					}						
				}
				System.out.println(result);
				
			hash.clear();
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static int[] findPrime(int n) {
		boolean[] A = new boolean[n+1];
		Arrays.fill(A, true);	// sets all elements to true
		int m = (int) Math.sqrt(n);
		for (int i = 2; i <= m; i++) {
			if (A[i]) {
				int square = i*i;
				for (int j = square; j < A.length; j = j+i) {
					A[j] = false;
				}
			}
		}
		
		HashSet<Integer> hash = new HashSet<>();
		for (int p = 2; p < A.length; p++) {
			boolean val = A[p];
			if (val) {
				hash.add(p);
//				System.out.print(p + " ");
			}
		}
		
		Integer[] array2 = hash.toArray(new Integer[hash.size()]);
		int[] array = new int[array2.length];
		for (int i = 0; i < array2.length; i++) {
			int val = array2[i].intValue();
			array[i] = val;
		}
		
		return array;
	}
	
	private static void printArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
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
