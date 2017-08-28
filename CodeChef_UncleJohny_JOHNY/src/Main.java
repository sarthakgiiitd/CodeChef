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
 * 12-May-2017 11:35:21 AM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			Reader.init(System.in);
			int T = Reader.nextInt();
			while (T-- > 0) {
				int N = Reader.nextInt();
				int[] input = new int[N];
				for (int i = 0; i < N; i++) {
					int num = Reader.nextInt();
					input[i] = num;
				}
				int K = Reader.nextInt();		//initial position of uncle johny
				int johnylen = input[K-1];
				MergeSort array = new MergeSort(input);
				int len = input.length;
				array.sort(input, len);
				int ans = 0;
				for (int i = 0; i < N; i++) {
					int val = input[i];
					if (val == johnylen) {
						ans = i;
					}
				}
				System.out.println(ans+1);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class MergeSort {
	private int[] A;
	private int[] aux;
	private int n;
	
	public MergeSort(int[] array) {
		this.A = array;
	}
	public void sort(int[] A, int n) {
		this.A = A;
		this.aux = new int[n];
		mergesort(0,n-1);
	}
	
	private void mergesort(int low, int high) {
		if (low < high) {
			int middle = (low + high)/2;
			mergesort(low, middle);
			mergesort(middle+1, high);
			
			//Combine both the sorted arrays
			merge(low, middle, high);
		}
	}
	
	private void merge(int low, int middle, int high) {
		//Copy contents of A into aux array
		for (int i = low; i <= high; i++) {
			aux[i] = A[i];
		}
		int i = low;
		int j = middle+1;
		int k  = low;
		//Copy the smallest element from either sub arrays into A
		while ((i <= middle) && (j <= high)) {
			if (aux[i] <= aux[j]) {
				A[k] = aux[i];
				i++;
			} else {
				A[k] = aux[j];
				j++;
			}
			k++;
		}
		
		//Copy the rest of the elements
		while (i <= middle) {
			A[k] = aux[i];
			k++;
			i++;
		}
		
		while (j <= high) {
			A[k] = aux[j];
			k++;
			j++;
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
