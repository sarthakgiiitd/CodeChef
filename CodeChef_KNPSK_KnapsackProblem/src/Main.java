import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 
 */

/**
 * @author Sarthak Goyal
 * 20-Jul-2017 9:19:30 AM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			Reader.init(System.in);
			int N = Reader.nextInt();
			PriorityQueue<Integer> pq1 = new PriorityQueue<>();
			PriorityQueue<Integer> pq2 = new PriorityQueue<>();
			PriorityQueue<Integer> pq1copy = new PriorityQueue<>();
			PriorityQueue<Integer> pq2copy = new PriorityQueue<>();
			
			int M = 0;
			for (int i1 = 0; i1 < N; i1++) {
				int type = Reader.nextInt();
				M = M+type;
				int val = Reader.nextInt();
				if (type == 1) {
					pq1.add(-val);
					pq1copy.add(-val);
				} else {
					pq2.add(-val);
					pq2copy.add(-val);
				}
			}
			
			int[] array = new int[M+1];
			for (int i = 1; i <= M; i = i+2) {
				if (i == 1) {
					int cost = 0;
					if (pq1.peek() != null) {
						cost = -pq1.remove();
					}
					array[i] = cost;
				} else {
					int way1 = 0;
					boolean flag8 = false;
					if (pq2.peek() != null) {
						way1 = -pq2.peek();
						flag8 = true;
					}
					int val2 = 0;
					boolean flag0 = false;
					if (pq1.peek() != null) {
						val2 = -pq1.remove();
						flag0 = true;
					}
					int way2 = val2;
					boolean flag = false;
					if ((pq1.peek() != null) && (flag0)) {
						way2 = way2 + -pq1.peek();
						flag = true;
					}
					
					if (way1 > way2) {
						int cost2 = array[i-2] + way1;
						if (flag8) {
							pq2.remove();
						}
						if (flag0) {
							pq1.add(-val2);
						}
						array[i] = cost2;
					} else {
						int cost2 = array[i-2] + way2;
						if (flag) {
							pq1.remove();
						}
						array[i] = cost2;
					}
				}
			}
			
			
			for (int j = 2; j <= M; j = j+2) {
				if (j == 2) {
					boolean flag5 = false;
					int val1 = 0;
					if (pq1copy.peek() != null) {
						val1 = -pq1copy.remove();
						flag5 = true;
					}
					int cost1 = val1;
					boolean flag = false;
					if ((pq1copy.peek() != null) && (flag5)) {
						cost1 = cost1 + -pq1copy.peek();
						flag = true;
					}
					int cost2 = 0;
					boolean flag9 = false;
					if (pq2copy.peek() != null) {
						cost2 = -pq2copy.peek();
						flag9 = true;
					}
					if (cost2 > cost1) {
						array[j] = cost2;
						if (flag5) {
							pq1copy.add(-val1);
						}
						if (flag9) {
							pq2copy.remove();
						}
					} else {
						array[j] = cost1;
						if (flag) {
							pq1copy.remove();
						}
					}
					
				} else {
					int way1 = 0;
					boolean flag10 = false;
					if (pq2copy.peek() != null) {
						way1 = -pq2copy.peek();
						flag10 = true;
					}
					int val2 = 0;
					boolean flag0 = false;
					if (pq1copy.peek() != null) {
						val2 = -pq1copy.remove();
						flag0 = true;
					}
					int way2 = val2;
					boolean flag = false;
					if ((pq1copy.peek() != null) && (flag0)){
						way2 = way2 + -pq1copy.peek();
						flag = true;
					}
					
					if (way1 > way2) {
						int cost2 = array[j-2] + way1;
						if (flag10) {
							pq2copy.remove();
						}
						if (flag0) {
							pq1copy.add(-val2);
						}
						array[j] = cost2;
					} else {
						int cost2 = array[j-2] + way2;
						if (flag) {
							pq1copy.remove();
						}
						array[j] = cost2;
					}
				}
			}
			
			
			for (int q = 1; q < array.length; q++) {
				System.out.print(array[q] + " ");
			}
			System.out.println();
			
			
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
