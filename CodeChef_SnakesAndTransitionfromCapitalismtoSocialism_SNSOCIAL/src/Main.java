import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Sarthak Goyal
 * 31-May-2017 10:54:47 PM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			Reader.init(System.in);
			int T = Reader.nextInt();
			while (T-- > 0) {
				int n = Reader.nextInt();
				int m = Reader.nextInt();
				int[][] input = new int[n][m];
				for(int i1 = 0; i1 < n; i1++) {
					for (int j1 = 0; j1 < m; j1++) {
						int num = Reader.nextInt();
						input[i1][j1] = num;
					}
				}
				
				int count = 0;
				int[][] input2 = new int[n][m];
				// main while
				while (!check(n,m,input)) {
					count++;
					for (int i = 0; i < n; i++) {
						for (int j = 0; j < m; j++) {
							int val = input[i][j];
							if (up(i,j,n,m)) {
								int val2 = valup(i,j,n,m,input);
								if (val2 > val) {
									val = val2;
								}
							}
							
							if (down(i,j,n,m)) {
								int val2 = valdown(i,j,n,m,input);
								if (val2 > val) {
									val = val2;
								}
							}
							
							
							if (left(i,j,n,m)) {
								int val2 = valleft(i,j,n,m,input);
								if (val2 > val) {
									val = val2;
								}
							}
							
							if (right(i,j,n,m)) {
								int val2 = valright(i,j,n,m,input);
								if (val2 > val) {
									val = val2;
								}
							}
							
							if (upperleft(i,j,n,m)) {
								int val2 = valupperleft(i,j,n,m,input);
								if (val2 > val) {
									val = val2;
								}
							}
							
							if (upperright(i,j,n,m)) {
								int val2 = valupperright(i,j,n,m,input);
								if (val2 > val) {
									val = val2;
								}
							}
							
							if (downleft(i,j,n,m)) {
								int val2 = valdownleft(i,j,n,m,input);
								if (val2 > val) {
									val = val2;
								}
							}
							
							if (downright(i,j,n,m)) {
								int val2 = valdownright(i,j,n,m,input);
								if (val2 > val) {
									val = val2;
								}
							}
							input2[i][j] = val;
						}
					}
					//System.out.println("input2 data");
					//print(n,m,input2);
				//	System.out.println("Hello");
					for(int q = 0; q < n; q++) {
						for (int s = 0; s < m; s++) {
							int val = input2[q][s];
							input[q][s] = val;
						}
					}
					
					//System.out.println("input data");
					//print(n,m,input);
					
				}// while end
				System.out.println(count);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void print(int n, int m,int[][] matrix) {
		for (int i = 0; i < n; i++) {
			for (int j =0; j < m; j++) {
				int val = matrix[i][j];
				System.out.print(val);
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static boolean check(int n, int m, int[][] matrix) {
		int val = matrix[0][0];
		for(int i =0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				int val2 = matrix[i][j];
				if (val2 != val) {
					return false;
				}
			}
		}
		return true;
	}
	
	private static boolean up(int i, int j, int n, int m) {
		if (i - 1 >= 0) {
			return true;
		}
		return false;
	}
	
	private static boolean down(int i, int j, int n, int m) {
		if (i + 1 < n) {
			return true;
		}
		return false;
	}
	
	private static boolean left(int i, int j, int n, int m) {
		if (j - 1 >= 0) {
			return true;
		}
		return false;
	}
	
	private static boolean right(int i, int j, int n, int m) {
		if (j + 1 < m) {
			return true;
		}
		return false;
	}
	
	private static boolean upperleft(int i, int j, int n, int m) {
		if ((i - 1 >= 0) && (j - 1 >= 0)) {
			return true;
		}
		return false;
	}
	
	private static boolean upperright(int i, int j, int n, int m) {
		if ((i - 1 >= 0) && (j + 1 < m)) {
			return true;
		}
		return false;
	}
	
	private static boolean downleft(int i, int j, int n, int m) {
		if ((i + 1 < n) && (j - 1 >= 0)) {
			return true;
		}
		return false;
	}
	
	private static boolean downright(int i, int j, int n, int m) {
		if ((i + 1 < n) && (j + 1 < m)) {
			return true;
		}
		return false;
	}
	

	private static int valup(int i, int j, int n, int m, int[][] matrix) {
		int val = matrix[i-1][j];
		return val;
	}
	
	private static int valdown(int i, int j, int n, int m, int[][] matrix) {
		int val = matrix[i+1][j];
		return val;
	}
	
	private static int valleft(int i, int j, int n, int m, int[][] matrix) {
		int val = matrix[i][j-1];
		return val;
	}
	
	private static int valright(int i, int j, int n, int m, int[][] matrix) {
		int val = matrix[i][j+1];
		return val;
	}
	
	private static int valupperleft(int i, int j, int n, int m, int[][] matrix) {
		int val = matrix[i-1][j-1];
		return val;
	}
	
	private static int valupperright(int i, int j, int n, int m, int[][] matrix) {
		int val = matrix[i-1][j+1];
		return val;
	}
	
	private static int valdownleft(int i, int j, int n, int m, int[][] matrix) {
		int val = matrix[i+1][j-1];
		return val;
	}
	
	private static int valdownright(int i, int j, int n, int m, int[][] matrix) {
		int val = matrix[i+1][j+1];
		return val;
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



