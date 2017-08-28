import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 
 */

/**
 * @author Sarthak Goyal
 * 10-Jun-2017 10:26:53 AM
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
				long[] A = new long[p];
				long[] B = new long[q];
				long[] C = new long[r];
				long mod = 1000000007;
				HashSet<Long> hashA = new HashSet<>();
				for (int i1 = 0; i1 < p; i1++) {
					long num = Reader.nextLong();
					A[i1] = num;
					hashA.add(num);
				}
				HashSet<Long> hashB = new HashSet<>();
				for (int i2 = 0; i2 < q; i2++) {
					long num = Reader.nextLong();
					B[i2] = num;
					hashB.add(num);
				}
				
				HashSet<Long> hashC = new HashSet<>();
				for (int i3 = 0; i3 < r; i3++) {
					long num = Reader.nextLong();
					C[i3] = num;
					hashC.add(num);
				}
				
				// hashsets are used in order to avoid duplicates 
				Long[] Acopy2 = hashA.toArray(new Long[hashA.size()]);
				long[] Acopy = new long[Acopy2.length];
				for (int i = 0; i < Acopy2.length; i++) {
					long val = Acopy2[i].longValue();
					Acopy[i] = val;
				}
				
				
				Long[] Bcopy2 = hashB.toArray(new Long[hashB.size()]);
				long[] Bcopy = new long[Bcopy2.length];
				for (int i = 0; i < Bcopy2.length; i++) {
					long val = Bcopy2[i].longValue();
					Bcopy[i] = val;
				}
				
				Long[] Ccopy2 = hashC.toArray(new Long[hashC.size()]);
				long[] Ccopy = new long[Ccopy2.length];
				for (int i = 0; i < Ccopy2.length; i++) {
					long val = Ccopy2[i].longValue();
					Ccopy[i] = val;
				}
				
				Arrays.sort(B);
				Arrays.sort(A);
				Arrays.sort(C);
				int alen = p;
				int clen = r;
				int alenprev = 0;
				int clenprev = 0;
				long sumAprev = 0;
				long sumCprev = 0;
				long brack1prev = 0;
				long brack2prev = 0;
				long finalans = 0;
				long ans = 0;
				long yprev = 0;
				for (int i = 0; i < q; i++) {
					System.out.println("next--------------------");
					long y = B[i];
					if (i > 0) {
						System.out.println("hello");
						long d = y - yprev;
						brack1prev = brack1prev + d*alenprev;
						brack2prev = brack2prev + d*clenprev;
						long expression = (d*d) % mod + ((sumAprev*clenprev + sumCprev*alenprev)*d) % mod + (2*d*yprev) % mod;
						expression = expression % mod;
						System.out.println("expression : " + expression);
						System.out.println("ans : " + ans);
						finalans = finalans + expression;
					}
					long sumA = 0;
					long sumC = 0;
					// Calculation of apparent length
					int arraybeginA = alenprev;
					int arraybeginC = clenprev;
										
					if ((arraybeginA > -1) && (arraybeginA < p)) {
						for (int t1 = arraybeginA; t1 < p; t1++) {
							long val = A[t1];
							if (val > y) {
								alen = t1;
								break;
							} else {
								sumA = sumA + val;
								if (t1 == p-1) {
									alen = p;
								}
							}
						}
					}
					
					if ((arraybeginC > -1) && (arraybeginC < r)) {
						for (int t2 = arraybeginC; t2 < r; t2++) {
							long val = C[t2];
							if (val > y) {
								clen = t2;
								break;
							} else {
								sumC = sumC + val;
								if (t2 == r-1) {
									clen = r;
								}
							}
						}
					}
					// calculation of apparent length over
					// alen : apparent length of array A
					// clen : apparent length of array C
					// alenprev : apparent length of previous x
					// clenprev : apparent length of previous z
					System.out.println("sumA : " + sumA);
					System.out.println("sumC : " + sumC);
					// initial calculation
				
					long brack1 = (sumA + y*(alen - alenprev)) % mod;
					long brack2 = (sumC + y*(clen - clenprev)) % mod; 
					ans =  (brack1*brack2) % mod;
					System.out.println("brack1 : " + brack1);
					System.out.println("brack2 : " + brack2);
					System.out.println("ans : " + ans);
					System.out.println("alen : " + alen);
					System.out.println("alenprev : " + alenprev);
					System.out.println("clen : " + clen);
					System.out.println("clenprev : " + clenprev);
					
					if ((alen > alenprev) & (alenprev != 0)) {
						System.out.println("alen > alenprev");
						long ans2 = brack1*brack2prev;
					
						System.out.println("brack1 : " + brack1);
						System.out.println("brack2prev : " + brack2prev);
						finalans = finalans + ans2;
					}
					
					if ((clen > clenprev) & (clenprev != 0)) {
						System.out.println("clen > clenprev");
						long ans3 = brack2*brack1prev;
						System.out.println("brack2 : " + brack2);
						System.out.println("brack1prev : " + brack1prev);
						finalans = finalans + ans3;
					}
					
					finalans = finalans + ans;
					
				alenprev = alen;
				clenprev = clen;
				sumAprev = sumAprev + sumA;
				sumCprev = sumCprev + sumC;
				brack1prev = brack1 + brack1prev;
				brack2prev = brack2 + brack2prev;
				yprev = y;
				}
				System.out.println("finalans : " + finalans);
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
