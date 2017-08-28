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
 * 30-Apr-2017 3:10:55 PM
 * 
 */
public class Main {
	public static void main(String[] args){
		try{
			Reader.init(System.in);
			int T = Reader.nextInt();
			while (T-- > 0) {
				int n = Reader.nextInt();
				int[] inputarray = new int[n];
				for(int i = 0; i < inputarray.length; i++) {
					int val = Reader.nextInt();
					inputarray[i] = val;
				}
				boolean finalstatus = true;
				for (int i = 0; i < inputarray.length; i++){
					int num1 = inputarray[i];
//					System.out.println("i : " + i);
					if ((num1 != 1) && (num1 != 0)){
						for (int j = i+1; j < inputarray.length; j++) {
	//						System.out.println("j : " + j);
							int num2 = inputarray[j];
							if ((num2 != 1) && (num2 != 0)){
								int ans = num1*num2;
								boolean status = false;
								for (int k = 0; k < inputarray.length; k++) {
									int val = inputarray[k];
									if (val == ans) {
										status = true;
										break;
									}
								}
								if (status == false) {
									finalstatus = false;
									break;
								}
							}
						}
					}
					if (finalstatus == false) {
						break;
					}
					
				}
				if (finalstatus == false) {
					System.out.println("no");
				} else {
					System.out.println("yes");
				}
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
