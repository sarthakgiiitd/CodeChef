import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * @author Sarthak Goyal
 * 17-Jun-2017 7:33:02 AM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			Reader.init(System.in);
			int T = Reader.nextInt();
			while (T-- > 0) {
				int p = Reader.nextInt();
				int q = Reader.nextInt();
				int r = Reader.nextInt();
				long mod = 1000000007;
				HashSet<Long> hashA = new HashSet<>();
				for (int i1 = 0; i1 < p; i1++) {
					long num = Reader.nextLong();
					hashA.add(num);
				}
				HashSet<Long> hashB = new HashSet<>();
				for (int i2 = 0; i2 < q; i2++) {
					long num = Reader.nextLong();
					hashB.add(num);
				}
				
				HashSet<Long> hashC = new HashSet<>();
				for (int i3 = 0; i3 < r; i3++) {
					long num = Reader.nextLong();
					hashC.add(num);
				}
				
				// hashsets are used in order to avoid duplicates 
				Long[] Acopy2 = hashA.toArray(new Long[hashA.size()]);
				long[] A = new long[Acopy2.length];
				for (int i = 0; i < Acopy2.length; i++) {
					long val = Acopy2[i].longValue();
					A[i] = val;
				}
				
				
				Long[] Bcopy2 = hashB.toArray(new Long[hashB.size()]);
				long[] B = new long[Bcopy2.length];
				for (int i = 0; i < Bcopy2.length; i++) {
					long val = Bcopy2[i].longValue();
					B[i] = val;
				}
				
				Long[] Ccopy2 = hashC.toArray(new Long[hashC.size()]);
				long[] C = new long[Ccopy2.length];
				for (int i = 0; i < Ccopy2.length; i++) {
					long val = Ccopy2[i].longValue();
					C[i] = val;
				}
				int newp = A.length;
				int newq = B.length;
				int newr = C.length;
				
				Arrays.sort(A);
				Arrays.sort(B);
				Arrays.sort(C);
				long[] sumarrayA = new long[newp];
				long[] sumarrayC = new long[newr];
				
				int m = -1;
				for (int a = 0; a < newp; a++) {
					if (m >= 0) {
						sumarrayA[a] = sumarrayA[m] + A[a];
					} else{
						sumarrayA[a] = A[a];
					}
				m++;
				}
						
				int n = -1;
				for (int c = 0; c < newr; c++) {
					if (n >= 0) {
						sumarrayC[c] = sumarrayC[n] + C[c];
					} else{
						sumarrayC[c] = C[c];
					}
				n++;
				}
				
				long finalans = 0;
				for(int i  = 0; i < newq; i++) {
					long y = B[i];
					int xloc2 = LinearSearch(A,y);
					long xloc = (long) xloc2;
					long brack1 = y*(xloc+1);
					brack1 = brack1 + sumarrayA[xloc2];
					brack1 = (brack1) % mod;
					
					int zloc2 = LinearSearch(C,y);
					long zloc = (long)zloc2;
					long brack2 = y*(zloc+1);
					brack2 = brack2 + sumarrayC[zloc2];
					brack2 = (brack2) % mod;
					long ans = brack1*brack2;
					ans = ans % mod;
					finalans = finalans + ans;
					finalans = finalans % mod;
				}
				finalans = finalans % mod;
				System.out.println(finalans);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void printarray(long[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	private static int LinearSearch(long[] array, long val) {
		for (int i = array.length -1; i > -1; i--) {
			long valarray = array[i];
			if (valarray > val) {
				
			} else {
				return i;
			}
		}
		return -1;
	}
//	
//	private static int BinarySearch (long[] array, long val) {
//		int left = 0;
//		int right = array.length - 1;
//		boolean flag = false;
//		int mid = -1;
//		
//		if(array[left] > val) {
//			return -1;
//		}
//		
//		while (left <= right) {
//			mid = left + (right - left)/2;
//			if (array[mid] == val) {
//				flag = true;
//				break;
//			} else if (array[mid] < val) {
//				left = mid+1;
//			} else {
//				right = mid-1;
//			}
//		}
//		
//		if (flag) {
//			return mid;
//		} else {
//			if (left >= array.length) {
//				return array.length - 1;
//			} else  {
//				return left-1;
//			}
//		}
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
