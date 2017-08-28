import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.StringTokenizer;

/**
 * 
 */

/**
 * @author Sarthak Goyal
 * 25-Feb-2017 9:51:18 PM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			Reader.init(System.in);
			int T = Reader.nextInt();
			while (T-- > 0){
				int H = Reader.nextInt();    //No. of stages
				int K = Reader.nextInt();    //Max allowed difference for bribe
				int rounds = powerfunc(2,H);
				int[] input = new int[rounds];
				int i = 1;
				while (i <= rounds) {
					input[i-1] = Reader.nextInt();
				i++;
				}
				int[] array = input;
				int j = H-1;
				int bribe = 0;
				boolean bear = true;;
				while (array.length > 1){
					int newrounds = powerfunc(2,j);
					int[] array2 = new int[newrounds];
					int s = 0;
					for (int z = 0; z < array.length; z++){
						if (z == 0) {
							int diff = array[1] - array[0];
							if (diff < 0) {
								array2[s] = array[z];
								s++;
							} else if (diff < K){
								bribe++;
								array2[s] = array[z];
								s++;
							} else {
								bear = false;
								break;
							}
							
						} else {
							int val1 = array[z];
							int val2 = array[z+1];
							if (val1 < val2) {
								array2[s] = val2;
							} else {
								array2[s] = val1;
							}
							s++;
						}
					z++;
					}//end of for loop
					if (bear == false) {
						break;
					}
					
//					//checl 
//					for (int p = 0; p < array2.length; p++){
//						System.out.print(array2[p] + " ");
//					}
//					System.out.println();
					array = array2;
				j--;	
				} //end of while loop
				if (bear) {
					System.out.println(bribe);
				} else{
					System.out.println(-1);
				}
				
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Exponentiation function
	private static int powerfunc(int base, long index){
		int ans = 1;
		for (int i= 0; i < index; i++){
			ans = ans*base;
		}
		return ans;
		
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

