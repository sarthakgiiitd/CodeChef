import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Main.java		Solution to Life, the Universe, and Everything
//Sarthak Goyal
//January 21, 2017
public class Main {
	public static void main(String[] args){
		try {
			Reader.init(System.in);
			int i = 1;
			int input = 0;
			while(i++ > 0) {
				input = Reader.nextInt();
				if (input == 42){
					break;
				}
				System.out.println(input);
			}
		
		
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}

/** Class for buffered reading int and double values */
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
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
	
}